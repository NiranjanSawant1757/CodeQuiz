package com.example.codequiz.network;

import android.content.Context;
import android.util.Log;

import com.example.codequiz.model.Question;
import com.example.codequiz.util.NetworkUtils;
import com.example.codequiz.util.SessionManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class AiApiClient {

    private static final String TAG = "AiApiClient";
    private static final int CONNECT_TIMEOUT_MS = 15000;
    private static final int READ_TIMEOUT_MS = 45000;

    /**
     * Calls the backend server to generate AI questions.
     * Validates that questions have exactly 4 options and a valid matching correct answer.
     */
    public static List<Question> generateQuestions(Context context, String subject, String difficulty, int count) throws Exception {
        if (!NetworkUtils.isNetworkAvailable(context)) {
            throw new Exception("No network connection. Please check your internet or Wi-Fi settings.");
        }

        String baseUrl = SessionManager.getInstance(context).getBackendUrl();
        if (baseUrl.endsWith("/")) {
            baseUrl = baseUrl.substring(0, baseUrl.length() - 1);
        }

        String endpoint = baseUrl + "/api/generate-mcqs";
        Log.d(TAG, "Requesting AI MCQs from endpoint: " + endpoint);

        // Build request payload
        JSONObject reqJson = new JSONObject();
        reqJson.put("subject", subject);
        reqJson.put("difficulty", difficulty);
        reqJson.put("count", count);

        HttpURLConnection conn = null;
        try {
            URL url = new URL(endpoint);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setConnectTimeout(CONNECT_TIMEOUT_MS);
            conn.setReadTimeout(READ_TIMEOUT_MS);
            conn.setDoOutput(true);
            conn.setDoInput(true);

            // Write body
            byte[] outputBytes = reqJson.toString().getBytes(StandardCharsets.UTF_8);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(outputBytes);
                os.flush();
            }

            int responseCode = conn.getResponseCode();
            Log.d(TAG, "Response code from backend: " + responseCode);

            InputStream is;
            if (responseCode >= 200 && responseCode < 300) {
                is = conn.getInputStream();
            } else {
                is = conn.getErrorStream();
            }

            String responseString = readStream(is);

            if (responseCode != HttpURLConnection.HTTP_OK) {
                String errorMessage = "Server returned error " + responseCode;
                try {
                    JSONObject errObj = new JSONObject(responseString);
                    if (errObj.has("error")) {
                        errorMessage = errObj.getString("error");
                    } else if (errObj.has("detail")) {
                        errorMessage = errObj.getString("detail");
                    }
                } catch (Exception ignored) {
                    if (responseString != null && !responseString.trim().isEmpty()) {
                        errorMessage = responseString;
                    }
                }
                throw new Exception(errorMessage);
            }

            // Parse success response
            JSONObject respObj = new JSONObject(responseString);
            if (!respObj.optBoolean("success", true)) {
                String msg = respObj.optString("message", "Question generation failed.");
                throw new Exception(msg);
            }

            JSONArray questionsArr = respObj.getJSONArray("questions");
            List<Question> parsedQuestions = new ArrayList<>();

            for (int i = 0; i < questionsArr.length(); i++) {
                JSONObject qObj = questionsArr.getJSONObject(i);
                String id = qObj.optString("id", "ai_q_" + System.currentTimeMillis() + "_" + i);
                String qSubject = qObj.optString("subject", subject);
                String qDifficulty = qObj.optString("difficulty", difficulty);
                String questionText = qObj.getString("question_text").trim();
                String correctAnswer = qObj.getString("correct_answer").trim();
                String explanation = qObj.optString("explanation", "Correct answer verified.").trim();

                JSONArray optsArr = qObj.getJSONArray("options");
                if (optsArr.length() != 4) {
                    Log.w(TAG, "Skipping malformed question without 4 options: " + questionText);
                    continue;
                }

                List<String> options = new ArrayList<>();
                boolean foundCorrect = false;
                for (int j = 0; j < 4; j++) {
                    String opt = optsArr.getString(j).trim();
                    options.add(opt);
                    if (opt.equalsIgnoreCase(correctAnswer)) {
                        foundCorrect = true;
                    }
                }

                if (!foundCorrect) {
                    Log.w(TAG, "Skipping question whose correct answer does not match any options: " + questionText);
                    continue;
                }

                parsedQuestions.add(new Question(id, qSubject, qDifficulty, questionText, options, correctAnswer, explanation));
            }

            if (parsedQuestions.isEmpty()) {
                throw new Exception("Received 0 valid questions from AI service. Please try again.");
            }

            Log.i(TAG, "Successfully parsed and validated " + parsedQuestions.size() + " AI questions.");
            return parsedQuestions;

        } catch (SocketTimeoutException ste) {
            throw new Exception("Connection to AI backend timed out. Please verify that the backend server is running.");
        } catch (java.net.ConnectException ce) {
            throw new Exception("Unable to connect to AI server at " + baseUrl + ". Please check if backend is running and URL is correct.");
        } catch (JSONException je) {
            throw new Exception("Failed to parse response from AI server: " + je.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    /**
     * Checks if the backend server is reachable and reports AI status.
     */
    public static JSONObject checkServerHealth(Context context) throws Exception {
        if (!NetworkUtils.isNetworkAvailable(context)) {
            throw new Exception("No active network connection.");
        }

        String baseUrl = SessionManager.getInstance(context).getBackendUrl();
        if (baseUrl.endsWith("/")) {
            baseUrl = baseUrl.substring(0, baseUrl.length() - 1);
        }

        String endpoint = baseUrl + "/health";
        HttpURLConnection conn = null;
        try {
            URL url = new URL(endpoint);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setConnectTimeout(8000);
            conn.setReadTimeout(8000);

            int code = conn.getResponseCode();
            if (code == 200) {
                String responseStr = readStream(conn.getInputStream());
                return new JSONObject(responseStr);
            } else {
                throw new Exception("Server responded with HTTP " + code);
            }
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    private static String readStream(InputStream is) throws Exception {
        if (is == null) return "";
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        }
        return sb.toString().trim();
    }
}
