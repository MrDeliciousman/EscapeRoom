package edu.cnm.deepdive.escaperoom;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
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
import edu.cnm.deepdive.escaperoom.service.EscapeRoomWebService.GetWeatherTask;
import java.util.LinkedList;
import java.util.List;

/**
 * Primary controller class of the NASA APOD client app. This activity configures and then responds
 * to clicks in a {@link android.support.design.widget.AppBarLayout} to hide and show one{@link
 * HistoryFragment} instance. It also responds to clicks on two buttons {@link
 * Button} (the button press loads the next image view, button titles and Title dispaly).
 */


public class ScrollingActivity extends AppCompatActivity implements OnClickListener {

  CollapsingToolbarLayout toolbarLayout;
  private Button option1;
  private Button option2;
  private ImageView imageView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scrolling);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    toolbarLayout = findViewById(R.id.toolbar_layout);
    imageView = findViewById(R.id.content_image);
    option1 = findViewById(R.id.option1);
    option2 = findViewById(R.id.option2);
    option1.setOnClickListener(this);
    option2.setOnClickListener(this);
    loadScenario(1);
  }

  private void loadScenario(long scenarioId) {
    new LoadViewTask().execute(scenarioId);

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

  /**
   * This method holds the {@link Scenario} id using a tag. Depending on the button
   * being pressed the button passes the id off to load the next {@link Scenario}. At
   * certain junction points in the story, a call is made to the {@link edu.cnm.deepdive.escaperoom.model.Weather}
   * APi. Depending on the temperature returned, a different {@link Scenario} is presented.
   *
   * @param v {@link View}.
   */
  @Override
  public void onClick(View v) {
    Long toId = (Long) v.getTag();
    if (toId != null) {
      loadScenario(toId);
    } else {
      new GetWeatherTask()
          .setSuccessListener((weather) -> {
            float temperature = weather.getMain().getTemperature();
            long dynamicScenario;
              if (temperature < 284) {
                dynamicScenario = 8;
              } else {
                dynamicScenario = 12;
              }

            loadScenario(dynamicScenario);
          })
          .setFailureListener((ignore) -> {
            //TODO handle a service call failure
          })
          .execute("albuquerque");
    }
  }

  /**
   * This class calls to the local database to get the information for buttons
   * and image view. It does this in the background and uses an async task to load
   * everything at the same time.
   *
   */
  private class LoadViewTask extends AsyncTask<Long, Void, Void> {

    private List<edu.cnm.deepdive.escaperoom.model.entity.Button> buttons = new LinkedList<>();
    private Scenario scenario;

    @Override
    protected Void doInBackground(Long... scenarioId) {

      buttons = EscapeRoomDB.getInstance().getButtonsDao().getButtons(scenarioId[0]);
      scenario = EscapeRoomDB.getInstance().getScenarioDao().findAllByScenarioId(scenarioId[0]);
      return null;
    }

    @Override
    protected void onPostExecute(Void void1) {
      String resourceName = scenario.getResourceName().trim();
      toolbarLayout.setTitle(scenario.getTitle().trim());
      int imageId = getResources().getIdentifier(resourceName, "drawable", getPackageName());
      Drawable image = getDrawable(imageId);
      imageView.setImageDrawable(image);
      option1.setText(buttons.get(0).getTitle());
      option2.setText(buttons.get(1).getTitle());
      option1.setTag(buttons.get(0).getToScenarioId());
      option2.setTag(buttons.get(1).getToScenarioId());
    }

  }

}
