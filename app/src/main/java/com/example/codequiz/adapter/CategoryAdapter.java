package com.example.codequiz.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codequiz.R;
import com.example.codequiz.model.QuizCategory;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    public interface OnCategoryClickListener {
        void onCategoryClick(QuizCategory category);
    }

    private final List<QuizCategory> categories;
    private final OnCategoryClickListener listener;

    public CategoryAdapter(List<QuizCategory> categories, OnCategoryClickListener listener) {
        this.categories = categories;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        QuizCategory category = categories.get(position);
        holder.tvName.setText(category.getName());
        holder.tvDesc.setText(category.getDescription());
        holder.ivIcon.setImageResource(category.getIconResId());

        View.OnClickListener clickAction = v -> {
            if (listener != null) {
                listener.onCategoryClick(category);
            }
        };

        holder.btnStartQuiz.setOnClickListener(clickAction);
        holder.itemView.setOnClickListener(clickAction);
    }

    @Override
    public int getItemCount() {
        return categories != null ? categories.size() : 0;
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon;
        TextView tvName;
        TextView tvDesc;
        MaterialButton btnStartQuiz;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.ivCategoryIcon);
            tvName = itemView.findViewById(R.id.tvCategoryName);
            tvDesc = itemView.findViewById(R.id.tvCategoryDesc);
            btnStartQuiz = itemView.findViewById(R.id.btnStartQuiz);
        }
    }
}
