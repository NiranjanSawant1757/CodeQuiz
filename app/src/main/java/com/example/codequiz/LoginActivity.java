package com.example.codequiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.codequiz.database.UserRepository;
import com.example.codequiz.model.User;
import com.example.codequiz.util.SessionManager;
import com.example.codequiz.util.ValidationUtils;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout tilEmailOrUsername, tilPassword;
    private TextInputEditText etEmailOrUsername, etPassword;
    private MaterialButton btnLogin;
    private TextView tvGoToRegister;

    private UserRepository userRepository;
    private SessionManager sessionManager;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userRepository = new UserRepository(this);
        sessionManager = SessionManager.getInstance(this);

        initViews();
        setupListeners();
    }

    private void initViews() {
        tilEmailOrUsername = findViewById(R.id.tilEmailOrUsername);
        tilPassword = findViewById(R.id.tilPassword);
        etEmailOrUsername = findViewById(R.id.etEmailOrUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvGoToRegister = findViewById(R.id.tvGoToRegister);
    }

    private void setupListeners() {
        btnLogin.setOnClickListener(v -> performLogin());

        tvGoToRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void performLogin() {
        String identifier = etEmailOrUsername.getText() != null ? etEmailOrUsername.getText().toString().trim() : "";
        String password = etPassword.getText() != null ? etPassword.getText().toString().trim() : "";

        tilEmailOrUsername.setError(null);
        tilPassword.setError(null);

        boolean isValid = true;

        if (!ValidationUtils.isNotEmpty(identifier)) {
            tilEmailOrUsername.setError("Email or Username is required");
            isValid = false;
        }

        if (!ValidationUtils.isNotEmpty(password)) {
            tilPassword.setError("Password is required");
            isValid = false;
        }

        if (!isValid) return;

        btnLogin.setEnabled(false);
        btnLogin.setText("Logging in...");

        executor.execute(() -> {
            User user = userRepository.login(identifier, password);
            runOnUiThread(() -> {
                btnLogin.setEnabled(true);
                btnLogin.setText("Login");

                if (user != null) {
                    sessionManager.createLoginSession(user.getId(), user.getUsername(), user.getEmail(), user.getFullName());
                    Toast.makeText(LoginActivity.this, "Welcome, " + user.getFullName() + "!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid credentials. Please try again.", Toast.LENGTH_LONG).show();
                    tilPassword.setError("Incorrect username/email or password");
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
