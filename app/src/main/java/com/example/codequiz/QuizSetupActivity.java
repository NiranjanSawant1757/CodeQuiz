package com.example.codequiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.example.codequiz.data.QuestionBank;
import com.example.codequiz.model.QuizCategory;
import com.example.codequiz.util.AppConstants;
import com.example.codequiz.util.SessionManager;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.materialswitch.MaterialSwitch;

import java.util.List;

public class QuizSetupActivity extends AppCompatActivity {

    private String categoryName = AppConstants.CAT_JAVA;
    private int selectedCount = AppConstants.COUNT_10;
    private String selectedDifficulty = AppConstants.DIFFICULTY_MIXED;

    private ImageView ivSetupCatIcon;
    private TextView tvSetupCatName, tvSetupCatCount, tvAvailableStatus;
    private TextView chipCount10, chipCount20, chipCount30, chipCount50;
    private TextView chipDiffEasy, chipDiffMedium, chipDiffHard, chipDiffMixed;
    private MaterialSwitch switchTimer;
    private MaterialButton btnStartQuizNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Auth guard
        if (!SessionManager.getInstance(this).isLoggedIn()) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
            return;
        }

        setContentView(R.layout.activity_quiz_setup);

        if (getIntent().hasExtra(AppConstants.EXTRA_CATEGORY)) {
            categoryName = getIntent().getStringExtra(AppConstants.EXTRA_CATEGORY);
        }

        Toolbar toolbar = findViewById(R.id.toolbarSetup);
        toolbar.setTitle(categoryName + " Setup");
        toolbar.setNavigationOnClickListener(v -> finish());

        initViews();
        setupCategoryInfo();
        setupChipListeners();
        updateValidationState();
    }

    private void initViews() {
        ivSetupCatIcon = findViewById(R.id.ivSetupCatIcon);
        tvSetupCatName = findViewById(R.id.tvSetupCatName);
        tvSetupCatCount = findViewById(R.id.tvSetupCatCount);
        tvAvailableStatus = findViewById(R.id.tvAvailableStatus);

        chipCount10 = findViewById(R.id.chipCount10);
        chipCount20 = findViewById(R.id.chipCount20);
        chipCount30 = findViewById(R.id.chipCount30);
        chipCount50 = findViewById(R.id.chipCount50);

        chipDiffEasy = findViewById(R.id.chipDiffEasy);
        chipDiffMedium = findViewById(R.id.chipDiffMedium);
        chipDiffHard = findViewById(R.id.chipDiffHard);
        chipDiffMixed = findViewById(R.id.chipDiffMixed);

        switchTimer = findViewById(R.id.switchTimer);
        switchTimer.setChecked(SessionManager.getInstance(this).isTimerEnabled());

        btnStartQuizNow = findViewById(R.id.btnStartQuizNow);
    }

    private void setupCategoryInfo() {
        tvSetupCatName.setText(categoryName);
        int totalCatQuestions = QuestionBank.getCount(categoryName);
        tvSetupCatCount.setText("Total " + totalCatQuestions + " questions in bank");

        // Find icon
        List<QuizCategory> categories = QuestionBank.getCategories();
        for (QuizCategory cat : categories) {
            if (cat.getName().equals(categoryName)) {
                ivSetupCatIcon.setImageResource(cat.getIconResId());
                break;
            }
        }
    }

    private void setupChipListeners() {
        // Question Counts
        chipCount10.setOnClickListener(v -> selectCount(AppConstants.COUNT_10));
        chipCount20.setOnClickListener(v -> selectCount(AppConstants.COUNT_20));
        chipCount30.setOnClickListener(v -> selectCount(AppConstants.COUNT_30));
        chipCount50.setOnClickListener(v -> selectCount(AppConstants.COUNT_50));

        // Difficulty levels (mapped to Beginner, Intermediate, Advanced, Mixed)
        chipDiffEasy.setOnClickListener(v -> selectDifficulty(AppConstants.DIFFICULTY_BEGINNER));
        chipDiffMedium.setOnClickListener(v -> selectDifficulty(AppConstants.DIFFICULTY_INTERMEDIATE));
        chipDiffHard.setOnClickListener(v -> selectDifficulty(AppConstants.DIFFICULTY_ADVANCED));
        chipDiffMixed.setOnClickListener(v -> selectDifficulty(AppConstants.DIFFICULTY_MIXED));

        // Start quiz
        btnStartQuizNow.setOnClickListener(v -> {
            int available = QuestionBank.getAvailableCount(categoryName, getStaticBankDifficulty(selectedDifficulty));
            if (selectedCount > available) {
                Toast.makeText(this, "Not enough eligible questions in " + categoryName + " for " + selectedDifficulty, Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(QuizSetupActivity.this, QuizActivity.class);
            intent.putExtra(AppConstants.EXTRA_CATEGORY, categoryName);
            intent.putExtra(AppConstants.EXTRA_DIFFICULTY, getStaticBankDifficulty(selectedDifficulty));
            intent.putExtra(AppConstants.EXTRA_QUESTION_COUNT, selectedCount);
            intent.putExtra(AppConstants.EXTRA_TIMER_ENABLED, switchTimer.isChecked());
            startActivity(intent);
        });
    }

    private void selectCount(int count) {
        selectedCount = count;
        setChipStyle(chipCount10, count == AppConstants.COUNT_10);
        setChipStyle(chipCount20, count == AppConstants.COUNT_20);
        setChipStyle(chipCount30, count == AppConstants.COUNT_30);
        setChipStyle(chipCount50, count == AppConstants.COUNT_50);
        updateValidationState();
    }

    private void selectDifficulty(String diff) {
        selectedDifficulty = diff;
        boolean isBeg = diff.equalsIgnoreCase(AppConstants.DIFFICULTY_BEGINNER) || diff.equalsIgnoreCase(AppConstants.DIFFICULTY_EASY);
        boolean isInt = diff.equalsIgnoreCase(AppConstants.DIFFICULTY_INTERMEDIATE) || diff.equalsIgnoreCase(AppConstants.DIFFICULTY_MEDIUM);
        boolean isAdv = diff.equalsIgnoreCase(AppConstants.DIFFICULTY_ADVANCED) || diff.equalsIgnoreCase(AppConstants.DIFFICULTY_HARD);
        boolean isMix = diff.equalsIgnoreCase(AppConstants.DIFFICULTY_MIXED);

        setChipStyle(chipDiffEasy, isBeg);
        setChipStyle(chipDiffMedium, isInt);
        setChipStyle(chipDiffHard, isAdv);
        setChipStyle(chipDiffMixed, isMix);
        updateValidationState();
    }

    private void setChipStyle(TextView view, boolean isSelected) {
        if (isSelected) {
            view.setBackgroundResource(R.drawable.bg_chip_selected);
            view.setTextColor(ContextCompat.getColor(this, R.color.white));
        } else {
            view.setBackgroundResource(R.drawable.bg_chip_unselected);
            view.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
        }
    }

    private void updateValidationState() {
        String bankDiff = getStaticBankDifficulty(selectedDifficulty);
        int available = QuestionBank.getAvailableCount(categoryName, bankDiff);

        if (available >= selectedCount) {
            tvAvailableStatus.setVisibility(View.GONE);
            btnStartQuizNow.setEnabled(true);
            btnStartQuizNow.setAlpha(1.0f);
        } else {
            tvAvailableStatus.setVisibility(View.VISIBLE);
            tvAvailableStatus.setText("Only " + available + " questions available in bank for " + selectedDifficulty + ". Please choose fewer questions.");
            tvAvailableStatus.setTextColor(ContextCompat.getColor(this, R.color.warning_amber));
            tvAvailableStatus.setBackgroundResource(R.drawable.bg_option_default);
            btnStartQuizNow.setEnabled(false);
            btnStartQuizNow.setAlpha(0.6f);
        }
    }

    private String getStaticBankDifficulty(String diff) {
        if (diff.equalsIgnoreCase(AppConstants.DIFFICULTY_BEGINNER)) return AppConstants.DIFFICULTY_EASY;
        if (diff.equalsIgnoreCase(AppConstants.DIFFICULTY_INTERMEDIATE)) return AppConstants.DIFFICULTY_MEDIUM;
        if (diff.equalsIgnoreCase(AppConstants.DIFFICULTY_ADVANCED)) return AppConstants.DIFFICULTY_HARD;
        return diff;
    }
}
