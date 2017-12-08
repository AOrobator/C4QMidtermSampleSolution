package com.c4q.c4qmidtermsamplesolution;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NumberFragment extends Fragment {
  private static final String KEY_DISPLAY_NUMBER = "display number";

  public static NumberFragment newInstance(int numberToDisplay) {
    Bundle args = new Bundle();
    args.putInt(KEY_DISPLAY_NUMBER, numberToDisplay);

    NumberFragment numberFragment = new NumberFragment();
    numberFragment.setArguments(args);

    return numberFragment;
  }

  @Nullable @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_number_display, container, false);

    TextView textView = view.findViewById(R.id.numberText);

    Bundle args = getArguments();

    if (args != null) {
      int displayNumber = args.getInt(KEY_DISPLAY_NUMBER);
      textView.setText(Integer.toString(displayNumber));
    }

    return view;
  }
}
