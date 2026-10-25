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
import com.example.codequiz.util.SessionManager;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.materialswitch.MaterialSwitch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SettingsActivity extends AppCompatActivity {

    private MaterialSwitch switchDefaultTimer;
    private RadioGroup rgThemeOptions;
    private RadioButton rbThemeSystem, rbThemeLight, rbThemeDark;
    private MaterialButton btnClearHistory;

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
