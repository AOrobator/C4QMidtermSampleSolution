package com.c4q.c4qmidtermsamplesolution.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import com.c4q.c4qmidtermsamplesolution.NumberFragment;
import com.c4q.c4qmidtermsamplesolution.R;

public class ListActivity extends AppCompatActivity {
  private static final String KEY_USERNAME = "username";

  public static Intent getNewIntent(Context context, String username) {
    Intent intent = new Intent(context, ListActivity.class);
    intent.putExtra(KEY_USERNAME, username);
    return intent;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list);

    String username = getIntent().getStringExtra(KEY_USERNAME);

    FragmentManager fragmentManager = getSupportFragmentManager();
    fragmentManager.beginTransaction()
        .replace(R.id.fragmentContainer, ListFragment.newInstance(username))
        .commit();

    // Do the fragment commit now instead of asynchronously
    fragmentManager.executePendingTransactions();
  }

  public void showNumber(int number) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    fragmentManager.beginTransaction()
        .replace(R.id.fragmentContainer, NumberFragment.newInstance(number))
        .addToBackStack(Integer.toString(number))
        .commit();

    fragmentManager.executePendingTransactions();
  }
}
