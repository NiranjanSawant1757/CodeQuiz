package com.example.codequiz.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.codequiz.model.AnswerRecord;
import com.example.codequiz.model.CategoryPerformance;
import com.example.codequiz.model.DashboardStats;
import com.example.codequiz.model.QuizAttempt;

import java.util.ArrayList;
import java.util.List;

public class QuizAttemptRepository {

    private final DatabaseHelper dbHelper;

    public QuizAttemptRepository(Context context) {
        this.dbHelper = DatabaseHelper.getInstance(context);
    }

    /**
     * Atomically saves a quiz attempt and its answer snapshots within a transaction.
     * Returns the created attempt ID, or -1 if transaction failed.
     */
    public long saveAttempt(QuizAttempt attempt, List<AnswerRecord> answers) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long attemptId = -1;

        db.beginTransaction();
        try {
            ContentValues attemptValues = new ContentValues();
            attemptValues.put(DatabaseHelper.COL_ATTEMPT_USER_ID, attempt.getUserId());
            attemptValues.put(DatabaseHelper.COL_ATTEMPT_CATEGORY, attempt.getCategory());
            attemptValues.put(DatabaseHelper.COL_ATTEMPT_DIFFICULTY, attempt.getDifficulty());
            attemptValues.put(DatabaseHelper.COL_ATTEMPT_TOTAL_QUESTIONS, attempt.getTotalQuestions());
            attemptValues.put(DatabaseHelper.COL_ATTEMPT_CORRECT_ANSWERS, attempt.getCorrectAnswers());
            attemptValues.put(DatabaseHelper.COL_ATTEMPT_INCORRECT_ANSWERS, attempt.getIncorrectAnswers());
            attemptValues.put(DatabaseHelper.COL_ATTEMPT_UNANSWERED, attempt.getUnanswered());
            attemptValues.put(DatabaseHelper.COL_ATTEMPT_SCORE, attempt.getScore());
            attemptValues.put(DatabaseHelper.COL_ATTEMPT_PERCENTAGE, attempt.getPercentage());
            attemptValues.put(DatabaseHelper.COL_ATTEMPT_DURATION, attempt.getDurationSeconds());
            attemptValues.put(DatabaseHelper.COL_ATTEMPT_DATE, attempt.getAttemptedAt());

            attemptId = db.insertOrThrow(DatabaseHelper.TABLE_QUIZ_ATTEMPTS, null, attemptValues);

            if (answers != null) {
                for (AnswerRecord record : answers) {
                    ContentValues ansValues = new ContentValues();
                    ansValues.put(DatabaseHelper.COL_ANS_ATTEMPT_ID, attemptId);
                    ansValues.put(DatabaseHelper.COL_ANS_QUESTION_ID, record.getQuestionId());
                    ansValues.put(DatabaseHelper.COL_ANS_QUESTION_TEXT, record.getQuestionText());
                    ansValues.put(DatabaseHelper.COL_ANS_OPTIONS_JSON, record.getOptionsJson());
                    ansValues.put(DatabaseHelper.COL_ANS_SELECTED, record.getSelectedAnswer());
                    ansValues.put(DatabaseHelper.COL_ANS_CORRECT, record.getCorrectAnswer());
                    ansValues.put(DatabaseHelper.COL_ANS_EXPLANATION, record.getExplanation());
                    ansValues.put(DatabaseHelper.COL_ANS_IS_CORRECT, record.isCorrect() ? 1 : 0);
                    ansValues.put(DatabaseHelper.COL_ANS_QUESTION_ORDER, record.getQuestionOrder());

                    db.insertOrThrow(DatabaseHelper.TABLE_ATTEMPT_ANSWERS, null, ansValues);
                }
            }

            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }

        return attemptId;
    }

    public QuizAttempt getAttemptById(long attemptId, long userId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_QUIZ_ATTEMPTS
                    + " WHERE " + DatabaseHelper.COL_ATTEMPT_ID + " = ? AND "
                    + DatabaseHelper.COL_ATTEMPT_USER_ID + " = ? LIMIT 1",
                    new String[]{String.valueOf(attemptId), String.valueOf(userId)});

            if (cursor != null && cursor.moveToFirst()) {
                return parseAttempt(cursor);
            }
        } finally {
            if (cursor != null) cursor.close();
        }
        return null;
    }

    public List<QuizAttempt> getAttemptsByUserId(long userId, String categoryFilter, String sortBy) {
        List<QuizAttempt> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        StringBuilder query = new StringBuilder("SELECT * FROM " + DatabaseHelper.TABLE_QUIZ_ATTEMPTS
                + " WHERE " + DatabaseHelper.COL_ATTEMPT_USER_ID + " = ?");
        List<String> args = new ArrayList<>();
        args.add(String.valueOf(userId));

        if (categoryFilter != null && !categoryFilter.equalsIgnoreCase("All") && !categoryFilter.trim().isEmpty()) {
            query.append(" AND " + DatabaseHelper.COL_ATTEMPT_CATEGORY + " = ?");
            args.add(categoryFilter);
        }

        if ("score".equalsIgnoreCase(sortBy)) {
            query.append(" ORDER BY " + DatabaseHelper.COL_ATTEMPT_PERCENTAGE + " DESC, "
                    + DatabaseHelper.COL_ATTEMPT_DATE + " DESC");
        } else {
            query.append(" ORDER BY " + DatabaseHelper.COL_ATTEMPT_DATE + " DESC");
        }

        Cursor cursor = null;
        try {
            cursor = db.rawQuery(query.toString(), args.toArray(new String[0]));
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    list.add(parseAttempt(cursor));
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) cursor.close();
        }
        return list;
    }

    public List<AnswerRecord> getAnswersForAttempt(long attemptId) {
        List<AnswerRecord> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_ATTEMPT_ANSWERS
                    + " WHERE " + DatabaseHelper.COL_ANS_ATTEMPT_ID + " = ?"
                    + " ORDER BY " + DatabaseHelper.COL_ANS_QUESTION_ORDER + " ASC",
                    new String[]{String.valueOf(attemptId)});

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    AnswerRecord record = new AnswerRecord();
                    record.setId(cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ANS_ID)));
                    record.setAttemptId(cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ANS_ATTEMPT_ID)));
                    record.setQuestionId(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ANS_QUESTION_ID)));
                    record.setQuestionText(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ANS_QUESTION_TEXT)));
                    record.setOptionsFromJson(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ANS_OPTIONS_JSON)));
                    record.setSelectedAnswer(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ANS_SELECTED)));
                    record.setCorrectAnswer(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ANS_CORRECT)));
                    record.setExplanation(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ANS_EXPLANATION)));
                    record.setCorrect(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ANS_IS_CORRECT)) == 1);
                    record.setQuestionOrder(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ANS_QUESTION_ORDER)));
                    list.add(record);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) cursor.close();
        }
        return list;
    }

    public DashboardStats getUserDashboardStats(long userId) {
        DashboardStats stats = new DashboardStats();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // 1. Total quizzes, total questions, correct/incorrect, avg percentage, max percentage
        String summarySql = "SELECT COUNT(*), COALESCE(SUM(" + DatabaseHelper.COL_ATTEMPT_TOTAL_QUESTIONS + "), 0), "
                + "COALESCE(AVG(" + DatabaseHelper.COL_ATTEMPT_PERCENTAGE + "), 0), "
                + "COALESCE(MAX(" + DatabaseHelper.COL_ATTEMPT_PERCENTAGE + "), 0), "
                + "COALESCE(SUM(" + DatabaseHelper.COL_ATTEMPT_CORRECT_ANSWERS + "), 0), "
                + "COALESCE(SUM(" + DatabaseHelper.COL_ATTEMPT_INCORRECT_ANSWERS + "), 0) "
                + "FROM " + DatabaseHelper.TABLE_QUIZ_ATTEMPTS
                + " WHERE " + DatabaseHelper.COL_ATTEMPT_USER_ID + " = ?";

        Cursor cursor = null;
        try {
            cursor = db.rawQuery(summarySql, new String[]{String.valueOf(userId)});
            if (cursor != null && cursor.moveToFirst()) {
                int totalQz = cursor.getInt(0);
                int totalQs = cursor.getInt(1);
                double avgPct = Math.round(cursor.getDouble(2) * 10.0) / 10.0;
                double maxPct = Math.round(cursor.getDouble(3) * 10.0) / 10.0;
                int correctAns = cursor.getInt(4);
                int incorrectAns = cursor.getInt(5);

                stats.setTotalQuizzes(totalQz);
                stats.setTotalQuestions(totalQs);
                stats.setAverageScore(avgPct);
                stats.setHighestScore(maxPct);
                stats.setTotalCorrectAnswers(correctAns);
                stats.setTotalIncorrectAnswers(incorrectAns);

                if (totalQs > 0) {
                    double accuracy = Math.round(((double) correctAns / totalQs) * 1000.0) / 10.0;
                    stats.setOverallAccuracy(accuracy);
                } else {
                    stats.setOverallAccuracy(0.0);
                }
            }
        } finally {
            if (cursor != null) cursor.close();
        }

        // 2. Difficulty Breakdown
        String diffSql = "SELECT " + DatabaseHelper.COL_ATTEMPT_DIFFICULTY + ", COUNT(*), "
                + "AVG(" + DatabaseHelper.COL_ATTEMPT_PERCENTAGE + ") "
                + "FROM " + DatabaseHelper.TABLE_QUIZ_ATTEMPTS
                + " WHERE " + DatabaseHelper.COL_ATTEMPT_USER_ID + " = ? "
                + "GROUP BY " + DatabaseHelper.COL_ATTEMPT_DIFFICULTY;

        StringBuilder diffSummary = new StringBuilder();
        try {
            cursor = db.rawQuery(diffSql, new String[]{String.valueOf(userId)});
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    String diffName = cursor.getString(0);
                    int dCount = cursor.getInt(1);
                    double dAvg = Math.round(cursor.getDouble(2) * 10.0) / 10.0;
                    if (diffSummary.length() > 0) diffSummary.append("  •  ");
                    diffSummary.append(diffName).append(": ").append((int) dAvg).append("% (").append(dCount).append(" attempts)");
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) cursor.close();
        }
        stats.setDifficultyProgressSummary(diffSummary.length() > 0 ? diffSummary.toString() : "No difficulty attempts yet");

        // 3. Category performances
        List<CategoryPerformance> categoryPerformances = new ArrayList<>();
        String catSql = "SELECT " + DatabaseHelper.COL_ATTEMPT_CATEGORY + ", COUNT(*), "
                + "AVG(" + DatabaseHelper.COL_ATTEMPT_PERCENTAGE + "), "
                + "MAX(" + DatabaseHelper.COL_ATTEMPT_PERCENTAGE + ") "
                + "FROM " + DatabaseHelper.TABLE_QUIZ_ATTEMPTS
                + " WHERE " + DatabaseHelper.COL_ATTEMPT_USER_ID + " = ? "
                + "GROUP BY " + DatabaseHelper.COL_ATTEMPT_CATEGORY + " "
                + "ORDER BY AVG(" + DatabaseHelper.COL_ATTEMPT_PERCENTAGE + ") DESC";

        try {
            cursor = db.rawQuery(catSql, new String[]{String.valueOf(userId)});
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    String cat = cursor.getString(0);
                    int count = cursor.getInt(1);
                    double avg = Math.round(cursor.getDouble(2) * 10.0) / 10.0;
                    double max = Math.round(cursor.getDouble(3) * 10.0) / 10.0;
                    categoryPerformances.add(new CategoryPerformance(cat, count, avg, max));
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) cursor.close();
        }
        stats.setCategoryPerformances(categoryPerformances);

        if (!categoryPerformances.isEmpty()) {
            stats.setStrongestCategory(categoryPerformances.get(0).getCategory());
            stats.setCategoryNeedingImprovement(categoryPerformances.get(categoryPerformances.size() - 1).getCategory());
        } else {
            stats.setStrongestCategory("None");
            stats.setCategoryNeedingImprovement("None");
        }

        // 3. Recent 5 attempts
        List<QuizAttempt> recentList = new ArrayList<>();
        String recentSql = "SELECT * FROM " + DatabaseHelper.TABLE_QUIZ_ATTEMPTS
                + " WHERE " + DatabaseHelper.COL_ATTEMPT_USER_ID + " = ? "
                + "ORDER BY " + DatabaseHelper.COL_ATTEMPT_DATE + " DESC LIMIT 5";
        try {
            cursor = db.rawQuery(recentSql, new String[]{String.valueOf(userId)});
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    recentList.add(parseAttempt(cursor));
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) cursor.close();
        }
        stats.setRecentAttempts(recentList);

        // 4. Calculate Improvement compared with previous attempt in the same category
        // Requirement: Improvement = Current attempt percentage − Previous attempt percentage
        if (!recentList.isEmpty()) {
            QuizAttempt latest = recentList.get(0);
            String prevAttemptSql = "SELECT " + DatabaseHelper.COL_ATTEMPT_PERCENTAGE + " FROM "
                    + DatabaseHelper.TABLE_QUIZ_ATTEMPTS + " WHERE "
                    + DatabaseHelper.COL_ATTEMPT_USER_ID + " = ? AND "
                    + DatabaseHelper.COL_ATTEMPT_CATEGORY + " = ? AND "
                    + DatabaseHelper.COL_ATTEMPT_ID + " != ? AND "
                    + DatabaseHelper.COL_ATTEMPT_DATE + " <= ? "
                    + "ORDER BY " + DatabaseHelper.COL_ATTEMPT_DATE + " DESC LIMIT 1";

            try {
                cursor = db.rawQuery(prevAttemptSql, new String[]{
                        String.valueOf(userId),
                        latest.getCategory(),
                        String.valueOf(latest.getId()),
                        String.valueOf(latest.getAttemptedAt())
                });
                if (cursor != null && cursor.moveToFirst()) {
                    double prevPercentage = cursor.getDouble(0);
                    double diff = Math.round((latest.getPercentage() - prevPercentage) * 10.0) / 10.0;
                    stats.setRecentImprovementPoints(diff);
                    if (diff > 0) {
                        stats.setRecentImprovementText("+" + diff + "% in " + latest.getCategory() + " vs previous attempt");
                    } else if (diff < 0) {
                        stats.setRecentImprovementText(diff + "% in " + latest.getCategory() + " vs previous attempt");
                    } else {
                        stats.setRecentImprovementText("0% change in " + latest.getCategory() + " vs previous attempt");
                    }
                } else {
                    stats.setRecentImprovementPoints(0);
                    stats.setRecentImprovementText("First attempt in " + latest.getCategory() + " (" + (int)latest.getPercentage() + "%)");
                }
            } finally {
                if (cursor != null) cursor.close();
            }
        } else {
            stats.setRecentImprovementText("No quiz attempts yet");
        }

        return stats;
    }

    public boolean clearHistory(long userId) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int rows = db.delete(DatabaseHelper.TABLE_QUIZ_ATTEMPTS,
                DatabaseHelper.COL_ATTEMPT_USER_ID + " = ?", new String[]{String.valueOf(userId)});
        return rows >= 0;
    }

    private QuizAttempt parseAttempt(Cursor cursor) {
        QuizAttempt attempt = new QuizAttempt();
        attempt.setId(cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ATTEMPT_ID)));
        attempt.setUserId(cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ATTEMPT_USER_ID)));
        attempt.setCategory(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ATTEMPT_CATEGORY)));
        attempt.setDifficulty(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ATTEMPT_DIFFICULTY)));
        attempt.setTotalQuestions(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ATTEMPT_TOTAL_QUESTIONS)));
        attempt.setCorrectAnswers(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ATTEMPT_CORRECT_ANSWERS)));
        attempt.setIncorrectAnswers(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ATTEMPT_INCORRECT_ANSWERS)));
        attempt.setUnanswered(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ATTEMPT_UNANSWERED)));
        attempt.setScore(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ATTEMPT_SCORE)));
        attempt.setPercentage(cursor.getDouble(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ATTEMPT_PERCENTAGE)));
        attempt.setDurationSeconds(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ATTEMPT_DURATION)));
        attempt.setAttemptedAt(cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ATTEMPT_DATE)));
        return attempt;
    }
}
