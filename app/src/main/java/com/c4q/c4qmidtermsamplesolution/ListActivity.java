package com.c4q.c4qmidtermsamplesolution;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {
  private static final String KEY_USERNAME = "username";

  public static Intent getIntent(Context context, String username) {
    Intent intent = new Intent(context, ListActivity.class);
    intent.putExtra(KEY_USERNAME, username);
    return intent;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list);
  }
}
