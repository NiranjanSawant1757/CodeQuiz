package com.example.codequiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.codequiz.database.QuizAttemptRepository;
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

    private ImageView ivResultIcon;
    private TextView tvPerformanceLevel, tvResultSubtitle;
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
        loadAttemptResult();
    }

    private void initViews() {
        ivResultIcon = findViewById(R.id.ivResultIcon);
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

        btnGoDashboard.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, DashboardActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });
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
                int pct = (int) Math.round(attempt.getPercentage());
                tvScorePercentage.setText(pct + "%");
                tvScoreFraction.setText("Marks: " + attempt.getScore() + " / " + attempt.getTotalQuestions());

                int durationSecs = attempt.getDurationSeconds();
                int mins = durationSecs / 60;
                int secs = durationSecs % 60;
                tvDurationTaken.setText(String.format(Locale.getDefault(), "Time Taken: %dm %02ds", mins, secs));

                tvStatCorrectCount.setText(String.valueOf(attempt.getCorrectAnswers()));
                tvStatIncorrectCount.setText(String.valueOf(attempt.getIncorrectAnswers()));
                tvStatUnansweredCount.setText(String.valueOf(attempt.getUnanswered()));

                // Performance feedback according to specification
                if (pct >= 90) {
                    tvPerformanceLevel.setText("Excellent! 🏆");
                    tvPerformanceLevel.setTextColor(ContextCompat.getColor(ResultActivity.this, R.color.correct_green));
                    tvResultSubtitle.setText("Mastery level achievement! You have a commanding grasp of this subject.");
                } else if (pct >= 75) {
                    tvPerformanceLevel.setText("Very Good! 🌟");
                    tvPerformanceLevel.setTextColor(ContextCompat.getColor(ResultActivity.this, R.color.primary));
                    tvResultSubtitle.setText("Great performance! Keep sharpening your skills to achieve top tier score.");
                } else if (pct >= 50) {
                    tvPerformanceLevel.setText("Good 👍");
                    tvPerformanceLevel.setTextColor(ContextCompat.getColor(ResultActivity.this, R.color.warning_amber));
                    tvResultSubtitle.setText("Solid foundation, but there's room to revise concepts and improve.");
                } else {
                    tvPerformanceLevel.setText("Needs Improvement 📚");
                    tvPerformanceLevel.setTextColor(ContextCompat.getColor(ResultActivity.this, R.color.incorrect_red));
                    tvResultSubtitle.setText("Review the detailed answers below and study the explanations to master these topics.");
                }
            });
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, DashboardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executor.shutdown();
    }
}
