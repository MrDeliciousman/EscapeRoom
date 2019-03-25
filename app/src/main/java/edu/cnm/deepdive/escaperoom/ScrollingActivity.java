package edu.cnm.deepdive.escaperoom;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import edu.cnm.deepdive.escaperoom.model.EscapeRoomDB;

public class ScrollingActivity extends AppCompatActivity implements OnClickListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scrolling);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

  }

  private void loadScenario() {
    Button button1 = findViewById(R.id.option1);

    long scenarioId = 1;
    // Get scenario from DB.

    long toScenarioFirst = 2;
    long toScenarioSecond = 3;
    button1.setTag(toScenarioFirst);
    button1.setOnClickListener(this);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_scrolling, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    } else if (id == R.id.history) {
      HistoryFragment hf = new HistoryFragment();
      hf.show(getSupportFragmentManager(), hf.getClass().getSimpleName());
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onClick(View v) {
    Long toId = (Long) v.getTag();
    switch (v.getId()) {
      case R.id.option1:
        // Go to scenario for toId;
        break;
    }
  }
}
