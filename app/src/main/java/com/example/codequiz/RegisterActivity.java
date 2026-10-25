package com.example.codequiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.codequiz.database.UserRepository;
import com.example.codequiz.util.SessionManager;
import com.example.codequiz.util.ValidationUtils;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout tilFullName, tilEmail, tilUsername, tilRegPassword, tilConfirmPassword;
    private TextInputEditText etFullName, etEmail, etUsername, etRegPassword, etConfirmPassword;
    private MaterialButton btnRegister;
    private TextView tvGoToLogin;

    private UserRepository userRepository;
    private SessionManager sessionManager;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userRepository = new UserRepository(this);
        sessionManager = SessionManager.getInstance(this);

        initViews();
        setupListeners();
    }

    private void initViews() {
        tilFullName = findViewById(R.id.tilFullName);
        tilEmail = findViewById(R.id.tilEmail);
        tilUsername = findViewById(R.id.tilUsername);
        tilRegPassword = findViewById(R.id.tilRegPassword);
        tilConfirmPassword = findViewById(R.id.tilConfirmPassword);

        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etUsername = findViewById(R.id.etUsername);
        etRegPassword = findViewById(R.id.etRegPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);

        btnRegister = findViewById(R.id.btnRegister);
        tvGoToLogin = findViewById(R.id.tvGoToLogin);
    }

    private void setupListeners() {
        btnRegister.setOnClickListener(v -> performRegistration());

        tvGoToLogin.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void performRegistration() {
        String fullName = etFullName.getText() != null ? etFullName.getText().toString().trim() : "";
        String email = etEmail.getText() != null ? etEmail.getText().toString().trim() : "";
        String username = etUsername.getText() != null ? etUsername.getText().toString().trim() : "";
        String password = etRegPassword.getText() != null ? etRegPassword.getText().toString().trim() : "";
        String confirmPassword = etConfirmPassword.getText() != null ? etConfirmPassword.getText().toString().trim() : "";

        tilFullName.setError(null);
        tilEmail.setError(null);
        tilUsername.setError(null);
        tilRegPassword.setError(null);
        tilConfirmPassword.setError(null);

        boolean isValid = true;

        if (!ValidationUtils.isNotEmpty(fullName)) {
            tilFullName.setError("Full name is required");
            isValid = false;
        }

        if (!ValidationUtils.isValidEmail(email)) {
            tilEmail.setError("Enter a valid email address");
            isValid = false;
        }

        if (!ValidationUtils.isValidUsername(username)) {
            tilUsername.setError("Username must be 3-20 letters, digits or underscores");
            isValid = false;
        }

        if (!ValidationUtils.isValidPassword(password)) {
            tilRegPassword.setError("Password must be at least 6 characters");
            isValid = false;
        }

        if (!password.equals(confirmPassword)) {
            tilConfirmPassword.setError("Passwords do not match");
            isValid = false;
        }

        if (!isValid) return;

        btnRegister.setEnabled(false);
        btnRegister.setText("Creating account...");

        executor.execute(() -> {
            // Check duplicates
            if (userRepository.isEmailTaken(email)) {
                runOnUiThread(() -> {
                    btnRegister.setEnabled(true);
                    btnRegister.setText("Register");
                    tilEmail.setError("This email address is already registered");
                });
                return;
            }

            if (userRepository.isUsernameTaken(username)) {
                runOnUiThread(() -> {
                    btnRegister.setEnabled(true);
                    btnRegister.setText("Register");
                    tilUsername.setError("This username is already taken");
                });
                return;
            }

            // Register user in SQLite
            long userId = userRepository.registerUser(fullName, email, username, password);

            runOnUiThread(() -> {
                btnRegister.setEnabled(true);
                btnRegister.setText("Register");

                if (userId != -1) {
                    sessionManager.createLoginSession(userId, username, email, fullName);
                    Toast.makeText(RegisterActivity.this, "Account created successfully!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(RegisterActivity.this, DashboardActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, "Registration failed. Please try again.", Toast.LENGTH_LONG).show();
                }
            });
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executor.shutdown();
    }
}
