package com.c4q.c4qmidtermsamplesolution.list;

import android.support.annotation.Nullable;

class ListFragmentPresenter {

  private @Nullable ListFragmentPresentation presentation;

  public void attach(ListFragmentPresentation presentation) {
    this.presentation = presentation;
  }

  public void detach() {
    presentation = null;
  }

  public void onNumberClicked(int number) {
    if (presentation != null) {
      presentation.showNumber(number * 10);
    }
  }

  interface ListFragmentPresentation {

    void showNumber(int number);
  }
}
