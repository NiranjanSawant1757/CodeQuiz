package com.example.codequiz.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.codequiz.model.User;
import com.example.codequiz.util.PasswordUtils;

import java.util.Locale;

public class UserRepository {

    private final DatabaseHelper dbHelper;

    public UserRepository(Context context) {
        this.dbHelper = DatabaseHelper.getInstance(context);
    }

    /**
     * Registers a new user with PBKDF2 hashed password and unique salt.
     * Returns the newly created user ID, or -1 on failure.
     */
    public long registerUser(String fullName, String email, String username, String password) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String normalizedEmail = email.trim().toLowerCase(Locale.ROOT);
        String normalizedUsername = username.trim().toLowerCase(Locale.ROOT);

        String salt = PasswordUtils.generateSalt();
        String hash = PasswordUtils.hashPassword(password, salt);
        long currentTime = System.currentTimeMillis();

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COL_USER_FULL_NAME, fullName.trim());
        values.put(DatabaseHelper.COL_USER_EMAIL, normalizedEmail);
        values.put(DatabaseHelper.COL_USER_USERNAME, normalizedUsername);
        values.put(DatabaseHelper.COL_USER_PASSWORD_HASH, hash);
        values.put(DatabaseHelper.COL_USER_PASSWORD_SALT, salt);
        values.put(DatabaseHelper.COL_USER_CREATED_AT, currentTime);

        return db.insert(DatabaseHelper.TABLE_USERS, null, values);
    }

    /**
     * Authenticates a user by email or username.
     * Returns the User object if credentials are correct, null otherwise.
     */
    public User login(String identifier, String password) {
        if (identifier == null || password == null) return null;
        String normalized = identifier.trim().toLowerCase(Locale.ROOT);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query = "SELECT * FROM " + DatabaseHelper.TABLE_USERS
                + " WHERE LOWER(" + DatabaseHelper.COL_USER_EMAIL + ") = ? "
                + " OR LOWER(" + DatabaseHelper.COL_USER_USERNAME + ") = ? LIMIT 1";

        Cursor cursor = null;
        try {
            cursor = db.rawQuery(query, new String[]{normalized, normalized});
            if (cursor != null && cursor.moveToFirst()) {
                String storedHash = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_USER_PASSWORD_HASH));
                String storedSalt = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_USER_PASSWORD_SALT));

                if (PasswordUtils.verifyPassword(password, storedSalt, storedHash)) {
                    User user = new User();
                    user.setId(cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_USER_ID)));
                    user.setFullName(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_USER_FULL_NAME)));
                    user.setEmail(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_USER_EMAIL)));
                    user.setUsername(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_USER_USERNAME)));
                    user.setPasswordHash(storedHash);
                    user.setPasswordSalt(storedSalt);
                    int profileCol = cursor.getColumnIndex(DatabaseHelper.COL_USER_PROFILE_IMAGE);
                    if (profileCol != -1) {
                        user.setProfileImage(cursor.getString(profileCol));
                    }
                    user.setCreatedAt(cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_USER_CREATED_AT)));
                    return user;
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return null;
    }

    public boolean isEmailTaken(String email) {
        String normalized = email.trim().toLowerCase(Locale.ROOT);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT 1 FROM " + DatabaseHelper.TABLE_USERS
                    + " WHERE LOWER(" + DatabaseHelper.COL_USER_EMAIL + ") = ? LIMIT 1", new String[]{normalized});
            return cursor != null && cursor.moveToFirst();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public boolean isUsernameTaken(String username) {
        String normalized = username.trim().toLowerCase(Locale.ROOT);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT 1 FROM " + DatabaseHelper.TABLE_USERS
                    + " WHERE LOWER(" + DatabaseHelper.COL_USER_USERNAME + ") = ? LIMIT 1", new String[]{normalized});
            return cursor != null && cursor.moveToFirst();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public User getUserById(long userId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_USERS
                    + " WHERE " + DatabaseHelper.COL_USER_ID + " = ? LIMIT 1", new String[]{String.valueOf(userId)});
            if (cursor != null && cursor.moveToFirst()) {
                User user = new User();
                user.setId(cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_USER_ID)));
                user.setFullName(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_USER_FULL_NAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_USER_EMAIL)));
                user.setUsername(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_USER_USERNAME)));
                int profileCol = cursor.getColumnIndex(DatabaseHelper.COL_USER_PROFILE_IMAGE);
                if (profileCol != -1) {
                    user.setProfileImage(cursor.getString(profileCol));
                }
                user.setCreatedAt(cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_USER_CREATED_AT)));
                return user;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return null;
    }

    public boolean updateFullName(long userId, String newFullName) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COL_USER_FULL_NAME, newFullName.trim());
        int rows = db.update(DatabaseHelper.TABLE_USERS, values,
                DatabaseHelper.COL_USER_ID + " = ?", new String[]{String.valueOf(userId)});
        return rows > 0;
    }

    public boolean updateProfileImage(long userId, String imagePath) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COL_USER_PROFILE_IMAGE, imagePath);
        int rows = db.update(DatabaseHelper.TABLE_USERS, values,
                DatabaseHelper.COL_USER_ID + " = ?", new String[]{String.valueOf(userId)});
        return rows > 0;
    }

    public String getProfileImage(long userId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT " + DatabaseHelper.COL_USER_PROFILE_IMAGE + " FROM " + DatabaseHelper.TABLE_USERS
                    + " WHERE " + DatabaseHelper.COL_USER_ID + " = ? LIMIT 1", new String[]{String.valueOf(userId)});
            if (cursor != null && cursor.moveToFirst()) {
                return cursor.getString(0);
            }
        } catch (Exception ignored) {
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return null;
    }

    public boolean changePassword(long userId, String oldPassword, String newPassword) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT " + DatabaseHelper.COL_USER_PASSWORD_HASH + ", "
                    + DatabaseHelper.COL_USER_PASSWORD_SALT + " FROM " + DatabaseHelper.TABLE_USERS
                    + " WHERE " + DatabaseHelper.COL_USER_ID + " = ? LIMIT 1", new String[]{String.valueOf(userId)});
            if (cursor != null && cursor.moveToFirst()) {
                String storedHash = cursor.getString(0);
                String storedSalt = cursor.getString(1);

                if (PasswordUtils.verifyPassword(oldPassword, storedSalt, storedHash)) {
                    String newSalt = PasswordUtils.generateSalt();
                    String newHash = PasswordUtils.hashPassword(newPassword, newSalt);

                    ContentValues values = new ContentValues();
                    values.put(DatabaseHelper.COL_USER_PASSWORD_HASH, newHash);
                    values.put(DatabaseHelper.COL_USER_PASSWORD_SALT, newSalt);

                    int rows = db.update(DatabaseHelper.TABLE_USERS, values,
                            DatabaseHelper.COL_USER_ID + " = ?", new String[]{String.valueOf(userId)});
                    return rows > 0;
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return false;
    }
}
