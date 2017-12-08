package com.c4q.c4qmidtermsamplesolution;

import android.support.annotation.Nullable;

public class LoginPresenter {

  private final IPreferencesHelper prefHelper;
  private @Nullable LoginPresentation presentation;

  public LoginPresenter(IPreferencesHelper preferencesHelper) {
    this.prefHelper = preferencesHelper;
  }

  public void attach(LoginPresentation presentation) {
    this.presentation = presentation;

    presentation.setRememberCredentials(prefHelper.rememberLoginCredentials());

    if (prefHelper.rememberLoginCredentials()) {
      presentation.setUsername(prefHelper.getUsername());
      presentation.setPassword(prefHelper.getPassword());
    }
  }

  public void detach() {
    presentation = null;
  }

  public void onCredentialsCheckboxClicked(boolean rememberCredentials) {
    prefHelper.rememberLoginCredentials(rememberCredentials);

    if (presentation != null) {
      if (rememberCredentials) {
        String username = presentation.getUsername();
        String password = presentation.getPassword();

        prefHelper.saveUsername(username);
        prefHelper.savePassword(password);
      }
    }
  }

  public void onLoginButtonClicked() {
    if (presentation != null) {
      if (hasCorrectLoginCredentials()) {
        presentation.navigateToListActivity(presentation.getUsername());
      } else {
        presentation.showWrongLoginCredentials();
      }
    }
  }

  private boolean hasCorrectLoginCredentials() {
    return presentation != null
        && presentation.getUsername().equals("user@aol.com")
        && presentation.getPassword().equals("password1234");
  }

  interface LoginPresentation {

    String getUsername();

    String getPassword();

    void setUsername(String username);

    void setPassword(String password);

    void setRememberCredentials(boolean rememberLoginCredentials);

    void navigateToListActivity(String username);

    void showWrongLoginCredentials();
  }
}
