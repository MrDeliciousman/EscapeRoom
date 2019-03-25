package edu.cnm.deepdive.escaperoom;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.escaperoom.model.EscapeRoomDB;

public class EscapeRoomApplication extends Application {

  private static EscapeRoomApplication instance = null;

  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;
    Stetho.initializeWithDefaults(this);
    new Thread() {
      @Override
      public void run() {
        EscapeRoomDB.getInstance().getScenarioDao().findAll();
      }
    }.start();
  }

  public static EscapeRoomApplication getInstance(){return instance; }

}
