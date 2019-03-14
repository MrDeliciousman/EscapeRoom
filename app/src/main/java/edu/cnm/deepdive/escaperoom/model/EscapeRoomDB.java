package edu.cnm.deepdive.escaperoom.model;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import edu.cnm.deepdive.android.BaseFluentAsyncTask;
import edu.cnm.deepdive.escaperoom.EscapeRoomApplication;
import edu.cnm.deepdive.escaperoom.R;
import edu.cnm.deepdive.escaperoom.model.dao.ActionHistoryDao;
import edu.cnm.deepdive.escaperoom.model.dao.ButtonsDao;
import edu.cnm.deepdive.escaperoom.model.dao.ScenarioDao;
import edu.cnm.deepdive.escaperoom.model.dao.UserDao;
import edu.cnm.deepdive.escaperoom.model.entity.ActionHistory;
import edu.cnm.deepdive.escaperoom.model.entity.Buttons;
import edu.cnm.deepdive.escaperoom.model.entity.Scenario;
import edu.cnm.deepdive.escaperoom.model.entity.User;
import java.io.BufferedReader;
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
    entities = {ActionHistory.class, Buttons.class, Scenario.class, User.class},
    version = 1,
    exportSchema = true
)
public abstract class EscapeRoomDB extends RoomDatabase {

  private static final String DB_NAME = "escape_room_db";

  public static EscapeRoomDB getInstance() {return InstanceHolder.INSTANCE;}

  public abstract ActionHistoryDao getActionHistoryDao();

  public abstract ButtonsDao getButtonsDao();

  public abstract ScenarioDao getScenarioDao();

  public abstract UserDao getUserDao();

  private static class InstanceHolder {

    private static final EscapeRoomDB INSTANCE = Room.databaseBuilder(
        EscapeRoomApplication.getInstance().getApplicationContext(),
        EscapeRoomDB.class, DB_NAME)
        .addCallback(new Callback())
        .build();
  }
  private static class Callback extends RoomDatabase.Callback {

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
      super.onCreate(db);
      //TODO create PreloadTask class for use here.
    }

    @Override
    public void onOpen(@NonNull SupportSQLiteDatabase db) {
      super.onOpen(db);
      //TODO Get AFluentAsyncTask to work.
    }
  }

  private static class PreloadTask
  extends BaseFluentAsyncTask<Void, Void, Void, Void> {

    @Nullable
    @Override
    protected void perform(Void... voids) throws TaskException {
      Context context = EscapeRoomApplication.getInstance().getApplicationContext();
      EscapeRoomDB database = EscapeRoomDB.getInstance();
      try (
          InputStream input = context.getResources().openRawResource(R.raw.scenarios);
          Reader reader = new InputStreamReader(input);
          CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
          ) {
        List<Scenario> scenarios = new LinkedList<>();
          for (CSVRecord record : parser) {
            Scenario scenario = new Scenario();
            scenario.setTitle(record.get(0));
            String resourcename = record.get(1);
            long sourceId = database.getScenarioDao().insert(scenario);
            scenarios.addAll(loadScenarios(sourceId, resourcename));
          }
          database.getScenarioDao().insert(scenarios);
      } catch (IOException e) {
        throw new TaskException(e);
      }
    }

    private List<Scenario> loadScenarios(long scenarioId, String resourceName) {
      Context context = EscapeRoomApplication.getInstance().getApplicationContext();
      int resourceId =
          context.getResources().getIdentifier(resourceName, "raw", context.getPackageName());
      try (
          InputStream input = context.getResources().openRawResource(resourceId);
          Reader reader = new InputStreamReader(input);
          BufferedReader buffer = new BufferedReader(reader);
          ) {
          List<Scenario> scenarios = new LinkedList<>();
          String line;
          while ((line = buffer.readLine()) != null) {
            if (!(line = line.trim()).isEmpty()) {
              Scenario scenario = new Scenario();
              scenario.setScenarioID(scenarioId);
              scenario.setTitle(line);
              scenario.add(scenario);
            }
          }
          return scenarios;
      } catch (IOException e) {
        throw new TaskException(e);
      }
    }
  }
}
