package edu.cnm.deepdive.escaperoom.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Encapsulates the attributes of a single Main object which is necessary to obtain the current
 * temperature in Albuquerque, New Mexico.
 * Room and GSon annotations are used to specify entity &amp; attribute mapping for database persistence, and
 * property mapping for JSON serialization/deserialization mapping.
 */

public class Weather {

  @Expose
  private Main main;

  /**
   *  Returns the main object of this instance.
   *
   * @return main of Weather.
   */
  public Main getMain() {
    return main;
  }
  /**
   * Sets the main of this instance. This method is invoked by Room and GSon after loading
   * from the database and JSON deserialization, respectively.
   *
   * @param main Weather main.
   */

  public void setMain(Main main) {
    this.main = main;
  }

  /**
   * Encapsulates the attributes of a single temperature
   * Room and GSon annotations are used to specify entity &amp; attribute mapping for database persistence, and
   * property mapping for JSON serialization/deserialization mapping.
   */

  public static class Main {

    @Expose
    @SerializedName("temp")
    private float temperature;

    /**
     *  Returns the temperature of this instance.
     *
     * @return temperature of Main.
     */
    public float getTemperature() {
      return temperature;
    }

    /**
     * Sets the temperature of this instance. This method is invoked by Room and GSon after loading
     * from the database and JSON deserialization, respectively.
     *
     * @param temperature Main temperature.
     */

    public void setTemperature(float temperature) {
      this.temperature = temperature;
    }
  }
}
