package com.example.codequiz.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;

import com.example.codequiz.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class DialogHelper {

    public static class CustomDialogConfig {
        @DrawableRes public int iconResId = R.drawable.ic_quiz;
        @ColorRes public int iconTintResId = R.color.primary;
        @ColorRes public int iconBgTintResId = R.color.primary_light;
        public String title = "";
        public String message = "";

        // Optional Stats
        public boolean showStats = false;
        public String stat1Value = "";
        public String stat1Label = "";
        @ColorRes public int stat1ColorResId = R.color.primary;
        public String stat2Value = "";
        public String stat2Label = "";
        @ColorRes public int stat2ColorResId = R.color.warning_amber;

        // Positive Button
        public String positiveText = "OK";
        @ColorRes public int positiveBgColorResId = R.color.primary;
        @ColorRes public int positiveTextColorResId = R.color.on_primary;
        public Runnable onPositiveClick = null;

        // Negative Button
        public String negativeText = "Cancel";
        public Runnable onNegativeClick = null;

        public boolean cancelable = true;
    }

    public static AlertDialog showCustomDialog(Context context, CustomDialogConfig config) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_custom, null);

        FrameLayout layoutDialogIcon = view.findViewById(R.id.layoutDialogIcon);
        ImageView ivDialogIcon = view.findViewById(R.id.ivDialogIcon);
        TextView tvDialogTitle = view.findViewById(R.id.tvDialogTitle);
        TextView tvDialogMessage = view.findViewById(R.id.tvDialogMessage);

        MaterialCardView cardDialogStats = view.findViewById(R.id.cardDialogStats);
        TextView tvStat1Value = view.findViewById(R.id.tvStat1Value);
        TextView tvStat1Label = view.findViewById(R.id.tvStat1Label);
        TextView tvStat2Value = view.findViewById(R.id.tvStat2Value);
        TextView tvStat2Label = view.findViewById(R.id.tvStat2Label);

        MaterialButton btnNegative = view.findViewById(R.id.btnDialogNegative);
        MaterialButton btnPositive = view.findViewById(R.id.btnDialogPositive);

        // Icon & Badge
        ivDialogIcon.setImageResource(config.iconResId);
        ivDialogIcon.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(context, config.iconTintResId)));
        layoutDialogIcon.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(context, config.iconBgTintResId)));

        // Title & Message
        tvDialogTitle.setText(config.title);
        tvDialogMessage.setText(config.message);

        // Stats Card
        if (config.showStats) {
            cardDialogStats.setVisibility(View.VISIBLE);
            tvStat1Value.setText(config.stat1Value);
            tvStat1Value.setTextColor(ContextCompat.getColor(context, config.stat1ColorResId));
            tvStat1Label.setText(config.stat1Label);

            tvStat2Value.setText(config.stat2Value);
            tvStat2Value.setTextColor(ContextCompat.getColor(context, config.stat2ColorResId));
            tvStat2Label.setText(config.stat2Label);
        } else {
            cardDialogStats.setVisibility(View.GONE);
        }

        // Positive Button Styling
        btnPositive.setText(config.positiveText);
        btnPositive.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(context, config.positiveBgColorResId)));
        btnPositive.setTextColor(ContextCompat.getColor(context, config.positiveTextColorResId));

        // Negative Button Styling
        if (config.negativeText == null || config.negativeText.trim().isEmpty()) {
            btnNegative.setVisibility(View.GONE);
        } else {
            btnNegative.setVisibility(View.VISIBLE);
            btnNegative.setText(config.negativeText);
        }

        AlertDialog dialog = new MaterialAlertDialogBuilder(context)
                .setView(view)
                .setCancelable(config.cancelable)
                .create();

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        btnPositive.setOnClickListener(v -> {
            dialog.dismiss();
            if (config.onPositiveClick != null) {
                config.onPositiveClick.run();
            }
        });

        btnNegative.setOnClickListener(v -> {
            dialog.dismiss();
            if (config.onNegativeClick != null) {
                config.onNegativeClick.run();
            }
        });

        dialog.show();
        return dialog;
    }

    public static AlertDialog showSubmitQuizDialog(Context context, int answered, int total, Runnable onConfirm) {
        int unanswered = total - answered;
        CustomDialogConfig config = new CustomDialogConfig();
        config.iconResId = R.drawable.ic_quiz;
        config.iconTintResId = R.color.primary;
        config.iconBgTintResId = R.color.primary_light;
        config.title = "Submit Quiz";

        if (unanswered > 0) {
            config.message = "You have unanswered questions. Are you sure you want to finish now and view your results?";
        } else {
            config.message = "You have answered all questions! Ready to see your final score and performance breakdown?";
        }

        config.showStats = true;
        config.stat1Value = answered + " / " + total;
        config.stat1Label = "Answered";
        config.stat1ColorResId = R.color.primary;

        config.stat2Value = String.valueOf(unanswered);
        config.stat2Label = "Unanswered";
        config.stat2ColorResId = unanswered > 0 ? R.color.warning_amber : R.color.correct_green;

        config.positiveText = "Submit";
        config.positiveBgColorResId = R.color.primary;
        config.positiveTextColorResId = R.color.on_primary;
        config.onPositiveClick = onConfirm;

        config.negativeText = "Continue Quiz";

        return showCustomDialog(context, config);
    }

    public static AlertDialog showExitQuizDialog(Context context, Runnable onConfirm) {
        CustomDialogConfig config = new CustomDialogConfig();
        config.iconResId = R.drawable.ic_warning;
        config.iconTintResId = R.color.warning_amber;
        config.iconBgTintResId = R.color.warning_amber_light;
        config.title = "Exit Quiz?";
        config.message = "Your current quiz progress will be discarded. Are you sure you want to quit?";

        config.positiveText = "Yes, Exit";
        config.positiveBgColorResId = R.color.incorrect_red;
        config.positiveTextColorResId = R.color.white;
        config.onPositiveClick = onConfirm;

        config.negativeText = "Keep Playing";

        return showCustomDialog(context, config);
    }

    public static AlertDialog showLogoutDialog(Context context, Runnable onConfirm) {
        CustomDialogConfig config = new CustomDialogConfig();
        config.iconResId = R.drawable.ic_logout;
        config.iconTintResId = R.color.incorrect_red;
        config.iconBgTintResId = R.color.incorrect_red_light;
        config.title = "Log Out";
        config.message = "Are you sure you want to log out of CodeQuiz?";

        config.positiveText = "Log Out";
        config.positiveBgColorResId = R.color.incorrect_red;
        config.positiveTextColorResId = R.color.white;
        config.onPositiveClick = onConfirm;

        config.negativeText = "Cancel";

        return showCustomDialog(context, config);
    }

    public static AlertDialog showClearHistoryDialog(Context context, Runnable onConfirm) {
        CustomDialogConfig config = new CustomDialogConfig();
        config.iconResId = R.drawable.ic_history;
        config.iconTintResId = R.color.incorrect_red;
        config.iconBgTintResId = R.color.incorrect_red_light;
        config.title = "Clear History";
        config.message = "Are you sure you want to permanently clear all your quiz attempts? This action cannot be undone.";

        config.positiveText = "Clear History";
        config.positiveBgColorResId = R.color.incorrect_red;
        config.positiveTextColorResId = R.color.white;
        config.onPositiveClick = onConfirm;

        config.negativeText = "Cancel";

        return showCustomDialog(context, config);
    }
}
