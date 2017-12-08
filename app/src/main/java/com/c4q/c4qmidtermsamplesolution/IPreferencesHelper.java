package com.c4q.c4qmidtermsamplesolution;

public interface IPreferencesHelper {
  void saveUsername(String username);

  String getUsername();

  void savePassword(String password);

  String getPassword();

  void rememberLoginCredentials(boolean rememberCredentials);

  boolean rememberLoginCredentials();
}
