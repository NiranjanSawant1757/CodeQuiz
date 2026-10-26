package com.example.codequiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.example.codequiz.data.QuestionBank;
import com.example.codequiz.database.QuestionRepository;
import com.example.codequiz.model.Question;
import com.example.codequiz.model.QuizCategory;
import com.example.codequiz.network.AiApiClient;
import com.example.codequiz.util.AppConstants;
import com.example.codequiz.util.NetworkUtils;
import com.example.codequiz.util.SessionManager;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.materialswitch.MaterialSwitch;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuizSetupActivity extends AppCompatActivity {

    private String categoryName = AppConstants.CAT_JAVA;
    private int selectedCount = AppConstants.COUNT_10;
    private String selectedDifficulty = AppConstants.DIFFICULTY_MIXED;

    private ImageView ivSetupCatIcon;
    private TextView tvSetupCatName, tvSetupCatCount, tvAvailableStatus;
    private TextView chipCount10, chipCount20, chipCount30, chipCount50;
    private TextView chipDiffEasy, chipDiffMedium, chipDiffHard, chipDiffMixed;
    private MaterialSwitch switchTimer;
    private MaterialButton btnStartQuizNow, btnStartAiQuiz;

    // AI Components
    private TextView tvAiNetworkBadge, tvSavedQuestionsCount, tvAiLoadingStatus;
    private LinearLayout layoutAiLoading;
    private QuestionRepository questionRepository;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private boolean isGeneratingAi = false;

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
        questionRepository = new QuestionRepository(this);

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
        refreshAiCacheStatus();
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshAiCacheStatus();
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
        btnStartAiQuiz = findViewById(R.id.btnStartAiQuiz);

        tvAiNetworkBadge = findViewById(R.id.tvAiNetworkBadge);
        tvSavedQuestionsCount = findViewById(R.id.tvSavedQuestionsCount);
        layoutAiLoading = findViewById(R.id.layoutAiLoading);
        tvAiLoadingStatus = findViewById(R.id.tvAiLoadingStatus);
    }

    private void setupCategoryInfo() {
        tvSetupCatName.setText(categoryName);
        int totalCatQuestions = QuestionBank.getCount(categoryName);
        tvSetupCatCount.setText("Total " + totalCatQuestions + " static questions in bank");

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

        // Start standard built-in quiz
        btnStartQuizNow.setOnClickListener(v -> {
            if (isGeneratingAi) return;
            int available = QuestionBank.getAvailableCount(categoryName, getStaticBankDifficulty(selectedDifficulty));
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

        // Start AI Generated Quiz (Online / Offline Hybrid)
        btnStartAiQuiz.setOnClickListener(v -> handleStartAiQuiz());
    }

    private void selectCount(int count) {
        selectedCount = count;
        setChipStyle(chipCount10, count == AppConstants.COUNT_10);
        setChipStyle(chipCount20, count == AppConstants.COUNT_20);
        setChipStyle(chipCount30, count == AppConstants.COUNT_30);
        setChipStyle(chipCount50, count == AppConstants.COUNT_50);
        updateValidationState();
        refreshAiCacheStatus();
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
        refreshAiCacheStatus();
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
            tvAvailableStatus.setText(available + " static questions available for " + selectedDifficulty + " in built-in bank.");
            tvAvailableStatus.setTextColor(ContextCompat.getColor(this, R.color.primary));
            tvAvailableStatus.setBackgroundResource(R.drawable.bg_badge_rounded);
            btnStartQuizNow.setEnabled(true);
            btnStartQuizNow.setAlpha(1.0f);
        } else {
            tvAvailableStatus.setText("Only " + available + " static questions in bank. Use 'Generate AI Quiz' or choose fewer questions.");
            tvAvailableStatus.setTextColor(ContextCompat.getColor(this, R.color.warning_amber));
            tvAvailableStatus.setBackgroundResource(R.drawable.bg_option_default);
            btnStartQuizNow.setEnabled(false);
            btnStartQuizNow.setAlpha(0.6f);
        }
    }

    private void refreshAiCacheStatus() {
        boolean isOnline = NetworkUtils.isNetworkAvailable(this);
        if (isOnline) {
            tvAiNetworkBadge.setText("Online (AI Ready)");
            tvAiNetworkBadge.setTextColor(ContextCompat.getColor(this, R.color.correct_green));
        } else {
            tvAiNetworkBadge.setText("Offline Mode");
            tvAiNetworkBadge.setTextColor(ContextCompat.getColor(this, R.color.warning_amber));
        }

        executor.execute(() -> {
            int cachedCount = questionRepository.getSavedQuestionCount(categoryName, selectedDifficulty);
            runOnUiThread(() -> {
                tvSavedQuestionsCount.setText("SQLite Cache: " + cachedCount + " questions saved offline for " + selectedDifficulty);
            });
        });
    }

    private void handleStartAiQuiz() {
        if (isGeneratingAi) return;

        boolean isOnline = NetworkUtils.isNetworkAvailable(this);

        if (isOnline) {
            // Online flow: Generate from AI backend
            generateQuestionsFromAiBackend();
        } else {
            // Offline flow: Try loading suitable saved questions from SQLite
            loadOfflineSavedQuestions();
        }
    }

    private void generateQuestionsFromAiBackend() {
        setAiLoading(true, "Connecting to AI backend and generating " + selectedCount + " " + selectedDifficulty + " questions...");

        // Map difficulty for API: Beginner, Intermediate, Advanced (or Beginner if Mixed)
        String apiDifficulty = selectedDifficulty;
        if (apiDifficulty.equalsIgnoreCase(AppConstants.DIFFICULTY_MIXED)) {
            apiDifficulty = "Intermediate";
        } else if (apiDifficulty.equalsIgnoreCase(AppConstants.DIFFICULTY_EASY)) {
            apiDifficulty = "Beginner";
        } else if (apiDifficulty.equalsIgnoreCase(AppConstants.DIFFICULTY_MEDIUM)) {
            apiDifficulty = "Intermediate";
        } else if (apiDifficulty.equalsIgnoreCase(AppConstants.DIFFICULTY_HARD)) {
            apiDifficulty = "Advanced";
        }

        final String targetApiDiff = apiDifficulty;

        executor.execute(() -> {
            try {
                List<Question> questions = AiApiClient.generateQuestions(
                        QuizSetupActivity.this,
                        categoryName,
                        targetApiDiff,
                        selectedCount
                );

                // Save generated questions to local SQLite database for offline reuse
                int savedCount = questionRepository.saveQuestions(questions, "AI");

                runOnUiThread(() -> {
                    setAiLoading(false, null);
                    Toast.makeText(QuizSetupActivity.this, "Generated " + questions.size() + " AI questions (" + savedCount + " new saved to SQLite)!", Toast.LENGTH_SHORT).show();
                    startQuizWithQuestions(questions);
                });

            } catch (Exception e) {
                final String errorMessage = e.getMessage() != null ? e.getMessage() : "Unknown AI generation error.";

                // Check if we have offline saved questions as fallback
                List<Question> fallbackQuestions = questionRepository.getSavedQuestions(categoryName, selectedDifficulty, selectedCount);

                runOnUiThread(() -> {
                    setAiLoading(false, null);

                    if (fallbackQuestions != null && fallbackQuestions.size() >= Math.min(selectedCount, 5)) {
                        // Offer fallback to offline cached questions
                        new AlertDialog.Builder(QuizSetupActivity.this)
                                .setTitle("AI Generation Notice")
                                .setMessage("Could not generate fresh questions from AI server:\n\n" + errorMessage
                                        + "\n\nHowever, " + fallbackQuestions.size() + " saved questions were found in SQLite. Would you like to start the quiz using saved questions?")
                                .setPositiveButton("Use Saved Questions", (dialog, which) -> {
                                    startQuizWithQuestions(fallbackQuestions);
                                })
                                .setNegativeButton("Cancel", null)
                                .show();
                    } else {
                        // Display error dialog
                        new AlertDialog.Builder(QuizSetupActivity.this)
                                .setTitle("AI Generation Error")
                                .setMessage(errorMessage + "\n\nPlease ensure the backend server is running and your API key is properly configured.")
                                .setPositiveButton("OK", null)
                                .show();
                    }
                });
            }
        });
    }

    private void loadOfflineSavedQuestions() {
        setAiLoading(true, "Searching SQLite database for saved offline questions...");

        executor.execute(() -> {
            List<Question> saved = questionRepository.getSavedQuestions(categoryName, selectedDifficulty, selectedCount);

            runOnUiThread(() -> {
                setAiLoading(false, null);

                if (saved != null && !saved.isEmpty()) {
                    Toast.makeText(QuizSetupActivity.this, "Offline Mode: Loaded " + saved.size() + " questions from SQLite.", Toast.LENGTH_SHORT).show();
                    startQuizWithQuestions(saved);
                } else {
                    // No offline questions available
                    new AlertDialog.Builder(QuizSetupActivity.this)
                            .setTitle("Offline Mode Notice")
                            .setMessage("You are currently offline, and no saved questions were found for " + categoryName + " (" + selectedDifficulty + ") in your local SQLite database.\n\nPlease connect to the internet to generate or download new questions.")
                            .setPositiveButton("OK", null)
                            .show();
                }
            });
        });
    }

    private void startQuizWithQuestions(List<Question> questions) {
        if (questions == null || questions.isEmpty()) {
            Toast.makeText(this, "No questions available to start quiz.", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(QuizSetupActivity.this, QuizActivity.class);
        intent.putExtra(AppConstants.EXTRA_CATEGORY, categoryName);
        intent.putExtra(AppConstants.EXTRA_DIFFICULTY, selectedDifficulty);
        intent.putExtra(AppConstants.EXTRA_QUESTION_COUNT, questions.size());
        intent.putExtra(AppConstants.EXTRA_TIMER_ENABLED, switchTimer.isChecked());
        intent.putExtra(AppConstants.EXTRA_QUESTIONS, (Serializable) new ArrayList<>(questions));
        intent.putExtra(AppConstants.EXTRA_IS_AI, true);
        startActivity(intent);
    }

    private void setAiLoading(boolean isLoading, String statusText) {
        this.isGeneratingAi = isLoading;
        if (isLoading) {
            layoutAiLoading.setVisibility(View.VISIBLE);
            tvAiLoadingStatus.setText(statusText != null ? statusText : "Processing...");
            btnStartAiQuiz.setEnabled(false);
            btnStartAiQuiz.setAlpha(0.6f);
            btnStartQuizNow.setEnabled(false);
        } else {
            layoutAiLoading.setVisibility(View.GONE);
            btnStartAiQuiz.setEnabled(true);
            btnStartAiQuiz.setAlpha(1.0f);
            updateValidationState();
        }
    }

    private String getStaticBankDifficulty(String diff) {
        if (diff.equalsIgnoreCase(AppConstants.DIFFICULTY_BEGINNER)) return AppConstants.DIFFICULTY_EASY;
        if (diff.equalsIgnoreCase(AppConstants.DIFFICULTY_INTERMEDIATE)) return AppConstants.DIFFICULTY_MEDIUM;
        if (diff.equalsIgnoreCase(AppConstants.DIFFICULTY_ADVANCED)) return AppConstants.DIFFICULTY_HARD;
        return diff;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executor.shutdown();
    }
}
