package com.c4q.c4qmidtermsamplesolution;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Helper class used to access {@link SharedPreferences}
 * */
public class PreferencesHelper implements IPreferencesHelper {
  private static final String KEY_PREF_USERNAME = "username pref";
  private static final String KEY_PREF_PASSWORD = "password pref";
  private static final String KEY_PREF_REMEMBER_CREDENTIALS = "remember credentials pref";
  private final Context context;

  public PreferencesHelper(Context context) {
    this.context = context;
  }

  @Override public void saveUsername(String username) {
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
    prefs.edit().putString(KEY_PREF_USERNAME, username).apply();
  }

  @Override public String getUsername() {
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
    String defaultValue = ""; // Value used if saved username doesn't exist
    return prefs.getString(KEY_PREF_USERNAME, defaultValue);
  }

  @Override public void savePassword(String password) {
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
    prefs.edit().putString(KEY_PREF_PASSWORD, password).apply();
  }

  @Override public String getPassword() {
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
    String defaultValue = ""; // Value used if saved password doesn't exist
    return prefs.getString(KEY_PREF_PASSWORD, defaultValue);
  }

  @Override public void rememberLoginCredentials(boolean rememberCredentials) {
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
    prefs.edit().putBoolean(KEY_PREF_REMEMBER_CREDENTIALS, rememberCredentials).apply();
  }

  @Override public boolean rememberLoginCredentials() {
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
    boolean defaultValue = false;
    return prefs.getBoolean(KEY_PREF_REMEMBER_CREDENTIALS, defaultValue);
  }
}
