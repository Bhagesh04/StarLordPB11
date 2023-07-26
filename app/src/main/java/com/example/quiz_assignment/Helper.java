package com.example.quiz_assignment;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.preference.PreferenceManager;
import java.util.Locale;

public class Helper {
    private static final String SELECTED_LANGUAGE = "Locale.Helper.Selected.Language";

    // Method to set the language at runtime
    public static Context setLocale(Context context, String language) {
        persist(context, language);

        // If the specified language is not available, use the device's default language
        if (language.isEmpty() || !isLanguageAvailable(language)) {
            language = Locale.getDefault().getLanguage();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return updateResources(context, language);
        } else {
            return updateResourcesLegacy(context, language);
        }
    }

    // Check if the specified language is available on the device
    private static boolean isLanguageAvailable(String language) {
        Resources resources = Resources.getSystem();
        Configuration configuration = resources.getConfiguration();
        Locale locale = new Locale(language);
        configuration.setLocale(locale);
        try {
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Persist the selected language in SharedPreferences
    private static void persist(Context context, String language) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(SELECTED_LANGUAGE, language);
        editor.apply();
    }

    // Update the resources and configuration for devices with Android N and above
    @TargetApi(Build.VERSION_CODES.N)
    private static Context updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        configuration.setLayoutDirection(locale);
        return context.createConfigurationContext(configuration);
    }

    // Update the resources and configuration for devices below Android N
    @SuppressWarnings("deprecation")
    private static Context updateResourcesLegacy(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLayoutDirection(locale);
        }
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }

    // Get the selected language from SharedPreferences
    public static String getLanguage(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(SELECTED_LANGUAGE, ""); // Default to empty string (English)
    }
}
