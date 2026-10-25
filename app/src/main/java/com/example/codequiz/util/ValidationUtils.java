package com.example.codequiz.util;

import java.util.regex.Pattern;

public class ValidationUtils {

    // Standard RFC-compatible regex that executes seamlessly both on Android devices and in JVM unit tests
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );

    public static boolean isValidEmail(String email) {
        if (email == null) return false;
        String trimmed = email.trim();
        return !trimmed.isEmpty() && EMAIL_PATTERN.matcher(trimmed).matches();
    }

    public static boolean isValidUsername(String username) {
        if (username == null) return false;
        String trimmed = username.trim();
        // 3 to 20 alphanumeric characters or underscores
        return trimmed.matches("^[a-zA-Z0-9_]{3,20}$");
    }

    public static boolean isValidPassword(String password) {
        if (password == null) return false;
        // Minimum 6 characters
        return password.length() >= 6;
    }

    public static boolean isNotEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }
}
