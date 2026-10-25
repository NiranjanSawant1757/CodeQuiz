package com.example.codequiz.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codequiz.R;
import com.example.codequiz.model.CategoryPerformance;

import java.util.List;

public class CategoryProgressAdapter extends RecyclerView.Adapter<CategoryProgressAdapter.ProgressViewHolder> {

    private final List<CategoryPerformance> list;

    public CategoryProgressAdapter(List<CategoryPerformance> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ProgressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_progress, parent, false);
        return new ProgressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgressViewHolder holder, int position) {
        CategoryPerformance perf = list.get(position);
        holder.tvName.setText(perf.getCategory() + " (" + perf.getAttemptsCount() + (perf.getAttemptsCount() == 1 ? " attempt)" : " attempts)"));
        holder.tvScore.setText("Avg: " + (int) perf.getAveragePercentage() + "% • High: " + (int) perf.getHighestPercentage() + "%");
        holder.progressBar.setProgress((int) perf.getAveragePercentage());
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    static class ProgressViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvScore;
        ProgressBar progressBar;

        public ProgressViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvCatProgName);
            tvScore = itemView.findViewById(R.id.tvCatProgScore);
            progressBar = itemView.findViewById(R.id.pbCatProgress);
        }
    }
}
