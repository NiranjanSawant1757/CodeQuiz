package com.example.codequiz;

import android.content.Intent;
import android.os.Bundle;
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
        tvSetupCatCount.setText("Total " + totalCatQuestions + " questions in question bank");

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

        // Difficulty levels
        chipDiffEasy.setOnClickListener(v -> selectDifficulty(AppConstants.DIFFICULTY_EASY));
        chipDiffMedium.setOnClickListener(v -> selectDifficulty(AppConstants.DIFFICULTY_MEDIUM));
        chipDiffHard.setOnClickListener(v -> selectDifficulty(AppConstants.DIFFICULTY_HARD));
        chipDiffMixed.setOnClickListener(v -> selectDifficulty(AppConstants.DIFFICULTY_MIXED));

        btnStartQuizNow.setOnClickListener(v -> {
            int available = QuestionBank.getAvailableCount(categoryName, selectedDifficulty);
            if (selectedCount > available) {
                Toast.makeText(this, "Not enough eligible questions in " + categoryName + " for " + selectedDifficulty, Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(QuizSetupActivity.this, QuizActivity.class);
            intent.putExtra(AppConstants.EXTRA_CATEGORY, categoryName);
            intent.putExtra(AppConstants.EXTRA_DIFFICULTY, selectedDifficulty);
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
        setChipStyle(chipDiffEasy, diff.equals(AppConstants.DIFFICULTY_EASY));
        setChipStyle(chipDiffMedium, diff.equals(AppConstants.DIFFICULTY_MEDIUM));
        setChipStyle(chipDiffHard, diff.equals(AppConstants.DIFFICULTY_HARD));
        setChipStyle(chipDiffMixed, diff.equals(AppConstants.DIFFICULTY_MIXED));
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
        int available = QuestionBank.getAvailableCount(categoryName, selectedDifficulty);

        if (available >= selectedCount) {
            tvAvailableStatus.setText(available + " eligible questions available for " + selectedDifficulty + ". Ready to start!");
            tvAvailableStatus.setTextColor(ContextCompat.getColor(this, R.color.primary));
            tvAvailableStatus.setBackgroundResource(R.drawable.bg_badge_rounded);
            btnStartQuizNow.setEnabled(true);
            btnStartQuizNow.setAlpha(1.0f);
        } else {
            tvAvailableStatus.setText("Only " + available + " questions available for " + selectedDifficulty + ". Please select fewer questions or 'Mixed' difficulty.");
            tvAvailableStatus.setTextColor(ContextCompat.getColor(this, R.color.incorrect_red));
            tvAvailableStatus.setBackgroundResource(R.drawable.bg_option_incorrect);
            btnStartQuizNow.setEnabled(false);
            btnStartQuizNow.setAlpha(0.5f);
        }
    }
}
