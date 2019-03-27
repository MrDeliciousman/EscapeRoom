package edu.cnm.deepdive.escaperoom;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.escaperoom.model.EscapeRoomDB;


/**
 * Extends {@link Application}, in order to initialize <a href="http://facebook.github.io/stetho/">Stetho</a>
 * inspection and set up access to this instance via the singleton pattern. At runtime, any instance
 * of an {@link Application} subclass is a de facto singleton; the common {@link #getInstance()}
 * implementation is used here to enable access to the singleton by other classes in the app.
 */
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

  /**
   * Returns this instance, for access to application context across the app.
   *
   * @return singleton instance.
   */
  public static EscapeRoomApplication getInstance(){return instance; }

}
