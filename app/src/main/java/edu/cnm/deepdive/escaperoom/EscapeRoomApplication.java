package edu.cnm.deepdive.escaperoom;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class EscapeRoomApplication extends Application {

  private static EscapeRoomApplication instance = null;

  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;
    Stetho.initializeWithDefaults(this);
  }

  public static EscapeRoomApplication getInstance(){return instance; }

}
