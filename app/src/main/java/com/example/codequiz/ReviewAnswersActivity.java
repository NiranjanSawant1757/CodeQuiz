package com.example.codequiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codequiz.adapter.ReviewAnswerAdapter;
import com.example.codequiz.database.QuizAttemptRepository;
import com.example.codequiz.model.AnswerRecord;
import com.example.codequiz.util.AppConstants;
import com.example.codequiz.util.SessionManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReviewAnswersActivity extends AppCompatActivity {

    private long attemptId = -1;
    private List<AnswerRecord> allRecords = new ArrayList<>();
    private final List<AnswerRecord> displayedRecords = new ArrayList<>();

    private RecyclerView rvReviewAnswers;
    private ReviewAnswerAdapter adapter;
    private TextView chipFilterAll, chipFilterCorrect, chipFilterIncorrect, chipFilterUnanswered;

    private String currentFilter = "ALL";

    private QuizAttemptRepository repository;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!SessionManager.getInstance(this).isLoggedIn()) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
            return;
        }

        setContentView(R.layout.activity_review_answers);
        repository = new QuizAttemptRepository(this);

        attemptId = getIntent().getLongExtra(AppConstants.EXTRA_ATTEMPT_ID, -1);

        Toolbar toolbar = findViewById(R.id.toolbarReview);
        toolbar.setNavigationOnClickListener(v -> finish());

        initViews();
        setupFilters();
        loadAnswers();
    }

    private void initViews() {
        rvReviewAnswers = findViewById(R.id.rvReviewAnswers);
        rvReviewAnswers.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ReviewAnswerAdapter(displayedRecords);
        rvReviewAnswers.setAdapter(adapter);

        chipFilterAll = findViewById(R.id.chipFilterAll);
        chipFilterCorrect = findViewById(R.id.chipFilterCorrect);
        chipFilterIncorrect = findViewById(R.id.chipFilterIncorrect);
        chipFilterUnanswered = findViewById(R.id.chipFilterUnanswered);
    }

    private void setupFilters() {
        chipFilterAll.setOnClickListener(v -> applyFilter("ALL"));
        chipFilterCorrect.setOnClickListener(v -> applyFilter("CORRECT"));
        chipFilterIncorrect.setOnClickListener(v -> applyFilter("INCORRECT"));
        chipFilterUnanswered.setOnClickListener(v -> applyFilter("UNANSWERED"));
    }

    private void applyFilter(String filter) {
        currentFilter = filter;

        setFilterChipStyle(chipFilterAll, filter.equals("ALL"));
        setFilterChipStyle(chipFilterCorrect, filter.equals("CORRECT"));
        setFilterChipStyle(chipFilterIncorrect, filter.equals("INCORRECT"));
        setFilterChipStyle(chipFilterUnanswered, filter.equals("UNANSWERED"));

        displayedRecords.clear();
        for (AnswerRecord rec : allRecords) {
            boolean isUnans = rec.getSelectedAnswer() == null || rec.getSelectedAnswer().trim().isEmpty();
            if (filter.equals("ALL")) {
                displayedRecords.add(rec);
            } else if (filter.equals("CORRECT") && rec.isCorrect()) {
                displayedRecords.add(rec);
            } else if (filter.equals("INCORRECT") && !rec.isCorrect() && !isUnans) {
                displayedRecords.add(rec);
            } else if (filter.equals("UNANSWERED") && isUnans) {
                displayedRecords.add(rec);
            }
        }
        adapter.notifyDataSetChanged();
    }

    private void setFilterChipStyle(TextView chip, boolean isSelected) {
        if (isSelected) {
            chip.setBackgroundResource(R.drawable.bg_chip_selected);
            chip.setTextColor(ContextCompat.getColor(this, R.color.white));
        } else {
            chip.setBackgroundResource(R.drawable.bg_chip_unselected);
            chip.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
        }
    }

    private void loadAnswers() {
        if (attemptId == -1) {
            Toast.makeText(this, "Attempt ID not provided", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        executor.execute(() -> {
            allRecords = repository.getAnswersForAttempt(attemptId);

            runOnUiThread(() -> {
                int total = allRecords.size();
                int correct = 0;
                int incorrect = 0;
                int unanswered = 0;

                for (AnswerRecord r : allRecords) {
                    if (r.getSelectedAnswer() == null || r.getSelectedAnswer().trim().isEmpty()) {
                        unanswered++;
                    } else if (r.isCorrect()) {
                        correct++;
                    } else {
                        incorrect++;
                    }
                }

                chipFilterAll.setText("All (" + total + ")");
                chipFilterCorrect.setText("Correct (" + correct + ")");
                chipFilterIncorrect.setText("Incorrect (" + incorrect + ")");
                chipFilterUnanswered.setText("Unanswered (" + unanswered + ")");

                applyFilter(currentFilter);
            });
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executor.shutdown();
    }
}
