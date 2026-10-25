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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RecentAttemptAdapter extends RecyclerView.Adapter<RecentAttemptAdapter.RecentViewHolder> {

    public interface OnRecentAttemptClickListener {
        void onRecentAttemptClick(QuizAttempt attempt);
    }

    private final List<QuizAttempt> attempts;
    private final OnRecentAttemptClickListener listener;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());

    public RecentAttemptAdapter(List<QuizAttempt> attempts, OnRecentAttemptClickListener listener) {
        this.attempts = attempts;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recent_attempt, parent, false);
        return new RecentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentViewHolder holder, int position) {
        QuizAttempt attempt = attempts.get(position);

        holder.tvCategory.setText(attempt.getCategory());
        String dateStr = dateFormat.format(new Date(attempt.getAttemptedAt()));
        holder.tvDetails.setText(attempt.getTotalQuestions() + " Questions • " + attempt.getDifficulty() + " • " + dateStr);

        int pct = (int) Math.round(attempt.getPercentage());
        holder.tvScore.setText(pct + "%");

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
        holder.tvScore.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), colorRes));

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) listener.onRecentAttemptClick(attempt);
        });
    }

    @Override
    public int getItemCount() {
        return attempts != null ? attempts.size() : 0;
    }

    static class RecentViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategory;
        TextView tvDetails;
        TextView tvScore;

        public RecentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategory = itemView.findViewById(R.id.tvRecentCategory);
            tvDetails = itemView.findViewById(R.id.tvRecentDetails);
            tvScore = itemView.findViewById(R.id.tvRecentScore);
        }
    }
}
