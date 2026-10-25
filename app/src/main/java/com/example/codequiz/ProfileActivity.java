package com.example.codequiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.codequiz.database.UserRepository;
import com.example.codequiz.util.SessionManager;
import com.example.codequiz.util.ValidationUtils;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProfileActivity extends AppCompatActivity {

    private TextView tvProfileFullName, tvProfileUsername, tvProfileEmail;
    private TextInputLayout tilEditName, tilOldPassword, tilNewPassword;
    private TextInputEditText etEditName, etOldPassword, etNewPassword;
    private MaterialButton btnSaveName, btnChangePassword, btnLogout;

    private SessionManager sessionManager;
    private UserRepository userRepository;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

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

        initViews();
        displayUserData();
        setupListeners();
    }

    private void redirectToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void initViews() {
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
    }

    private void setupListeners() {
        btnSaveName.setOnClickListener(v -> saveDisplayName());
        btnChangePassword.setOnClickListener(v -> performChangePassword());
        btnLogout.setOnClickListener(v -> confirmLogout());
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
        new AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Are you sure you want to log out of CodeQuiz?")
                .setPositiveButton("Logout", (dialog, which) -> {
                    sessionManager.logoutUser();
                    Toast.makeText(ProfileActivity.this, "Logged out successfully", Toast.LENGTH_SHORT).show();
                    redirectToLogin();
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executor.shutdown();
    }
}
