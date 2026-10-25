package com.example.codequiz.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codequiz.R;
import com.example.codequiz.model.QuizAttempt;
import com.google.android.material.button.MaterialButton;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class QuizHistoryAdapter extends RecyclerView.Adapter<QuizHistoryAdapter.HistoryViewHolder> {

    public interface OnHistoryActionListener {
        void onViewResult(QuizAttempt attempt);
        void onReviewAnswers(QuizAttempt attempt);
    }

    private final List<QuizAttempt> attempts;
    private final OnHistoryActionListener listener;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy • hh:mm a", Locale.getDefault());

    public QuizHistoryAdapter(List<QuizAttempt> attempts, OnHistoryActionListener listener) {
        this.attempts = attempts;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quiz_history, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        QuizAttempt attempt = attempts.get(position);

        holder.tvCategory.setText(attempt.getCategory());
        holder.tvDate.setText(dateFormat.format(new Date(attempt.getAttemptedAt())));
        holder.tvDifficulty.setText("Difficulty: " + attempt.getDifficulty());
        holder.tvScore.setText("Score: " + attempt.getScore() + "/" + attempt.getTotalQuestions());

        int pct = (int) Math.round(attempt.getPercentage());
        holder.tvPercentage.setText(pct + "%");

        // Color badge according to performance level
        int colorRes;
        if (pct >= 90) {
            colorRes = R.color.correct_green;
        } else if (pct >= 75) {
            colorRes = R.color.primary;
        } else if (pct >= 50) {
            colorRes = R.color.warning_amber;
        } else {
            colorRes = R.color.incorrect_red;
        }
        holder.tvPercentage.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), colorRes));

        holder.btnViewResult.setOnClickListener(v -> {
            if (listener != null) listener.onViewResult(attempt);
        });

        holder.btnReviewAnswers.setOnClickListener(v -> {
            if (listener != null) listener.onReviewAnswers(attempt);
        });

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) listener.onViewResult(attempt);
        });
    }

    @Override
    public int getItemCount() {
        return attempts != null ? attempts.size() : 0;
    }

    static class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategory;
        TextView tvDate;
        TextView tvPercentage;
        TextView tvDifficulty;
        TextView tvScore;
        MaterialButton btnViewResult;
        MaterialButton btnReviewAnswers;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategory = itemView.findViewById(R.id.tvHistoryCategory);
            tvDate = itemView.findViewById(R.id.tvHistoryDate);
            tvPercentage = itemView.findViewById(R.id.tvHistoryPercentage);
            tvDifficulty = itemView.findViewById(R.id.tvHistoryDifficulty);
            tvScore = itemView.findViewById(R.id.tvHistoryScore);
            btnViewResult = itemView.findViewById(R.id.btnViewResult);
            btnReviewAnswers = itemView.findViewById(R.id.btnReviewAnswers);
        }
    }
}
