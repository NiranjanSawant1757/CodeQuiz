package com.example.codequiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codequiz.adapter.CategoryProgressAdapter;
import com.example.codequiz.adapter.RecentAttemptAdapter;
import com.example.codequiz.database.QuestionRepository;
import com.example.codequiz.database.QuizAttemptRepository;
import com.example.codequiz.model.DashboardStats;
import com.example.codequiz.model.QuizAttempt;
import com.example.codequiz.util.AppConstants;
import com.example.codequiz.util.SessionManager;
import com.google.android.material.button.MaterialButton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DashboardActivity extends AppCompatActivity {

    private TextView tvWelcomeUser, tvMotivationalMessage;
    private MaterialButton btnHeroStartQuiz, btnHeroAiQuiz, btnZeroStateStart;
    private View cardZeroState, layoutStatsGrid, cardInsights;
    private TextView tvStatTotalQuizzes, tvStatTotalQuestions, tvStatAverageScore, tvStatHighestScore;
    private TextView tvStrongestCategory, tvNeedsImprovementCategory, tvImprovementTrend;
    private TextView tvCorrectIncorrectAnswers, tvOverallAccuracy, tvDifficultyProgress, tvSavedOfflineCount;
    private TextView tvCategoryProgHeader, tvViewAllHistory;
    private LinearLayout layoutRecentHeader;
    private RecyclerView rvCategoryProgress, rvRecentAttempts;
    private ImageView btnNavHistory, btnNavProfile, btnNavSettings;

    private SessionManager sessionManager;
    private QuizAttemptRepository attemptRepository;
    private QuestionRepository questionRepository;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    private final String[] motivationalQuotes = {
            "Consistency is the key to mastering code.",
            "Write code, make mistakes, learn, repeat.",
            "Great programmers aren't born; they practice daily.",
            "Every bug fixed is a step towards senior engineer mastery."
    };

    private static final String[] AI_SUBJECTS = {
            "Java", "Python", "C", "C++", "SQL", "JavaScript", "React"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sessionManager = SessionManager.getInstance(this);
        if (!sessionManager.isLoggedIn()) {
            redirectToLogin();
            return;
        }

        setContentView(R.layout.activity_dashboard);
        attemptRepository = new QuizAttemptRepository(this);
        questionRepository = new QuestionRepository(this);

        initViews();
        setupListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!sessionManager.isLoggedIn()) {
            redirectToLogin();
            return;
        }
        loadDashboardData();
    }

    private void redirectToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void initViews() {
        tvWelcomeUser = findViewById(R.id.tvWelcomeUser);
        tvMotivationalMessage = findViewById(R.id.tvMotivationalMessage);
        btnHeroStartQuiz = findViewById(R.id.btnHeroStartQuiz);
        btnHeroAiQuiz = findViewById(R.id.btnHeroAiQuiz);
        btnZeroStateStart = findViewById(R.id.btnZeroStateStart);
        cardZeroState = findViewById(R.id.cardZeroState);
        layoutStatsGrid = findViewById(R.id.layoutStatsGrid);
        cardInsights = findViewById(R.id.cardInsights);

        tvStatTotalQuizzes = findViewById(R.id.tvStatTotalQuizzes);
        tvStatTotalQuestions = findViewById(R.id.tvStatTotalQuestions);
        tvStatAverageScore = findViewById(R.id.tvStatAverageScore);
        tvStatHighestScore = findViewById(R.id.tvStatHighestScore);

        tvStrongestCategory = findViewById(R.id.tvStrongestCategory);
        tvNeedsImprovementCategory = findViewById(R.id.tvNeedsImprovementCategory);
        tvImprovementTrend = findViewById(R.id.tvImprovementTrend);

        tvCorrectIncorrectAnswers = findViewById(R.id.tvCorrectIncorrectAnswers);
        tvOverallAccuracy = findViewById(R.id.tvOverallAccuracy);
        tvDifficultyProgress = findViewById(R.id.tvDifficultyProgress);
        tvSavedOfflineCount = findViewById(R.id.tvSavedOfflineCount);

        tvCategoryProgHeader = findViewById(R.id.tvCategoryProgHeader);
        layoutRecentHeader = findViewById(R.id.layoutRecentHeader);
        tvViewAllHistory = findViewById(R.id.tvViewAllHistory);

        rvCategoryProgress = findViewById(R.id.rvCategoryProgress);
        rvCategoryProgress.setLayoutManager(new LinearLayoutManager(this));

        rvRecentAttempts = findViewById(R.id.rvRecentAttempts);
        rvRecentAttempts.setLayoutManager(new LinearLayoutManager(this));

        btnNavHistory = findViewById(R.id.btnNavHistory);
        btnNavProfile = findViewById(R.id.btnNavProfile);
        btnNavSettings = findViewById(R.id.btnNavSettings);
    }

    private void setupListeners() {
        View.OnClickListener startQuizAction = v -> {
            Intent intent = new Intent(DashboardActivity.this, CategoryActivity.class);
            startActivity(intent);
        };

        btnHeroStartQuiz.setOnClickListener(startQuizAction);
        btnZeroStateStart.setOnClickListener(startQuizAction);

        btnHeroAiQuiz.setOnClickListener(v -> showAiSubjectPicker());

        btnNavHistory.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, QuizHistoryActivity.class);
            startActivity(intent);
        });

        tvViewAllHistory.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, QuizHistoryActivity.class);
            startActivity(intent);
        });

        btnNavProfile.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        btnNavSettings.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, SettingsActivity.class);
            startActivity(intent);
        });
    }

    private void showAiSubjectPicker() {
        new AlertDialog.Builder(this)
                .setTitle("Select Subject for AI Quiz")
                .setItems(AI_SUBJECTS, (dialog, which) -> {
                    String selectedSubject = AI_SUBJECTS[which];
                    Intent intent = new Intent(DashboardActivity.this, QuizSetupActivity.class);
                    intent.putExtra(AppConstants.EXTRA_CATEGORY, selectedSubject);
                    startActivity(intent);
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    private void loadDashboardData() {
        String fullName = sessionManager.getFullName();
        if (fullName.isEmpty()) fullName = sessionManager.getUsername();
        tvWelcomeUser.setText("Hello, " + fullName + "!");

        int quoteIdx = (int) (System.currentTimeMillis() % motivationalQuotes.length);
        tvMotivationalMessage.setText(motivationalQuotes[quoteIdx]);

        long userId = sessionManager.getUserId();

        executor.execute(() -> {
            DashboardStats stats = attemptRepository.getUserDashboardStats(userId);
            int totalSavedQuestions = questionRepository.getTotalSavedQuestionsCount();

            runOnUiThread(() -> {
                if (stats.getTotalQuizzes() == 0) {
                    // Show zero state
                    cardZeroState.setVisibility(View.VISIBLE);
                    layoutStatsGrid.setVisibility(View.GONE);
                    cardInsights.setVisibility(View.GONE);
                    tvCategoryProgHeader.setVisibility(View.GONE);
                    rvCategoryProgress.setVisibility(View.GONE);
                    layoutRecentHeader.setVisibility(View.GONE);
                    rvRecentAttempts.setVisibility(View.GONE);
                } else {
                    cardZeroState.setVisibility(View.GONE);
                    layoutStatsGrid.setVisibility(View.VISIBLE);
                    cardInsights.setVisibility(View.VISIBLE);

                    tvStatTotalQuizzes.setText(String.valueOf(stats.getTotalQuizzes()));
                    tvStatTotalQuestions.setText(String.valueOf(stats.getTotalQuestions()));
                    tvStatAverageScore.setText((int) stats.getAverageScore() + "%");
                    tvStatHighestScore.setText((int) stats.getHighestScore() + "%");

                    tvStrongestCategory.setText(stats.getStrongestCategory());
                    tvNeedsImprovementCategory.setText(stats.getCategoryNeedingImprovement());
                    tvImprovementTrend.setText(stats.getRecentImprovementText());

                    tvCorrectIncorrectAnswers.setText(stats.getTotalCorrectAnswers() + " Correct / " + stats.getTotalIncorrectAnswers() + " Incorrect");
                    tvOverallAccuracy.setText(stats.getOverallAccuracy() + "%");
                    tvDifficultyProgress.setText(stats.getDifficultyProgressSummary());
                    tvSavedOfflineCount.setText(totalSavedQuestions + " questions in SQLite");

                    // Category progress
                    if (stats.getCategoryPerformances() != null && !stats.getCategoryPerformances().isEmpty()) {
                        tvCategoryProgHeader.setVisibility(View.VISIBLE);
                        rvCategoryProgress.setVisibility(View.VISIBLE);
                        CategoryProgressAdapter progAdapter = new CategoryProgressAdapter(stats.getCategoryPerformances());
                        rvCategoryProgress.setAdapter(progAdapter);
                    } else {
                        tvCategoryProgHeader.setVisibility(View.GONE);
                        rvCategoryProgress.setVisibility(View.GONE);
                    }

                    // Recent attempts
                    if (stats.getRecentAttempts() != null && !stats.getRecentAttempts().isEmpty()) {
                        layoutRecentHeader.setVisibility(View.VISIBLE);
                        rvRecentAttempts.setVisibility(View.VISIBLE);
                        RecentAttemptAdapter recentAdapter = new RecentAttemptAdapter(stats.getRecentAttempts(), attempt -> {
                            Intent intent = new Intent(DashboardActivity.this, ResultActivity.class);
                            intent.putExtra(AppConstants.EXTRA_ATTEMPT_ID, attempt.getId());
                            startActivity(intent);
                        });
                        rvRecentAttempts.setAdapter(recentAdapter);
                    } else {
                        layoutRecentHeader.setVisibility(View.GONE);
                        rvRecentAttempts.setVisibility(View.GONE);
                    }
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
