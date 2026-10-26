package com.example.codequiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import com.example.codequiz.database.QuizAttemptRepository;
import com.example.codequiz.network.AiApiClient;
import com.example.codequiz.util.SessionManager;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONObject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SettingsActivity extends AppCompatActivity {

    private MaterialSwitch switchDefaultTimer;
    private RadioGroup rgThemeOptions;
    private RadioButton rbThemeSystem, rbThemeLight, rbThemeDark;
    private MaterialButton btnClearHistory;

    // AI Backend Configuration Views
    private TextInputEditText etBackendUrl;
    private MaterialButton btnSaveBackendUrl, btnTestBackendConnection;

    private SessionManager sessionManager;
    private QuizAttemptRepository repository;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sessionManager = SessionManager.getInstance(this);
        if (!sessionManager.isLoggedIn()) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
            return;
        }

        setContentView(R.layout.activity_settings);
        repository = new QuizAttemptRepository(this);

        Toolbar toolbar = findViewById(R.id.toolbarSettings);
        toolbar.setNavigationOnClickListener(v -> finish());

        initViews();
        loadCurrentSettings();
        setupListeners();
    }

    private void initViews() {
        switchDefaultTimer = findViewById(R.id.switchDefaultTimer);
        rgThemeOptions = findViewById(R.id.rgThemeOptions);
        rbThemeSystem = findViewById(R.id.rbThemeSystem);
        rbThemeLight = findViewById(R.id.rbThemeLight);
        rbThemeDark = findViewById(R.id.rbThemeDark);
        btnClearHistory = findViewById(R.id.btnClearHistory);

        etBackendUrl = findViewById(R.id.etBackendUrl);
        btnSaveBackendUrl = findViewById(R.id.btnSaveBackendUrl);
        btnTestBackendConnection = findViewById(R.id.btnTestBackendConnection);
    }

    private void loadCurrentSettings() {
        switchDefaultTimer.setChecked(sessionManager.isTimerEnabled());

        int currentTheme = sessionManager.getThemeMode();
        if (currentTheme == AppCompatDelegate.MODE_NIGHT_YES) {
            rbThemeDark.setChecked(true);
        } else if (currentTheme == AppCompatDelegate.MODE_NIGHT_NO) {
            rbThemeLight.setChecked(true);
        } else {
            rbThemeSystem.setChecked(true);
        }

        etBackendUrl.setText(sessionManager.getBackendUrl());
    }

    private void setupListeners() {
        switchDefaultTimer.setOnCheckedChangeListener((buttonView, isChecked) -> {
            sessionManager.setTimerEnabled(isChecked);
            Toast.makeText(this, isChecked ? "Timer enabled by default" : "Timer disabled by default", Toast.LENGTH_SHORT).show();
        });

        rgThemeOptions.setOnCheckedChangeListener((group, checkedId) -> {
            int selectedMode;
            if (checkedId == R.id.rbThemeDark) {
                selectedMode = AppCompatDelegate.MODE_NIGHT_YES;
            } else if (checkedId == R.id.rbThemeLight) {
                selectedMode = AppCompatDelegate.MODE_NIGHT_NO;
            } else {
                selectedMode = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;
            }

            sessionManager.setThemeMode(selectedMode);
        });

        btnClearHistory.setOnClickListener(v -> confirmClearHistory());

        btnSaveBackendUrl.setOnClickListener(v -> {
            if (etBackendUrl.getText() != null) {
                String newUrl = etBackendUrl.getText().toString().trim();
                if (newUrl.isEmpty()) {
                    Toast.makeText(this, "Backend URL cannot be blank.", Toast.LENGTH_SHORT).show();
                    return;
                }
                sessionManager.setBackendUrl(newUrl);
                Toast.makeText(this, "Backend URL saved successfully.", Toast.LENGTH_SHORT).show();
            }
        });

        btnTestBackendConnection.setOnClickListener(v -> testBackendHealth());
    }

    private void testBackendHealth() {
        if (etBackendUrl.getText() != null) {
            String newUrl = etBackendUrl.getText().toString().trim();
            if (!newUrl.isEmpty()) {
                sessionManager.setBackendUrl(newUrl);
            }
        }

        btnTestBackendConnection.setEnabled(false);
        btnTestBackendConnection.setText("Connecting...");

        executor.execute(() -> {
            try {
                JSONObject health = AiApiClient.checkServerHealth(SettingsActivity.this);
                boolean aiConfigured = health.optBoolean("ai_configured", false);
                String model = health.optString("model", "Unknown");

                runOnUiThread(() -> {
                    btnTestBackendConnection.setEnabled(true);
                    btnTestBackendConnection.setText("Test Connection");

                    String message = "Backend Connected Successfully!\n\n"
                            + "Service: " + health.optString("service", "CodeQuiz AI Backend") + "\n"
                            + "Configured Model: " + model + "\n"
                            + "AI API Key Set on Backend: " + (aiConfigured ? "Yes" : "No (Set in backend .env)");

                    new AlertDialog.Builder(SettingsActivity.this)
                            .setTitle("Server Health Check")
                            .setMessage(message)
                            .setPositiveButton("OK", null)
                            .show();
                });
            } catch (Exception e) {
                final String err = e.getMessage() != null ? e.getMessage() : "Connection failed";
                runOnUiThread(() -> {
                    btnTestBackendConnection.setEnabled(true);
                    btnTestBackendConnection.setText("Test Connection");

                    new AlertDialog.Builder(SettingsActivity.this)
                            .setTitle("Connection Failed")
                            .setMessage("Could not reach backend:\n\n" + err + "\n\nPlease ensure your Python FastAPI server is running with 'uvicorn main:app --host 0.0.0.0 --port 8000'.")
                            .setPositiveButton("OK", null)
                            .show();
                });
            }
        });
    }

    private void confirmClearHistory() {
        new AlertDialog.Builder(this)
                .setTitle("Clear History")
                .setMessage("Are you sure you want to permanently clear all your quiz attempts? This action cannot be undone.")
                .setPositiveButton("Clear History", (dialog, which) -> {
                    long userId = sessionManager.getUserId();
                    executor.execute(() -> {
                        boolean cleared = repository.clearHistory(userId);
                        runOnUiThread(() -> {
                            if (cleared) {
                                Toast.makeText(SettingsActivity.this, "Your quiz history has been cleared.", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(SettingsActivity.this, "Failed to clear history.", Toast.LENGTH_SHORT).show();
                            }
                        });
                    });
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
