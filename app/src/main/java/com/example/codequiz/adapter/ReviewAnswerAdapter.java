package com.example.codequiz.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codequiz.R;
import com.example.codequiz.model.AnswerRecord;

import java.util.List;

public class ReviewAnswerAdapter extends RecyclerView.Adapter<ReviewAnswerAdapter.ReviewViewHolder> {

    private final List<AnswerRecord> records;

    public ReviewAnswerAdapter(List<AnswerRecord> records) {
        this.records = records;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review_answer, parent, false);
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        AnswerRecord record = records.get(position);

        holder.tvQuestionNum.setText("Question " + (position + 1));
        holder.tvQuestionText.setText(record.getQuestionText());

        boolean isUnanswered = record.getSelectedAnswer() == null || record.getSelectedAnswer().trim().isEmpty();

        if (isUnanswered) {
            holder.tvStatusBadge.setText("Unanswered");
            holder.tvStatusBadge.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.warning_amber));
            holder.tvUserAnswer.setText("Your Answer: (Not Answered)");
            holder.tvUserAnswer.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.warning_amber));
        } else if (record.isCorrect()) {
            holder.tvStatusBadge.setText("Correct (+1)");
            holder.tvStatusBadge.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.correct_green));
            holder.tvUserAnswer.setText("Your Answer: " + record.getSelectedAnswer());
            holder.tvUserAnswer.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.correct_green));
        } else {
            holder.tvStatusBadge.setText("Incorrect (0)");
            holder.tvStatusBadge.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.incorrect_red));
            holder.tvUserAnswer.setText("Your Answer: " + record.getSelectedAnswer());
            holder.tvUserAnswer.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.incorrect_red));
        }

        holder.tvCorrectAnswer.setText("Correct Answer: " + record.getCorrectAnswer());

        if (record.getExplanation() != null && !record.getExplanation().trim().isEmpty()) {
            holder.layoutExplanation.setVisibility(View.VISIBLE);
            holder.tvExplanationText.setText(record.getExplanation());
        } else {
            holder.layoutExplanation.setVisibility(View.GONE);
        }

        // Render options list with visual feedback
        List<String> options = record.getOptions();
        TextView[] optionViews = new TextView[]{holder.tvOpt1, holder.tvOpt2, holder.tvOpt3, holder.tvOpt4};
        char[] prefixes = new char[]{'A', 'B', 'C', 'D'};

        for (int i = 0; i < optionViews.length; i++) {
            if (i < options.size()) {
                String optText = options.get(i);
                optionViews[i].setVisibility(View.VISIBLE);
                optionViews[i].setText(prefixes[i] + ". " + optText);

                if (optText.equals(record.getCorrectAnswer())) {
                    // Highlight correct option in green
                    optionViews[i].setBackgroundResource(R.drawable.bg_option_correct);
                    optionViews[i].setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.correct_green));
                } else if (!record.isCorrect() && optText.equals(record.getSelectedAnswer())) {
                    // Highlight incorrect user choice in red
                    optionViews[i].setBackgroundResource(R.drawable.bg_option_incorrect);
                    optionViews[i].setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.incorrect_red));
                } else {
                    optionViews[i].setBackgroundResource(R.drawable.bg_option_default);
                    optionViews[i].setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.text_primary));
                }
            } else {
                optionViews[i].setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return records != null ? records.size() : 0;
    }

    static class ReviewViewHolder extends RecyclerView.ViewHolder {
        TextView tvQuestionNum;
        TextView tvStatusBadge;
        TextView tvQuestionText;
        TextView tvOpt1, tvOpt2, tvOpt3, tvOpt4;
        TextView tvUserAnswer;
        TextView tvCorrectAnswer;
        View layoutExplanation;
        TextView tvExplanationText;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            tvQuestionNum = itemView.findViewById(R.id.tvReviewQuestionNum);
            tvStatusBadge = itemView.findViewById(R.id.tvReviewStatusBadge);
            tvQuestionText = itemView.findViewById(R.id.tvReviewQuestionText);
            tvOpt1 = itemView.findViewById(R.id.tvOption1);
            tvOpt2 = itemView.findViewById(R.id.tvOption2);
            tvOpt3 = itemView.findViewById(R.id.tvOption3);
            tvOpt4 = itemView.findViewById(R.id.tvOption4);
            tvUserAnswer = itemView.findViewById(R.id.tvUserAnswer);
            tvCorrectAnswer = itemView.findViewById(R.id.tvCorrectAnswer);
            layoutExplanation = itemView.findViewById(R.id.layoutExplanation);
            tvExplanationText = itemView.findViewById(R.id.tvExplanationText);
        }
    }
}
