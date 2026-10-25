package com.example.codequiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codequiz.adapter.QuizHistoryAdapter;
import com.example.codequiz.database.QuizAttemptRepository;
import com.example.codequiz.model.QuizAttempt;
import com.example.codequiz.util.AppConstants;
import com.example.codequiz.util.SessionManager;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuizHistoryActivity extends AppCompatActivity {

    private Spinner spinnerCategoryFilter;
    private TextView chipSortRecent, chipSortScore;
    private RecyclerView rvHistoryList;
    private LinearLayout layoutEmptyHistory;
    private MaterialButton btnEmptyTakeQuiz;

    private final List<QuizAttempt> attemptsList = new ArrayList<>();
    private QuizHistoryAdapter adapter;

    private String selectedCategory = "All";
    private String selectedSort = "recent"; // "recent" or "score"

    private QuizAttemptRepository repository;
    private SessionManager sessionManager;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    private final String[] categoriesForFilter = {
            "All Categories",
            AppConstants.CAT_JAVA,
            AppConstants.CAT_PYTHON,
            AppConstants.CAT_C,
            AppConstants.CAT_CPP,
            AppConstants.CAT_JAVASCRIPT,
            AppConstants.CAT_REACT,
            AppConstants.CAT_HTML,
            AppConstants.CAT_CSS,
            AppConstants.CAT_SQL,
            AppConstants.CAT_DSA
    };

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

        setContentView(R.layout.activity_quiz_history);
        repository = new QuizAttemptRepository(this);

        Toolbar toolbar = findViewById(R.id.toolbarHistory);
        toolbar.setNavigationOnClickListener(v -> finish());

        initViews();
        setupFiltersAndSorting();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadHistory();
    }

    private void initViews() {
        spinnerCategoryFilter = findViewById(R.id.spinnerCategoryFilter);
        chipSortRecent = findViewById(R.id.chipSortRecent);
        chipSortScore = findViewById(R.id.chipSortScore);
        rvHistoryList = findViewById(R.id.rvHistoryList);
        layoutEmptyHistory = findViewById(R.id.layoutEmptyHistory);
        btnEmptyTakeQuiz = findViewById(R.id.btnEmptyTakeQuiz);

        rvHistoryList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new QuizHistoryAdapter(attemptsList, new QuizHistoryAdapter.OnHistoryActionListener() {
            @Override
            public void onViewResult(QuizAttempt attempt) {
                Intent intent = new Intent(QuizHistoryActivity.this, ResultActivity.class);
                intent.putExtra(AppConstants.EXTRA_ATTEMPT_ID, attempt.getId());
                startActivity(intent);
            }

            @Override
            public void onReviewAnswers(QuizAttempt attempt) {
                Intent intent = new Intent(QuizHistoryActivity.this, ReviewAnswersActivity.class);
                intent.putExtra(AppConstants.EXTRA_ATTEMPT_ID, attempt.getId());
                startActivity(intent);
            }
        });
        rvHistoryList.setAdapter(adapter);

        btnEmptyTakeQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(QuizHistoryActivity.this, CategoryActivity.class);
            startActivity(intent);
        });
    }

    private void setupFiltersAndSorting() {
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, categoriesForFilter);
        spinnerCategoryFilter.setAdapter(spinnerAdapter);

        spinnerCategoryFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    selectedCategory = "All";
                } else {
                    selectedCategory = categoriesForFilter[position];
                }
                loadHistory();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        chipSortRecent.setOnClickListener(v -> {
            selectedSort = "recent";
            setSortChip(chipSortRecent, true);
            setSortChip(chipSortScore, false);
            loadHistory();
        });

        chipSortScore.setOnClickListener(v -> {
            selectedSort = "score";
            setSortChip(chipSortRecent, false);
            setSortChip(chipSortScore, true);
            loadHistory();
        });
    }

    private void setSortChip(TextView chip, boolean isSelected) {
        if (isSelected) {
            chip.setBackgroundResource(R.drawable.bg_chip_selected);
            chip.setTextColor(ContextCompat.getColor(this, R.color.white));
        } else {
            chip.setBackgroundResource(R.drawable.bg_chip_unselected);
            chip.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
        }
    }

    private void loadHistory() {
        long userId = sessionManager.getUserId();

        executor.execute(() -> {
            List<QuizAttempt> list = repository.getAttemptsByUserId(userId, selectedCategory, selectedSort);

            runOnUiThread(() -> {
                attemptsList.clear();
                attemptsList.addAll(list);
                adapter.notifyDataSetChanged();

                if (attemptsList.isEmpty()) {
                    layoutEmptyHistory.setVisibility(View.VISIBLE);
                    rvHistoryList.setVisibility(View.GONE);
                } else {
                    layoutEmptyHistory.setVisibility(View.GONE);
                    rvHistoryList.setVisibility(View.VISIBLE);
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
