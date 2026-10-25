package com.example.codequiz.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "codequiz.db";
    private static final int DATABASE_VERSION = 1;

    private static DatabaseHelper instance;

    // Table: users
    public static final String TABLE_USERS = "users";
    public static final String COL_USER_ID = "id";
    public static final String COL_USER_FULL_NAME = "full_name";
    public static final String COL_USER_EMAIL = "email";
    public static final String COL_USER_USERNAME = "username";
    public static final String COL_USER_PASSWORD_HASH = "password_hash";
    public static final String COL_USER_PASSWORD_SALT = "password_salt";
    public static final String COL_USER_CREATED_AT = "created_at";

    // Table: quiz_attempts
    public static final String TABLE_QUIZ_ATTEMPTS = "quiz_attempts";
    public static final String COL_ATTEMPT_ID = "id";
    public static final String COL_ATTEMPT_USER_ID = "user_id";
    public static final String COL_ATTEMPT_CATEGORY = "category";
    public static final String COL_ATTEMPT_DIFFICULTY = "difficulty";
    public static final String COL_ATTEMPT_TOTAL_QUESTIONS = "total_questions";
    public static final String COL_ATTEMPT_CORRECT_ANSWERS = "correct_answers";
    public static final String COL_ATTEMPT_INCORRECT_ANSWERS = "incorrect_answers";
    public static final String COL_ATTEMPT_UNANSWERED = "unanswered";
    public static final String COL_ATTEMPT_SCORE = "score";
    public static final String COL_ATTEMPT_PERCENTAGE = "percentage";
    public static final String COL_ATTEMPT_DURATION = "duration_seconds";
    public static final String COL_ATTEMPT_DATE = "attempted_at";

    // Table: quiz_attempt_answers
    public static final String TABLE_ATTEMPT_ANSWERS = "quiz_attempt_answers";
    public static final String COL_ANS_ID = "id";
    public static final String COL_ANS_ATTEMPT_ID = "attempt_id";
    public static final String COL_ANS_QUESTION_ID = "question_id";
    public static final String COL_ANS_QUESTION_TEXT = "question_text";
    public static final String COL_ANS_OPTIONS_JSON = "options_json";
    public static final String COL_ANS_SELECTED = "selected_answer";
    public static final String COL_ANS_CORRECT = "correct_answer";
    public static final String COL_ANS_EXPLANATION = "explanation";
    public static final String COL_ANS_IS_CORRECT = "is_correct";
    public static final String COL_ANS_QUESTION_ORDER = "question_order";

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create users table
        String createUsersTable = "CREATE TABLE " + TABLE_USERS + " ("
                + COL_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_USER_FULL_NAME + " TEXT NOT NULL, "
                + COL_USER_EMAIL + " TEXT NOT NULL UNIQUE, "
                + COL_USER_USERNAME + " TEXT NOT NULL UNIQUE, "
                + COL_USER_PASSWORD_HASH + " TEXT NOT NULL, "
                + COL_USER_PASSWORD_SALT + " TEXT NOT NULL, "
                + COL_USER_CREATED_AT + " INTEGER NOT NULL"
                + ");";

        // Create quiz_attempts table
        String createAttemptsTable = "CREATE TABLE " + TABLE_QUIZ_ATTEMPTS + " ("
                + COL_ATTEMPT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_ATTEMPT_USER_ID + " INTEGER NOT NULL, "
                + COL_ATTEMPT_CATEGORY + " TEXT NOT NULL, "
                + COL_ATTEMPT_DIFFICULTY + " TEXT NOT NULL, "
                + COL_ATTEMPT_TOTAL_QUESTIONS + " INTEGER NOT NULL, "
                + COL_ATTEMPT_CORRECT_ANSWERS + " INTEGER NOT NULL, "
                + COL_ATTEMPT_INCORRECT_ANSWERS + " INTEGER NOT NULL, "
                + COL_ATTEMPT_UNANSWERED + " INTEGER NOT NULL, "
                + COL_ATTEMPT_SCORE + " INTEGER NOT NULL, "
                + COL_ATTEMPT_PERCENTAGE + " REAL NOT NULL, "
                + COL_ATTEMPT_DURATION + " INTEGER NOT NULL, "
                + COL_ATTEMPT_DATE + " INTEGER NOT NULL, "
                + "FOREIGN KEY (" + COL_ATTEMPT_USER_ID + ") REFERENCES "
                + TABLE_USERS + "(" + COL_USER_ID + ") ON DELETE CASCADE"
                + ");";

        // Create quiz_attempt_answers table
        String createAttemptAnswersTable = "CREATE TABLE " + TABLE_ATTEMPT_ANSWERS + " ("
                + COL_ANS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_ANS_ATTEMPT_ID + " INTEGER NOT NULL, "
                + COL_ANS_QUESTION_ID + " TEXT NOT NULL, "
                + COL_ANS_QUESTION_TEXT + " TEXT NOT NULL, "
                + COL_ANS_OPTIONS_JSON + " TEXT NOT NULL, "
                + COL_ANS_SELECTED + " TEXT, "
                + COL_ANS_CORRECT + " TEXT NOT NULL, "
                + COL_ANS_EXPLANATION + " TEXT, "
                + COL_ANS_IS_CORRECT + " INTEGER NOT NULL, "
                + COL_ANS_QUESTION_ORDER + " INTEGER NOT NULL, "
                + "FOREIGN KEY (" + COL_ANS_ATTEMPT_ID + ") REFERENCES "
                + TABLE_QUIZ_ATTEMPTS + "(" + COL_ATTEMPT_ID + ") ON DELETE CASCADE"
                + ");";

        db.execSQL(createUsersTable);
        db.execSQL(createAttemptsTable);
        db.execSQL(createAttemptAnswersTable);

        // Create indexes for efficient querying
        db.execSQL("CREATE INDEX idx_attempts_user_id ON " + TABLE_QUIZ_ATTEMPTS + " (" + COL_ATTEMPT_USER_ID + ");");
        db.execSQL("CREATE INDEX idx_attempts_category ON " + TABLE_QUIZ_ATTEMPTS + " (" + COL_ATTEMPT_CATEGORY + ");");
        db.execSQL("CREATE INDEX idx_answers_attempt_id ON " + TABLE_ATTEMPT_ANSWERS + " (" + COL_ANS_ATTEMPT_ID + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Preserves existing data across schema updates
        if (oldVersion < 2) {
            // Future schema additions will execute ALTER TABLE here without dropping tables
        }
    }
}
