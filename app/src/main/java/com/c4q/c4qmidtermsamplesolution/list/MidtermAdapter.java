package com.c4q.c4qmidtermsamplesolution.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.c4q.c4qmidtermsamplesolution.R;
import java.util.ArrayList;

public class MidtermAdapter extends RecyclerView.Adapter<MidtermAdapter.MyViewHolder> {
  private final ArrayList<Integer> items;
  private final ListFragmentPresenter presenter;

  public MidtermAdapter(ArrayList<Integer> items, ListFragmentPresenter presenter) {
    this.presenter = presenter;
    this.items = items;
  }

  @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View view = inflater.inflate(R.layout.list_item, parent, false);
    return new MyViewHolder(view);
  }

  @Override public void onBindViewHolder(MyViewHolder holder, int position) {
    holder.bind(items.get(position));
  }

  @Override public int getItemCount() {
    return items.size();
  }

  public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView numberText;

    public MyViewHolder(View itemView) {
      super(itemView);

      numberText = itemView.findViewById(R.id.text);
    }

    public void bind(final int number) {
      numberText.setText(itemView.getContext().getString(R.string.this_is_number, number));
      itemView.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View view) {
          presenter.onNumberClicked(number);
        }
      });
    }
  }
}
