package edu.cnm.deepdive.escaperoom;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import edu.cnm.deepdive.escaperoom.model.EscapeRoomDB;
import edu.cnm.deepdive.escaperoom.model.entity.Scenario;
import java.util.LinkedList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity implements OnClickListener {


  Button option1;
  Button option2;
  private ImageView imageView;
  private String resourceName;
  private Long currentScenarioId = 1L;
  private String scenarioTitle;
  private Long toScenarioIdOption1;
  private Long toScenarioIdOption2;
  private String option1Title;
  private String option2Title;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scrolling);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

  }

  private void loadScenario(long scenarioId) {
    //TODO create and invoke an async task to read and populate the UI





    Button button1 = findViewById(R.id.option1);

    //long scenarioId = 1;
    // Get scenario from DB.

    long toScenarioFirst = 2;
    long toScenarioSecond = 3;
    button1.setTag(toScenarioFirst);
    button1.setOnClickListener(this);
  }

  private class loadViewTask extends AsyncTask<Long, Void, Void> {

    List<edu.cnm.deepdive.escaperoom.model.entity.Button> buttons = new LinkedList<>();
    Scenario scenario;

    @Override
    protected  Void doInBackground(Long... scenarioId) {

      buttons = EscapeRoomDB.getInstance().getButtonsDao().getButtons(scenarioId[0]);
      scenario = EscapeRoomDB.getInstance().getScenarioDao().findAllByScenarioId(scenarioId[0]);
      return null;
    }

    @Override
    protected void onPostExecute(Void void1) {
      currentScenarioId = scenario.getScenarioID();
      resourceName = scenario.getResourceName();
      scenarioTitle = scenario.getTitle();
      imageView
          .setImageResource(ScrollingActivity
          .this.getResources()
          .getIdentifier(resourceName, "drawable", ScrollingActivity.this.getPackageName()));
      toScenarioIdOption1 = buttons.get(0).getToScenarioId();
      toScenarioIdOption2 = buttons.get(1).getToScenarioId();
      option1Title = buttons.get(0).getTitle();
      option2Title = buttons.get(1).getTitle();

    }

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
