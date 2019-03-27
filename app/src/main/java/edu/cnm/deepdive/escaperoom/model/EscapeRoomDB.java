package edu.cnm.deepdive.escaperoom.model;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import edu.cnm.deepdive.android.BaseFluentAsyncTask;
import edu.cnm.deepdive.android.BaseFluentAsyncTask.ResultListener;
import edu.cnm.deepdive.escaperoom.EscapeRoomApplication;
import edu.cnm.deepdive.escaperoom.R;
import edu.cnm.deepdive.escaperoom.model.dao.ActionHistoryDao;
import edu.cnm.deepdive.escaperoom.model.dao.ButtonDao;
import edu.cnm.deepdive.escaperoom.model.dao.ScenarioDao;
import edu.cnm.deepdive.escaperoom.model.dao.UserDao;
import edu.cnm.deepdive.escaperoom.model.entity.ActionHistory;
import edu.cnm.deepdive.escaperoom.model.entity.Button;
import edu.cnm.deepdive.escaperoom.model.entity.Scenario;
import edu.cnm.deepdive.escaperoom.model.entity.User;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


@Database(
    entities = {ActionHistory.class, Button.class, Scenario.class, User.class},
    version = 1,
    exportSchema = true
)
public abstract class EscapeRoomDB extends RoomDatabase {

  private static final String DB_NAME = "escape_room_db";

  public static EscapeRoomDB getInstance() {return InstanceHolder.INSTANCE;}

  public abstract ActionHistoryDao getActionHistoryDao();

  public abstract ButtonDao getButtonsDao();

  public abstract ScenarioDao getScenarioDao();

  public abstract UserDao getUserDao();

  private static class InstanceHolder {

    private static final EscapeRoomDB INSTANCE = Room.databaseBuilder(
        EscapeRoomApplication.getInstance().getApplicationContext(),
        EscapeRoomDB.class, DB_NAME)
        .addCallback(new Callback())
        .build();
  }

  /**
   * This class builds the database by using the @onOpen method to
   * find a list of scenarios that returns void so that the @preLoadTask can
   * populate the database.
   */
  private static class Callback extends RoomDatabase.Callback {

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
      super.onCreate(db);
      new PreloadTask().start();
    }

    @Override
    public void onOpen(@NonNull SupportSQLiteDatabase db) {
      super.onOpen(db);
      EscapeRoomDB database =  EscapeRoomDB.getInstance();
      new BaseFluentAsyncTask<Void, Void, List<Scenario>, List<Scenario>>()
        .setPerformer((ignore) -> database.getScenarioDao().findAll())
          .setSuccessListener(new ResultListener<List<Scenario>>() {
            @Override
            public void handle(List<Scenario> scenarios) {

            }
          })
          .execute();
    }
  }

  /**
   *On Run this class will preload the database with the Scenario Table
   * and Buttons Table. It invokes the CSV Parser to read the csv file @res/raw
   * and then populates the tables with those values.
   */

  private static class PreloadTask
  extends Thread {

    @Nullable
    @Override
    public void run() {
      Context context = EscapeRoomApplication.getInstance().getApplicationContext();
      EscapeRoomDB database = EscapeRoomDB.getInstance();
      loadScenarios(context, database);
      loadButtons(context, database);
    }

    /**
     * This method preloads the Scenario Table on Run.
     * 
     * @param context
     * @param database
     */
    private void loadScenarios(Context context, EscapeRoomDB database) {
       try (
          InputStream input = context.getResources().openRawResource(R.raw.scenario);
          Reader reader = new InputStreamReader(input);
          CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
       ) {
          List<Scenario> scenarios = new LinkedList<>();
         for (CSVRecord record : parser) {
           Scenario scenario = new Scenario();
           scenario.setScenarioID(Long.parseLong(record.get(0)));
           scenario.setTitle(record.get(1));
           scenario.setResourceName(record.get(2));
           scenarios.add(scenario);
         }
         database.getScenarioDao().insert(scenarios);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    /**
     * This method preloads the Buttons Table on Run.
     *
     * @param context
     * @param database
     */
    private void loadButtons(Context context, EscapeRoomDB database) {
      try (
          InputStream input = context.getResources().openRawResource(R.raw.buttons);
          Reader reader = new InputStreamReader(input);
          CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
      ) {
        List<Button> buttons = new LinkedList<>();
        for (CSVRecord record : parser) {
          Button button = new Button();
          button.setFromScenarioId(Long.parseLong(record.get(0)));
          button.setTitle(record.get(1));
          String rawScenarioId = record.get(2).trim();

          if (!rawScenarioId.isEmpty()) {
            button.setToScenarioId(Long.parseLong(rawScenarioId));
          }
          buttons.add(button);
        }
        database.getButtonsDao().insert(buttons);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
