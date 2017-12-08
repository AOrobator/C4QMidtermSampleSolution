package com.c4q.c4qmidtermsamplesolution.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.c4q.c4qmidtermsamplesolution.R;
import java.util.ArrayList;

public class ListFragment extends Fragment
    implements ListFragmentPresenter.ListFragmentPresentation {
  private static final String KEY_USERNAME = "username";

  public static ListFragment newInstance(String username) {
    Bundle args = new Bundle();
    args.putString(KEY_USERNAME, username);

    ListFragment listFragment = new ListFragment();
    listFragment.setArguments(args);
    return listFragment;
  }

  private MidtermAdapter midtermAdapter;

  private ListFragmentPresenter presenter;

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_list, container, false);

    Bundle args = getArguments();
    if (args != null) {
      String username = args.getString(KEY_USERNAME);
      TextView usernameTextView = view.findViewById(R.id.usernameTextView);
      usernameTextView.setText(username);
    }

    RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
    ArrayList<Integer> items = new ArrayList<>();

    for (int i = 0; i < 11; i++) {
      items.add(i);
    }

    presenter = new ListFragmentPresenter();
    midtermAdapter = new MidtermAdapter(items, presenter);
    recyclerView.setAdapter(midtermAdapter);
    recyclerView.addItemDecoration(
        new DividerItemDecoration(container.getContext(), LinearLayout.VERTICAL));

    return view;
  }

  @Override public void onStart() {
    super.onStart();

    presenter.attach(this);
  }

  @Override public void onStop() {
    super.onStop();

    presenter.detach();
  }

  @Override public void showNumber(int number) {
    ((ListActivity) getActivity()).showNumber(number);
  }
}
