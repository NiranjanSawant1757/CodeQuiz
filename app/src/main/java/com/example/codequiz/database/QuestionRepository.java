package com.example.codequiz.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.codequiz.model.Question;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionRepository {

    private final DatabaseHelper dbHelper;

    public QuestionRepository(Context context) {
        this.dbHelper = DatabaseHelper.getInstance(context);
    }

    /**
     * Saves a list of questions into the SQLite database.
     * Prevents duplicate questions based on question_text.
     * Returns the count of newly saved questions.
     */
    public int saveQuestions(List<Question> questions, String source) {
        if (questions == null || questions.isEmpty()) {
            return 0;
        }

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int insertedCount = 0;
        long now = System.currentTimeMillis();

        db.beginTransaction();
        try {
            for (Question q : questions) {
                if (q == null || q.getQuestionText() == null || q.getOptions() == null || q.getOptions().size() < 4) {
                    continue;
                }

                // Check if identical question_text already exists to avoid duplicate entries
                Cursor cursor = db.rawQuery(
                        "SELECT COUNT(*) FROM " + DatabaseHelper.TABLE_SAVED_QUESTIONS
                                + " WHERE " + DatabaseHelper.COL_Q_TEXT + " = ?",
                        new String[]{q.getQuestionText().trim()}
                );
                boolean exists = false;
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        exists = cursor.getInt(0) > 0;
                    }
                    cursor.close();
                }

                if (exists) {
                    continue; // Skip duplicate question
                }

                ContentValues cv = new ContentValues();
                cv.put(DatabaseHelper.COL_Q_ID, q.getId() != null ? q.getId() : "q_" + System.nanoTime());
                cv.put(DatabaseHelper.COL_Q_SUBJECT, q.getCategory());
                cv.put(DatabaseHelper.COL_Q_DIFFICULTY, q.getDifficulty());
                cv.put(DatabaseHelper.COL_Q_TEXT, q.getQuestionText().trim());

                // Serialize options to JSON array string
                JSONArray arr = new JSONArray();
                for (String opt : q.getOptions()) {
                    arr.put(opt);
                }
                cv.put(DatabaseHelper.COL_Q_OPTIONS_JSON, arr.toString());
                cv.put(DatabaseHelper.COL_Q_CORRECT, q.getCorrectAnswer());
                cv.put(DatabaseHelper.COL_Q_EXPLANATION, q.getExplanation());
                cv.put(DatabaseHelper.COL_Q_CREATED_AT, now);
                cv.put(DatabaseHelper.COL_Q_SOURCE, source != null ? source : "AI");

                long rowId = db.insertWithOnConflict(
                        DatabaseHelper.TABLE_SAVED_QUESTIONS,
                        null,
                        cv,
                        SQLiteDatabase.CONFLICT_IGNORE
                );

                if (rowId != -1) {
                    insertedCount++;
                }
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }

        return insertedCount;
    }

    /**
     * Retrieves saved questions from SQLite for offline reuse.
     * Randomizes the questions pool and returns up to requestedCount.
     */
    public List<Question> getSavedQuestions(String subject, String difficulty, int requestedCount) {
        List<Question> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        StringBuilder query = new StringBuilder("SELECT * FROM " + DatabaseHelper.TABLE_SAVED_QUESTIONS + " WHERE 1=1");
        List<String> args = new ArrayList<>();

        if (subject != null && !subject.trim().isEmpty() && !subject.equalsIgnoreCase("All")) {
            query.append(" AND " + DatabaseHelper.COL_Q_SUBJECT + " = ?");
            args.add(subject);
        }

        if (difficulty != null && !difficulty.trim().isEmpty() && !difficulty.equalsIgnoreCase("Mixed")) {
            // Map Beginner <-> Easy, Intermediate <-> Medium, Advanced <-> Hard if needed
            query.append(" AND (" + DatabaseHelper.COL_Q_DIFFICULTY + " = ? OR "
                    + DatabaseHelper.COL_Q_DIFFICULTY + " = ?)");
            args.add(difficulty);
            args.add(getEquivalentDifficulty(difficulty));
        }

        Cursor cursor = null;
        try {
            cursor = db.rawQuery(query.toString(), args.toArray(new String[0]));
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    Question q = parseQuestionFromCursor(cursor);
                    if (q != null) {
                        list.add(q);
                    }
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) cursor.close();
        }

        // Shuffle so each quiz attempt gets fresh variety
        Collections.shuffle(list);

        if (requestedCount > 0 && list.size() > requestedCount) {
            return new ArrayList<>(list.subList(0, requestedCount));
        }

        return list;
    }

    /**
     * Returns count of saved questions matching subject and difficulty.
     */
    public int getSavedQuestionCount(String subject, String difficulty) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        StringBuilder query = new StringBuilder("SELECT COUNT(*) FROM " + DatabaseHelper.TABLE_SAVED_QUESTIONS + " WHERE 1=1");
        List<String> args = new ArrayList<>();

        if (subject != null && !subject.trim().isEmpty() && !subject.equalsIgnoreCase("All")) {
            query.append(" AND " + DatabaseHelper.COL_Q_SUBJECT + " = ?");
            args.add(subject);
        }

        if (difficulty != null && !difficulty.trim().isEmpty() && !difficulty.equalsIgnoreCase("Mixed")) {
            query.append(" AND (" + DatabaseHelper.COL_Q_DIFFICULTY + " = ? OR "
                    + DatabaseHelper.COL_Q_DIFFICULTY + " = ?)");
            args.add(difficulty);
            args.add(getEquivalentDifficulty(difficulty));
        }

        Cursor cursor = null;
        try {
            cursor = db.rawQuery(query.toString(), args.toArray(new String[0]));
            if (cursor != null && cursor.moveToFirst()) {
                return cursor.getInt(0);
            }
        } finally {
            if (cursor != null) cursor.close();
        }
        return 0;
    }

    /**
     * Total number of questions saved locally.
     */
    public int getTotalSavedQuestionsCount() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT COUNT(*) FROM " + DatabaseHelper.TABLE_SAVED_QUESTIONS, null);
            if (cursor != null && cursor.moveToFirst()) {
                return cursor.getInt(0);
            }
        } finally {
            if (cursor != null) cursor.close();
        }
        return 0;
    }

    private Question parseQuestionFromCursor(Cursor cursor) {
        try {
            String id = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_Q_ID));
            String subject = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_Q_SUBJECT));
            String difficulty = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_Q_DIFFICULTY));
            String text = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_Q_TEXT));
            String optionsJson = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_Q_OPTIONS_JSON));
            String correct = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_Q_CORRECT));
            String explanation = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_Q_EXPLANATION));

            List<String> options = new ArrayList<>();
            if (optionsJson != null && !optionsJson.isEmpty()) {
                JSONArray arr = new JSONArray(optionsJson);
                for (int i = 0; i < arr.length(); i++) {
                    options.add(arr.getString(i));
                }
            }

            return new Question(id, subject, difficulty, text, options, correct, explanation);
        } catch (JSONException e) {
            return null;
        }
    }

    private String getEquivalentDifficulty(String diff) {
        if ("Beginner".equalsIgnoreCase(diff)) return "Easy";
        if ("Easy".equalsIgnoreCase(diff)) return "Beginner";
        if ("Intermediate".equalsIgnoreCase(diff)) return "Medium";
        if ("Medium".equalsIgnoreCase(diff)) return "Intermediate";
        if ("Advanced".equalsIgnoreCase(diff)) return "Hard";
        if ("Hard".equalsIgnoreCase(diff)) return "Advanced";
        return diff;
    }
}
