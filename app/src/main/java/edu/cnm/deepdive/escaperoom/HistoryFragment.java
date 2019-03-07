package edu.cnm.deepdive.escaperoom;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import edu.cnm.deepdive.escaperoom.model.entity.ActionHistory;


public class HistoryFragment extends Fragment {
  ActionHistory actionHistory = new ActionHistory();
  TextView history = new TextView();
  public static HistoryFragment newInstance() {
    HistoryFragment fragment = new HistoryFragment();
    return fragment;
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_history, null);
    TextView explanation = view.findViewById(R.id.history);
    history.setText(actionHistory.getActionHistory());

    return new AlertDialog.Builder(getActivity())
        .setIcon(R.drawable.ic_info_filled)
        .setTitle("History")
        .setView(view)
        .setPositiveButton(R.string.ok_button, (dialog, which) -> {})
        .create();
  }

}