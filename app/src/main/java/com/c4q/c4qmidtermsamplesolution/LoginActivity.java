package com.c4q.c4qmidtermsamplesolution;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements LoginPresenter.LoginPresentation {

  private LoginPresenter presenter;
  private EditText usernameEditText;
  private EditText passwordEditText;
  private CheckBox rememberCredentialsCheckBox;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    presenter = new LoginPresenter(new PreferencesHelper(this));

    rememberCredentialsCheckBox = findViewById(R.id.rememberCredentialsCheckBox);
    rememberCredentialsCheckBox.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        presenter.onCredentialsCheckboxClicked(rememberCredentialsCheckBox.isChecked());
      }
    });

    usernameEditText = findViewById(R.id.usernameEditText);
    passwordEditText = findViewById(R.id.passwordEditText);

    Button loginButton = findViewById(R.id.loginButton);
    loginButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        presenter.onLoginButtonClicked();
      }
    });
  }

  @Override protected void onStart() {
    super.onStart();

    presenter.attach(this);
  }

  @Override protected void onStop() {
    super.onStop();

    presenter.detach();
  }

  @Override public String getUsername() {
    return usernameEditText.getText().toString();
  }

  @Override public String getPassword() {
    return passwordEditText.getText().toString();
  }

  @Override public void setUsername(String username) {
    usernameEditText.setText(username);
  }

  @Override public void setPassword(String password) {
    passwordEditText.setText(password);
  }

  @Override public void setRememberCredentials(boolean rememberLoginCredentials) {
    rememberCredentialsCheckBox.setChecked(rememberLoginCredentials);
  }

  @Override public void navigateToListActivity(String username) {
    Intent intent = ListActivity.getIntent(this, username);
    startActivity(intent);
  }

  @Override public void showWrongLoginCredentials() {
    Toast.makeText(this, "Incorrect Username & Password", Toast.LENGTH_SHORT).show();
  }
}
