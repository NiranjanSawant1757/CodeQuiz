package com.example.codequiz.util;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatDelegate;

public class SessionManager {

    private static final String PREF_NAME = "CodeQuizSession";
    private static final String KEY_IS_LOGGED_IN = "is_logged_in";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_FULL_NAME = "full_name";
    private static final String KEY_PROFILE_IMAGE = "profile_image";

    // Settings Keys
    private static final String KEY_TIMER_ENABLED = "pref_timer_enabled";
    private static final String KEY_TIMER_SECONDS = "pref_timer_seconds";
    private static final String KEY_THEME_MODE = "pref_theme_mode";

    private final SharedPreferences prefs;
    private final SharedPreferences.Editor editor;

    private static SessionManager instance;

    public static synchronized SessionManager getInstance(Context context) {
        if (instance == null) {
            instance = new SessionManager(context.getApplicationContext());
        }
        return instance;
    }

    private SessionManager(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void createLoginSession(long userId, String username, String email, String fullName) {
        createLoginSession(userId, username, email, fullName, null);
    }

    public void createLoginSession(long userId, String username, String email, String fullName, String profileImage) {
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.putLong(KEY_USER_ID, userId);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_FULL_NAME, fullName);
        if (profileImage != null) {
            editor.putString(KEY_PROFILE_IMAGE, profileImage);
        } else {
            editor.remove(KEY_PROFILE_IMAGE);
        }
        editor.apply();
    }

    public boolean isLoggedIn() {
        return prefs.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    public long getUserId() {
        return prefs.getLong(KEY_USER_ID, -1);
    }

    public String getUsername() {
        return prefs.getString(KEY_USERNAME, "");
    }

    public String getEmail() {
        return prefs.getString(KEY_EMAIL, "");
    }

    public String getFullName() {
        return prefs.getString(KEY_FULL_NAME, "");
    }

    public String getProfileImage() {
        return prefs.getString(KEY_PROFILE_IMAGE, null);
    }

    public void updateFullName(String fullName) {
        editor.putString(KEY_FULL_NAME, fullName);
        editor.apply();
    }

    public void updateProfileImage(String profileImagePath) {
        if (profileImagePath != null) {
            editor.putString(KEY_PROFILE_IMAGE, profileImagePath);
        } else {
            editor.remove(KEY_PROFILE_IMAGE);
        }
        editor.apply();
    }

    public void logoutUser() {
        editor.remove(KEY_IS_LOGGED_IN);
        editor.remove(KEY_USER_ID);
        editor.remove(KEY_USERNAME);
        editor.remove(KEY_EMAIL);
        editor.remove(KEY_FULL_NAME);
        editor.remove(KEY_PROFILE_IMAGE);
        editor.apply();
    }

    // Quiz Preferences
    public boolean isTimerEnabled() {
        return prefs.getBoolean(KEY_TIMER_ENABLED, true);
    }

    public void setTimerEnabled(boolean enabled) {
        editor.putBoolean(KEY_TIMER_ENABLED, enabled);
        editor.apply();
    }

    public int getTimerSeconds() {
        return prefs.getInt(KEY_TIMER_SECONDS, AppConstants.DEFAULT_SECONDS_PER_QUESTION);
    }

    public void setTimerSeconds(int seconds) {
        editor.putInt(KEY_TIMER_SECONDS, seconds);
        editor.apply();
    }

    // Theme Preferences
    public int getThemeMode() {
        return prefs.getInt(KEY_THEME_MODE, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
    }

    public void setThemeMode(int mode) {
        editor.putInt(KEY_THEME_MODE, mode);
        editor.apply();
        AppCompatDelegate.setDefaultNightMode(mode);
    }

    public void applyStoredTheme() {
        int mode = getThemeMode();
        AppCompatDelegate.setDefaultNightMode(mode);
    }
}
