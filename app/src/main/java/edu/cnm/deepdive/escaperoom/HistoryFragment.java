package edu.cnm.deepdive.escaperoom;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import edu.cnm.deepdive.escaperoom.model.entity.ActionHistory;
import java.util.ArrayList;

/**
 * Hosts a {@link ListView} of {@link ActionHistory} instances from the local database, allowing user
 * to list a view of the {@link ActionHistory}. Currently, the list shows dummy items. I did not have enough time to
 * implement the insert of scenarios into the {@link ActionHistory} table.
 */
public class HistoryFragment extends DialogFragment {

  private ListView historyList;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //TODO get the id of the user
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_history, null);
    historyList = view.findViewById(R.id.history_list);
    ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.dummy_history));
    historyList.setAdapter(adapter);
    //TODO populate list from database
    return new AlertDialog.Builder(getActivity())
        .setTitle("Scenario History")
        .setView(view)
        .setPositiveButton("OK", (dialog, which) -> {})
        .create();
  }

}