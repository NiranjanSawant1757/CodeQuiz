package com.example.codequiz;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.codequiz.database.UserRepository;
import com.example.codequiz.util.DialogHelper;
import com.example.codequiz.util.SessionManager;
import com.example.codequiz.util.ValidationUtils;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProfileActivity extends AppCompatActivity {

    private ShapeableImageView ivProfileAvatar;
    private FrameLayout layoutAvatarContainer, btnChangeAvatarBadge;
    private TextView tvProfileFullName, tvProfileUsername, tvProfileEmail;
    private TextInputLayout tilEditName, tilOldPassword, tilNewPassword;
    private TextInputEditText etEditName, etOldPassword, etNewPassword;
    private MaterialButton btnSaveName, btnChangePassword, btnLogout;

    private SessionManager sessionManager;
    private UserRepository userRepository;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    private ActivityResultLauncher<String> requestCameraPermissionLauncher;
    private ActivityResultLauncher<Uri> takePictureLauncher;
    private ActivityResultLauncher<String> pickImageLauncher;
    private File tempCameraFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sessionManager = SessionManager.getInstance(this);
        if (!sessionManager.isLoggedIn()) {
            redirectToLogin();
            return;
        }

        setContentView(R.layout.activity_profile);
        userRepository = new UserRepository(this);

        Toolbar toolbar = findViewById(R.id.toolbarProfile);
        toolbar.setNavigationOnClickListener(v -> finish());

        setupPhotoLaunchers();
        initViews();
        displayUserData();
        setupListeners();
    }

    private void setupPhotoLaunchers() {
        requestCameraPermissionLauncher = registerForActivityResult(
                new ActivityResultContracts.RequestPermission(),
                isGranted -> {
                    if (isGranted) {
                        launchCameraCapture();
                    } else {
                        Toast.makeText(this, "Camera permission is required to take a selfie", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        takePictureLauncher = registerForActivityResult(
                new ActivityResultContracts.TakePicture(),
                success -> {
                    if (Boolean.TRUE.equals(success) && tempCameraFile != null && tempCameraFile.exists()) {
                        processCapturedPhoto(tempCameraFile);
                    }
                }
        );

        pickImageLauncher = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                uri -> {
                    if (uri != null) {
                        processGalleryPhoto(uri);
                    }
                }
        );
    }

    private void redirectToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void initViews() {
        ivProfileAvatar = findViewById(R.id.ivProfileAvatar);
        layoutAvatarContainer = findViewById(R.id.layoutAvatarContainer);
        btnChangeAvatarBadge = findViewById(R.id.btnChangeAvatarBadge);

        tvProfileFullName = findViewById(R.id.tvProfileFullName);
        tvProfileUsername = findViewById(R.id.tvProfileUsername);
        tvProfileEmail = findViewById(R.id.tvProfileEmail);

        tilEditName = findViewById(R.id.tilEditName);
        etEditName = findViewById(R.id.etEditName);
        btnSaveName = findViewById(R.id.btnSaveName);

        tilOldPassword = findViewById(R.id.tilOldPassword);
        etOldPassword = findViewById(R.id.etOldPassword);
        tilNewPassword = findViewById(R.id.tilNewPassword);
        etNewPassword = findViewById(R.id.etNewPassword);
        btnChangePassword = findViewById(R.id.btnChangePassword);

        btnLogout = findViewById(R.id.btnLogout);
    }

    private void displayUserData() {
        String name = sessionManager.getFullName();
        String username = sessionManager.getUsername();
        String email = sessionManager.getEmail();

        tvProfileFullName.setText(name.isEmpty() ? username : name);
        tvProfileUsername.setText("@" + username);
        tvProfileEmail.setText(email);
        etEditName.setText(name);

        String savedImagePath = sessionManager.getProfileImage();
        if (savedImagePath != null && !savedImagePath.trim().isEmpty()) {
            loadAvatar(savedImagePath);
        } else {
            executor.execute(() -> {
                String dbImagePath = userRepository.getProfileImage(sessionManager.getUserId());
                if (dbImagePath != null && !dbImagePath.trim().isEmpty()) {
                    sessionManager.updateProfileImage(dbImagePath);
                    runOnUiThread(() -> loadAvatar(dbImagePath));
                } else {
                    runOnUiThread(() -> ivProfileAvatar.setImageResource(R.drawable.ic_profile));
                }
            });
        }
    }

    private void setupListeners() {
        View.OnClickListener photoClickListener = v -> showPhotoPickerDialog();
        layoutAvatarContainer.setOnClickListener(photoClickListener);
        btnChangeAvatarBadge.setOnClickListener(photoClickListener);

        btnSaveName.setOnClickListener(v -> saveDisplayName());
        btnChangePassword.setOnClickListener(v -> performChangePassword());
        btnLogout.setOnClickListener(v -> confirmLogout());
    }

    private void showPhotoPickerDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_photo_picker, null);
        MaterialCardView cardOptionCamera = view.findViewById(R.id.cardOptionCamera);
        MaterialCardView cardOptionGallery = view.findViewById(R.id.cardOptionGallery);
        MaterialButton btnCancel = view.findViewById(R.id.btnCancelPhotoDialog);

        AlertDialog dialog = new MaterialAlertDialogBuilder(this)
                .setView(view)
                .setCancelable(true)
                .create();

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        cardOptionCamera.setOnClickListener(v -> {
            dialog.dismiss();
            checkCameraPermissionAndLaunch();
        });

        cardOptionGallery.setOnClickListener(v -> {
            dialog.dismiss();
            pickImageLauncher.launch("image/*");
        });

        btnCancel.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }

    private void checkCameraPermissionAndLaunch() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            launchCameraCapture();
        } else {
            requestCameraPermissionLauncher.launch(Manifest.permission.CAMERA);
        }
    }

    private void launchCameraCapture() {
        try {
            File photoDir = new File(getFilesDir(), "profile_photos");
            if (!photoDir.exists()) {
                photoDir.mkdirs();
            }
            tempCameraFile = new File(photoDir, "temp_selfie_" + System.currentTimeMillis() + ".jpg");
            Uri cameraUri = FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", tempCameraFile);
            takePictureLauncher.launch(cameraUri);
        } catch (Exception e) {
            Toast.makeText(this, "Failed to start camera: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void processCapturedPhoto(File sourceFile) {
        executor.execute(() -> {
            try {
                long userId = sessionManager.getUserId();
                File photoDir = new File(getFilesDir(), "profile_photos");
                if (!photoDir.exists()) {
                    photoDir.mkdirs();
                }
                File destFile = new File(photoDir, "user_photo_" + userId + ".jpg");

                try (InputStream in = new FileInputStream(sourceFile);
                     OutputStream out = new FileOutputStream(destFile)) {
                    byte[] buffer = new byte[8192];
                    int len;
                    while ((len = in.read(buffer)) > 0) {
                        out.write(buffer, 0, len);
                    }
                    out.flush();
                }

                if (sourceFile.exists()) {
                    sourceFile.delete();
                }

                String savedPath = destFile.getAbsolutePath();
                userRepository.updateProfileImage(userId, savedPath);
                sessionManager.updateProfileImage(savedPath);

                runOnUiThread(() -> {
                    loadAvatar(savedPath);
                    Toast.makeText(ProfileActivity.this, "Profile photo updated!", Toast.LENGTH_SHORT).show();
                });
            } catch (Exception e) {
                runOnUiThread(() -> Toast.makeText(ProfileActivity.this, "Error saving photo: " + e.getMessage(), Toast.LENGTH_SHORT).show());
            }
        });
    }

    private void processGalleryPhoto(Uri sourceUri) {
        executor.execute(() -> {
            try {
                long userId = sessionManager.getUserId();
                File photoDir = new File(getFilesDir(), "profile_photos");
                if (!photoDir.exists()) {
                    photoDir.mkdirs();
                }
                File destFile = new File(photoDir, "user_photo_" + userId + ".jpg");

                try (InputStream in = getContentResolver().openInputStream(sourceUri);
                     OutputStream out = new FileOutputStream(destFile)) {
                    if (in == null) throw new Exception("Unable to open selected image");
                    byte[] buffer = new byte[8192];
                    int len;
                    while ((len = in.read(buffer)) > 0) {
                        out.write(buffer, 0, len);
                    }
                    out.flush();
                }

                String savedPath = destFile.getAbsolutePath();
                userRepository.updateProfileImage(userId, savedPath);
                sessionManager.updateProfileImage(savedPath);

                runOnUiThread(() -> {
                    loadAvatar(savedPath);
                    Toast.makeText(ProfileActivity.this, "Profile photo updated!", Toast.LENGTH_SHORT).show();
                });
            } catch (Exception e) {
                runOnUiThread(() -> Toast.makeText(ProfileActivity.this, "Error loading image: " + e.getMessage(), Toast.LENGTH_SHORT).show());
            }
        });
    }

    private void loadAvatar(String path) {
        if (path != null && !path.trim().isEmpty()) {
            File file = new File(path);
            if (file.exists()) {
                Glide.with(this)
                        .load(file)
                        .circleCrop()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
                        .placeholder(R.drawable.ic_profile)
                        .error(R.drawable.ic_profile)
                        .into(ivProfileAvatar);
                return;
            }
        }
        ivProfileAvatar.setImageResource(R.drawable.ic_profile);
    }

    private void saveDisplayName() {
        String newName = etEditName.getText() != null ? etEditName.getText().toString().trim() : "";
        tilEditName.setError(null);

        if (!ValidationUtils.isNotEmpty(newName)) {
            tilEditName.setError("Name cannot be empty");
            return;
        }

        btnSaveName.setEnabled(false);
        executor.execute(() -> {
            long userId = sessionManager.getUserId();
            boolean success = userRepository.updateFullName(userId, newName);

            runOnUiThread(() -> {
                btnSaveName.setEnabled(true);
                if (success) {
                    sessionManager.updateFullName(newName);
                    tvProfileFullName.setText(newName);
                    Toast.makeText(ProfileActivity.this, "Display name updated successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ProfileActivity.this, "Failed to update name.", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    private void performChangePassword() {
        String oldPass = etOldPassword.getText() != null ? etOldPassword.getText().toString().trim() : "";
        String newPass = etNewPassword.getText() != null ? etNewPassword.getText().toString().trim() : "";

        tilOldPassword.setError(null);
        tilNewPassword.setError(null);

        boolean isValid = true;
        if (!ValidationUtils.isNotEmpty(oldPass)) {
            tilOldPassword.setError("Current password is required");
            isValid = false;
        }

        if (!ValidationUtils.isValidPassword(newPass)) {
            tilNewPassword.setError("New password must be at least 6 characters");
            isValid = false;
        }

        if (!isValid) return;

        btnChangePassword.setEnabled(false);
        executor.execute(() -> {
            long userId = sessionManager.getUserId();
            boolean success = userRepository.changePassword(userId, oldPass, newPass);

            runOnUiThread(() -> {
                btnChangePassword.setEnabled(true);
                if (success) {
                    etOldPassword.setText("");
                    etNewPassword.setText("");
                    Toast.makeText(ProfileActivity.this, "Password updated successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    tilOldPassword.setError("Current password is incorrect");
                }
            });
        });
    }

    private void confirmLogout() {
        DialogHelper.showLogoutDialog(this, () -> {
            sessionManager.logoutUser();
            Toast.makeText(ProfileActivity.this, "Logged out successfully", Toast.LENGTH_SHORT).show();
            redirectToLogin();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executor.shutdown();
    }
}
