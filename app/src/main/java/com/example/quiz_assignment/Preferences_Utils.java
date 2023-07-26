package com.example.quiz_assignment;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences_Utils {
    private static final String PREF_FILE_NAME = "MyPreferences"; // Replace with your desired file name
    private static final String KEY_TOTAL_QUESTIONS = "totalQuestions";
    private static final String KEY_TOTAL_CORRECT_ANSWERS = "totalCorrectAnswers";
    private static final String KEY_LANGUAGE = "language";

    // Method to save the total number of questions to SharedPreferences
    public static void saveTotalQuestions(Context context, int totalQuestions) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_TOTAL_QUESTIONS, totalQuestions);
        editor.apply();
    }

    // Method to retrieve the total number of questions from SharedPreferences
    public static int getTotalQuestions(Context context, int defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(KEY_TOTAL_QUESTIONS, defaultValue);
    }

    // Method to save the total number of correct answers to SharedPreferences
    public static void saveTotalCorrectAnswers(Context context, int totalCorrectAnswers) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_TOTAL_CORRECT_ANSWERS, totalCorrectAnswers);
        editor.apply();
    }

    // Method to retrieve the total number of correct answers from SharedPreferences
    public static int getTotalCorrectAnswers(Context context, int defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(KEY_TOTAL_CORRECT_ANSWERS, defaultValue);
    }

    // Method to delete the total number of questions from SharedPreferences
    public static void deleteTotalQuestions(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(KEY_TOTAL_QUESTIONS);
        editor.apply();
    }

    // Method to delete the total number of correct answers from SharedPreferences
    public static void deleteTotalCorrectAnswers(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(KEY_TOTAL_CORRECT_ANSWERS);
        editor.apply();
    }

    // Method to save the selected language to SharedPreferences
    public static void saveLanguage(MainActivity mainActivity, String selectedLanguage) {
        SharedPreferences sharedPreferences = mainActivity.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_LANGUAGE, selectedLanguage);
        editor.apply();
    }
}
