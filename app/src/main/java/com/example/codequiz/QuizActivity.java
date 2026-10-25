package com.example.codequiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.codequiz.data.QuestionBank;
import com.example.codequiz.database.QuizAttemptRepository;
import com.example.codequiz.model.AnswerRecord;
import com.example.codequiz.model.Question;
import com.example.codequiz.model.QuizAttempt;
import com.example.codequiz.util.AppConstants;
import com.example.codequiz.util.SessionManager;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuizActivity extends AppCompatActivity {

    private String categoryName;
    private String difficulty;
    private int requestedCount;
    private boolean timerEnabled;

    private List<Question> questions = new ArrayList<>();
    private String[] selectedAnswers;
    private int currentQuestionIndex = 0;
    private long quizStartTime = 0;
    private boolean isSubmitting = false;

    // Timer
    private CountDownTimer countDownTimer;
    private long timeRemainingMillis = 0;

    // Views
    private TextView tvQuizCategoryTitle, tvQuizDifficultyBadge, tvCountdownTimer;
    private LinearLayout layoutTimerBadge;
    private ProgressBar pbQuizProgress;
    private TextView tvQuestionCounter, tvAnsweredStatus, tvQuestionContent;

    private MaterialCardView cardOptionA, cardOptionB, cardOptionC, cardOptionD;
    private TextView badgeOptionA, badgeOptionB, badgeOptionC, badgeOptionD;
    private TextView tvOptionAText, tvOptionBText, tvOptionCText, tvOptionDText;

    private MaterialButton btnPreviousQuestion, btnNextQuestion, btnSubmitQuiz;
    private ImageView btnExitQuiz;

    private QuizAttemptRepository repository;
    private SessionManager sessionManager;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    // Keys for state saving
    private static final String KEY_CURRENT_INDEX = "key_current_index";
    private static final String KEY_SELECTED_ANSWERS = "key_selected_answers";
    private static final String KEY_QUESTIONS = "key_questions";
    private static final String KEY_TIME_REMAINING = "key_time_remaining";
    private static final String KEY_START_TIME = "key_start_time";

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

        setContentView(R.layout.activity_quiz);
        repository = new QuizAttemptRepository(this);

        categoryName = getIntent().getStringExtra(AppConstants.EXTRA_CATEGORY);
        if (categoryName == null) categoryName = AppConstants.CAT_JAVA;

        difficulty = getIntent().getStringExtra(AppConstants.EXTRA_DIFFICULTY);
        if (difficulty == null) difficulty = AppConstants.DIFFICULTY_MIXED;

        requestedCount = getIntent().getIntExtra(AppConstants.EXTRA_QUESTION_COUNT, AppConstants.COUNT_10);
        timerEnabled = getIntent().getBooleanExtra(AppConstants.EXTRA_TIMER_ENABLED, true);

        initViews();
        setupListeners();

        if (savedInstanceState != null) {
            currentQuestionIndex = savedInstanceState.getInt(KEY_CURRENT_INDEX, 0);
            selectedAnswers = savedInstanceState.getStringArray(KEY_SELECTED_ANSWERS);
            // Restore questions
            Serializable serializable = savedInstanceState.getSerializable(KEY_QUESTIONS);
            if (serializable instanceof List) {
                //noinspection unchecked
                questions = (List<Question>) serializable;
            }
            timeRemainingMillis = savedInstanceState.getLong(KEY_TIME_REMAINING, 0);
            quizStartTime = savedInstanceState.getLong(KEY_START_TIME, System.currentTimeMillis());
        } else {
            // New quiz session
            questions = QuestionBank.getQuizQuestions(categoryName, difficulty, requestedCount);
            selectedAnswers = new String[questions.size()];
            quizStartTime = System.currentTimeMillis();

            if (timerEnabled) {
                // Total duration = questions.size() * secondsPerQuestion
                int secondsPerQ = sessionManager.getTimerSeconds();
                timeRemainingMillis = (long) questions.size() * secondsPerQ * 1000L;
            }
        }

        if (questions.isEmpty()) {
            Toast.makeText(this, "No questions found for this quiz.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        if (timerEnabled) {
            layoutTimerBadge.setVisibility(View.VISIBLE);
            startTimer(timeRemainingMillis);
        } else {
            layoutTimerBadge.setVisibility(View.GONE);
        }

        displayQuestion(currentQuestionIndex);
    }

    private void initViews() {
        btnExitQuiz = findViewById(R.id.btnExitQuiz);
        tvQuizCategoryTitle = findViewById(R.id.tvQuizCategoryTitle);
        tvQuizDifficultyBadge = findViewById(R.id.tvQuizDifficultyBadge);
        layoutTimerBadge = findViewById(R.id.layoutTimerBadge);
        tvCountdownTimer = findViewById(R.id.tvCountdownTimer);
        pbQuizProgress = findViewById(R.id.pbQuizProgress);

        tvQuestionCounter = findViewById(R.id.tvQuestionCounter);
        tvAnsweredStatus = findViewById(R.id.tvAnsweredStatus);
        tvQuestionContent = findViewById(R.id.tvQuestionContent);

        cardOptionA = findViewById(R.id.cardOptionA);
        cardOptionB = findViewById(R.id.cardOptionB);
        cardOptionC = findViewById(R.id.cardOptionC);
        cardOptionD = findViewById(R.id.cardOptionD);

        badgeOptionA = findViewById(R.id.badgeOptionA);
        badgeOptionB = findViewById(R.id.badgeOptionB);
        badgeOptionC = findViewById(R.id.badgeOptionC);
        badgeOptionD = findViewById(R.id.badgeOptionD);

        tvOptionAText = findViewById(R.id.tvOptionAText);
        tvOptionBText = findViewById(R.id.tvOptionBText);
        tvOptionCText = findViewById(R.id.tvOptionCText);
        tvOptionDText = findViewById(R.id.tvOptionDText);

        btnPreviousQuestion = findViewById(R.id.btnPreviousQuestion);
        btnNextQuestion = findViewById(R.id.btnNextQuestion);
        btnSubmitQuiz = findViewById(R.id.btnSubmitQuiz);

        tvQuizCategoryTitle.setText(categoryName + " Quiz");
        tvQuizDifficultyBadge.setText(difficulty + " Difficulty");
    }

    private void setupListeners() {
        btnExitQuiz.setOnClickListener(v -> confirmExit());

        cardOptionA.setOnClickListener(v -> selectOption(0));
        cardOptionB.setOnClickListener(v -> selectOption(1));
        cardOptionC.setOnClickListener(v -> selectOption(2));
        cardOptionD.setOnClickListener(v -> selectOption(3));

        btnPreviousQuestion.setOnClickListener(v -> {
            if (currentQuestionIndex > 0) {
                currentQuestionIndex--;
                displayQuestion(currentQuestionIndex);
            }
        });

        btnNextQuestion.setOnClickListener(v -> {
            if (currentQuestionIndex < questions.size() - 1) {
                currentQuestionIndex++;
                displayQuestion(currentQuestionIndex);
            }
        });

        btnSubmitQuiz.setOnClickListener(v -> confirmSubmission());
    }

    private void displayQuestion(int index) {
        if (index < 0 || index >= questions.size()) return;

        Question q = questions.get(index);
        tvQuestionCounter.setText("Question " + (index + 1) + " of " + questions.size());

        // Update answered count
        int answeredCount = getAnsweredCount();
        tvAnsweredStatus.setText("Answered: " + answeredCount + "/" + questions.size());

        // Progress bar
        int progress = (int) (((index + 1) / (float) questions.size()) * 100);
        pbQuizProgress.setProgress(progress);

        tvQuestionContent.setText(q.getQuestionText());

        List<String> options = q.getOptions();
        TextView[] optionTexts = {tvOptionAText, tvOptionBText, tvOptionCText, tvOptionDText};
        MaterialCardView[] optionCards = {cardOptionA, cardOptionB, cardOptionC, cardOptionD};
        TextView[] badges = {badgeOptionA, badgeOptionB, badgeOptionC, badgeOptionD};

        String currentAnswer = selectedAnswers[index];

        for (int i = 0; i < 4; i++) {
            if (i < options.size()) {
                String opt = options.get(i);
                optionCards[i].setVisibility(View.VISIBLE);
                optionTexts[i].setText(opt);

                boolean isSelected = opt.equals(currentAnswer);
                if (isSelected) {
                    optionCards[i].setCardBackgroundColor(ContextCompat.getColor(this, R.color.primary_light));
                    optionCards[i].setStrokeColor(ContextCompat.getColor(this, R.color.primary));
                    badges[i].setBackgroundResource(R.drawable.bg_chip_selected);
                    badges[i].setTextColor(ContextCompat.getColor(this, R.color.white));
                } else {
                    optionCards[i].setCardBackgroundColor(ContextCompat.getColor(this, R.color.surface));
                    optionCards[i].setStrokeColor(ContextCompat.getColor(this, R.color.card_stroke));
                    badges[i].setBackgroundResource(R.drawable.bg_badge_rounded);
                    badges[i].setTextColor(ContextCompat.getColor(this, R.color.primary));
                }
            } else {
                optionCards[i].setVisibility(View.GONE);
            }
        }

        // Previous button state
        btnPreviousQuestion.setEnabled(index > 0);
        btnPreviousQuestion.setAlpha(index > 0 ? 1.0f : 0.4f);

        // Next button text / visibility
        if (index == questions.size() - 1) {
            btnNextQuestion.setText("Review / Submit");
        } else {
            btnNextQuestion.setText("Next");
        }
    }

    private void selectOption(int optionIndex) {
        Question q = questions.get(currentQuestionIndex);
        if (optionIndex < q.getOptions().size()) {
            selectedAnswers[currentQuestionIndex] = q.getOptions().get(optionIndex);
            displayQuestion(currentQuestionIndex);
        }
    }

    private int getAnsweredCount() {
        int count = 0;
        if (selectedAnswers != null) {
            for (String ans : selectedAnswers) {
                if (ans != null && !ans.trim().isEmpty()) {
                    count++;
                }
            }
        }
        return count;
    }

    private void startTimer(long millis) {
        if (countDownTimer != null) countDownTimer.cancel();

        countDownTimer = new CountDownTimer(millis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeRemainingMillis = millisUntilFinished;
                long totalSeconds = millisUntilFinished / 1000;
                long minutes = totalSeconds / 60;
                long seconds = totalSeconds % 60;
                tvCountdownTimer.setText(String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds));

                if (totalSeconds <= 30) {
                    tvCountdownTimer.setTextColor(ContextCompat.getColor(QuizActivity.this, R.color.incorrect_red));
                }
            }

            @Override
            public void onFinish() {
                tvCountdownTimer.setText("00:00");
                Toast.makeText(QuizActivity.this, "Time's up! Submitting quiz...", Toast.LENGTH_SHORT).show();
                submitQuiz();
            }
        }.start();
    }

    private void confirmExit() {
        new AlertDialog.Builder(this)
                .setTitle("Exit Quiz?")
                .setMessage("Your current quiz progress will be discarded. Are you sure you want to quit?")
                .setPositiveButton("Yes, Exit", (dialog, which) -> {
                    if (countDownTimer != null) countDownTimer.cancel();
                    finish();
                })
                .setNegativeButton("Keep Playing", null)
                .show();
    }

    private void confirmSubmission() {
        int answered = getAnsweredCount();
        int total = questions.size();
        int unanswered = total - answered;

        String message;
        if (unanswered > 0) {
            message = "You have answered " + answered + " of " + total + " questions (" + unanswered + " unanswered).\n\nAre you sure you want to submit now?";
        } else {
            message = "You have answered all " + total + " questions!\n\nAre you ready to submit and view your results?";
        }

        new AlertDialog.Builder(this)
                .setTitle("Submit Quiz")
                .setMessage(message)
                .setPositiveButton("Submit", (dialog, which) -> submitQuiz())
                .setNegativeButton("Continue Quiz", null)
                .show();
    }

    private void submitQuiz() {
        if (isSubmitting) return;
        isSubmitting = true;

        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        btnSubmitQuiz.setEnabled(false);
        btnSubmitQuiz.setText("Submitting...");

        // Calculate score
        int correctCount = 0;
        int incorrectCount = 0;
        int unansweredCount = 0;

        List<AnswerRecord> answerRecords = new ArrayList<>();

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            String selected = selectedAnswers[i];
            boolean isCorrect = false;

            if (selected == null || selected.trim().isEmpty()) {
                unansweredCount++;
            } else if (selected.equals(q.getCorrectAnswer())) {
                correctCount++;
                isCorrect = true;
            } else {
                incorrectCount++;
            }

            AnswerRecord record = new AnswerRecord(
                    0, 0,
                    q.getId(),
                    q.getQuestionText(),
                    q.getOptions(),
                    selected,
                    q.getCorrectAnswer(),
                    q.getExplanation(),
                    isCorrect,
                    i + 1
            );
            answerRecords.add(record);
        }

        int score = correctCount; // 1 mark per correct answer
        double percentage = ((double) correctCount / questions.size()) * 100.0;
        int durationSeconds = (int) ((System.currentTimeMillis() - quizStartTime) / 1000);

        long userId = sessionManager.getUserId();

        QuizAttempt attempt = new QuizAttempt(
                0,
                userId,
                categoryName,
                difficulty,
                questions.size(),
                correctCount,
                incorrectCount,
                unansweredCount,
                score,
                percentage,
                durationSeconds,
                System.currentTimeMillis()
        );

        executor.execute(() -> {
            long attemptId = repository.saveAttempt(attempt, answerRecords);

            runOnUiThread(() -> {
                if (attemptId != -1) {
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    intent.putExtra(AppConstants.EXTRA_ATTEMPT_ID, attemptId);
                    startActivity(intent);
                    finish(); // Prevent user from going back into the completed quiz
                } else {
                    isSubmitting = false;
                    btnSubmitQuiz.setEnabled(true);
                    btnSubmitQuiz.setText("Submit Quiz");
                    Toast.makeText(QuizActivity.this, "Failed to save quiz attempt. Please try again.", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CURRENT_INDEX, currentQuestionIndex);
        outState.putStringArray(KEY_SELECTED_ANSWERS, selectedAnswers);
        outState.putSerializable(KEY_QUESTIONS, (Serializable) questions);
        outState.putLong(KEY_TIME_REMAINING, timeRemainingMillis);
        outState.putLong(KEY_START_TIME, quizStartTime);
    }

    @Override
    public void onBackPressed() {
        confirmExit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        executor.shutdown();
    }
}
