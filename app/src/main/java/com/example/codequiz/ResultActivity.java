package com.example.codequiz;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.codequiz.database.QuizAttemptRepository;
import com.example.codequiz.model.AchievementLevel;
import com.example.codequiz.model.QuizAttempt;
import com.example.codequiz.util.AppConstants;
import com.example.codequiz.util.SessionManager;
import com.google.android.material.button.MaterialButton;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ResultActivity extends AppCompatActivity {

    private long attemptId = -1;
    private QuizAttempt attempt;

    private ImageView ivResultIcon, ivAchievementGif;
    private TextView tvAchievementBadge, tvPerformanceLevel, tvResultSubtitle;
    private TextView tvResultCategory, tvScorePercentage, tvScoreFraction, tvDurationTaken;
    private TextView tvStatCorrectCount, tvStatIncorrectCount, tvStatUnansweredCount;

    private MaterialButton btnReviewAnswersResult, btnRetakeQuiz, btnGoDashboard;

    private QuizAttemptRepository repository;
    private SessionManager sessionManager;
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

        setContentView(R.layout.activity_result);
        repository = new QuizAttemptRepository(this);

        attemptId = getIntent().getLongExtra(AppConstants.EXTRA_ATTEMPT_ID, -1);

        initViews();
        setupListeners();
        setupBackNavigation();
        loadAttemptResult();
    }

    private void initViews() {
        ivResultIcon = findViewById(R.id.ivResultIcon);
        ivAchievementGif = findViewById(R.id.ivAchievementGif);
        tvAchievementBadge = findViewById(R.id.tvAchievementBadge);
        tvPerformanceLevel = findViewById(R.id.tvPerformanceLevel);
        tvResultSubtitle = findViewById(R.id.tvResultSubtitle);

        tvResultCategory = findViewById(R.id.tvResultCategory);
        tvScorePercentage = findViewById(R.id.tvScorePercentage);
        tvScoreFraction = findViewById(R.id.tvScoreFraction);
        tvDurationTaken = findViewById(R.id.tvDurationTaken);

        tvStatCorrectCount = findViewById(R.id.tvStatCorrectCount);
        tvStatIncorrectCount = findViewById(R.id.tvStatIncorrectCount);
        tvStatUnansweredCount = findViewById(R.id.tvStatUnansweredCount);

        btnReviewAnswersResult = findViewById(R.id.btnReviewAnswersResult);
        btnRetakeQuiz = findViewById(R.id.btnRetakeQuiz);
        btnGoDashboard = findViewById(R.id.btnGoDashboard);
    }

    private void setupListeners() {
        btnReviewAnswersResult.setOnClickListener(v -> {
            if (attempt != null) {
                Intent intent = new Intent(ResultActivity.this, ReviewAnswersActivity.class);
                intent.putExtra(AppConstants.EXTRA_ATTEMPT_ID, attempt.getId());
                startActivity(intent);
            }
        });

        btnRetakeQuiz.setOnClickListener(v -> {
            if (attempt != null) {
                Intent intent = new Intent(ResultActivity.this, QuizSetupActivity.class);
                intent.putExtra(AppConstants.EXTRA_CATEGORY, attempt.getCategory());
                startActivity(intent);
                finish();
            }
        });

        btnGoDashboard.setOnClickListener(v -> navigateToHome());
    }

    private void loadAttemptResult() {
        if (attemptId == -1) {
            Toast.makeText(this, "Result record not found.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        long userId = sessionManager.getUserId();

        executor.execute(() -> {
            attempt = repository.getAttemptById(attemptId, userId);

            runOnUiThread(() -> {
                if (attempt == null) {
                    Toast.makeText(ResultActivity.this, "Unable to load result for this user.", Toast.LENGTH_SHORT).show();
                    finish();
                    return;
                }

                tvResultCategory.setText(attempt.getCategory() + " • " + attempt.getDifficulty());

                int correctAnswers = attempt.getCorrectAnswers();
                int totalQuestions = attempt.getTotalQuestions();
                double accuracy = AchievementLevel.calculateAccuracy(correctAnswers, totalQuestions);
                int pct = (int) Math.round(accuracy);

                tvScorePercentage.setText(pct + "%");
                tvScoreFraction.setText("Correct: " + correctAnswers + " / " + totalQuestions);

                int durationSecs = attempt.getDurationSeconds();
                int mins = durationSecs / 60;
                int secs = durationSecs % 60;
                tvDurationTaken.setText(String.format(Locale.getDefault(), "Time Taken: %dm %02ds", mins, secs));

                tvStatCorrectCount.setText(String.valueOf(attempt.getCorrectAnswers()));
                tvStatIncorrectCount.setText(String.valueOf(attempt.getIncorrectAnswers()));
                tvStatUnansweredCount.setText(String.valueOf(attempt.getUnanswered()));

                // 3-Level Quiz Achievement Evaluation
                AchievementLevel level = AchievementLevel.classify(accuracy);

                // Badge Setup
                tvAchievementBadge.setText(level.getBadgeText());
                int badgeColor = ContextCompat.getColor(ResultActivity.this, level.getBadgeColorResId());
                int badgeBgColor = ContextCompat.getColor(ResultActivity.this, level.getBadgeBgColorResId());
                tvAchievementBadge.setTextColor(badgeColor);
                tvAchievementBadge.setBackgroundTintList(ColorStateList.valueOf(badgeBgColor));

                // Title & Message Setup
                tvPerformanceLevel.setText(level.getTitle());
                tvPerformanceLevel.setTextColor(badgeColor);
                tvResultSubtitle.setText(level.getMessage());

                // GIF Celebration vs Static Failure Icon
                if (level.hasAchievementGif() && !isFinishing() && !isDestroyed()) {
                    ivResultIcon.setVisibility(View.GONE);
                    ivAchievementGif.setVisibility(View.VISIBLE);
                    Glide.with(ResultActivity.this)
                            .asGif()
                            .load(level.getGifResId())
                            .into(ivAchievementGif);
                } else {
                    if (ivAchievementGif != null) {
                        Glide.with(ResultActivity.this).clear(ivAchievementGif);
                        ivAchievementGif.setVisibility(View.GONE);
                    }
                    ivResultIcon.setVisibility(View.VISIBLE);
                    ivResultIcon.setImageResource(R.drawable.ic_trophy);
                    ivResultIcon.setImageTintList(ColorStateList.valueOf(badgeColor));
                }
            });
        });
    }

    private void setupBackNavigation() {
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                navigateToHome();
            }
        });
    }

    private void navigateToHome() {
        Intent intent = new Intent(this, DashboardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (ivAchievementGif != null) {
            Glide.with(getApplicationContext()).clear(ivAchievementGif);
        }
        executor.shutdown();
    }
}
