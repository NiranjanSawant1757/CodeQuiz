package com.example.codequiz;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codequiz.adapter.CategoryAdapter;
import com.example.codequiz.data.QuestionBank;
import com.example.codequiz.model.QuizCategory;
import com.example.codequiz.util.AppConstants;
import com.example.codequiz.util.SessionManager;

import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView rvCategories;

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

        setContentView(R.layout.activity_category);

        Toolbar toolbar = findViewById(R.id.toolbarCategory);
        toolbar.setNavigationOnClickListener(v -> finish());

        rvCategories = findViewById(R.id.rvCategories);
        rvCategories.setLayoutManager(new LinearLayoutManager(this));

        List<QuizCategory> categories = QuestionBank.getCategories();
        CategoryAdapter adapter = new CategoryAdapter(categories, this::onCategorySelected);
        rvCategories.setAdapter(adapter);
    }

    private void onCategorySelected(QuizCategory category) {
        Intent intent = new Intent(this, QuizSetupActivity.class);
        intent.putExtra(AppConstants.EXTRA_CATEGORY, category.getName());
        startActivity(intent);
    }
}
