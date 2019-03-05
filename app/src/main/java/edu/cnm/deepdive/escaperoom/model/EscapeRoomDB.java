package edu.cnm.deepdive.escaperoom.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import edu.cnm.deepdive.escaperoom.EscapeRoomApplication;
import edu.cnm.deepdive.escaperoom.model.dao.ActionHistoryDao;
import edu.cnm.deepdive.escaperoom.model.dao.ButtonsDao;
import edu.cnm.deepdive.escaperoom.model.dao.ScenarioDao;
import edu.cnm.deepdive.escaperoom.model.dao.UserDao;
import edu.cnm.deepdive.escaperoom.model.entity.ActionHistory;
import edu.cnm.deepdive.escaperoom.model.entity.Buttons;
import edu.cnm.deepdive.escaperoom.model.entity.Scenario;
import edu.cnm.deepdive.escaperoom.model.entity.User;


@Database(
    entities = {ActionHistory.class, Buttons.class, Scenario.class, User.class},
    version = 1,
    exportSchema = true
)
public abstract class EscapeRoomDB extends RoomDatabase {

  private static final String DB_NAME = "escape_room_db";

  public abstract ActionHistoryDao getActionHistoryDao();

  public abstract ButtonsDao getButtonsDao();

  public abstract ScenarioDao getScenarioDao();

  public abstract UserDao getUserDao();

  private static class InstanceHolder {

    private static final EscapeRoomDB INSTANCE = Room.databaseBuilder(
        EscapeRoomApplication.getInstance().getInstance().getApplicationContext(), EscapeRoomDB.class, DB_NAME)
        .build();
  }

}
