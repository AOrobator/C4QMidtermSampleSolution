package com.c4q.c4qmidtermsamplesolution;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.c4q.c4qmidtermsamplesolution.login.LoginActivity;

public class LoopActivity extends AppCompatActivity {

  private TextView loopCounterTextView;
  private MidtermAsyncTask asyncTask;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_loop);

    loopCounterTextView = findViewById(R.id.loopCounterTextView);

    asyncTask = new MidtermAsyncTask(this);
    asyncTask.execute(99_990);
  }

  @Override protected void onPause() {
    super.onPause();

    // Don't leak a reference to an Activity
    asyncTask.activity = null;
  }

  private static class MidtermAsyncTask extends AsyncTask<Integer, Integer, Integer> {

    @SuppressLint("StaticFieldLeak") private @Nullable LoopActivity activity;

    MidtermAsyncTask(@Nullable LoopActivity activity) {
      this.activity = activity;
    }

    @Override protected Integer doInBackground(Integer... integers) {
      int start = integers[0];

      for (int i = start; i < 100_000; i++) {
        try {
          // Don't touch the main thread too often or else you'll freeze the app
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        publishProgress(i);
      }

      return 100_000 - start;
    }

    @Override protected void onPreExecute() {
      super.onPreExecute();
    }

    @Override protected void onPostExecute(Integer result) {
      super.onPostExecute(result);

      if (activity != null) {
        activity.loopCounterTextView.setText(activity.getString(R.string.loops_completed, result));
        Intent loginIntent = new Intent(activity, LoginActivity.class);
        activity.startActivity(loginIntent);
      }
    }

    @Override protected void onProgressUpdate(Integer... values) {
      super.onProgressUpdate(values);

      int progress = values[0];

      if (activity != null) {
        activity.loopCounterTextView.setText(
            activity.getString(R.string.loops_completed, progress));
      }
    }
  }
}
