package edu.cnm.deepdive.escaperoom.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Encapsulates attributes of a single Main from OpenWeatherAPI.GSon is
 * annotation is used to specify the information needed in the Scrolling Activity.
 * 
 */

public class Weather {

  @Expose
  private Main main;

  public Main getMain() {
    return main;
  }

  public void setMain(Main main) {
    this.main = main;
  }

  public static class Main {

    @Expose
    @SerializedName("temp")
    private float temperature;

    public float getTemperature() {
      return temperature;
    }

    public void setTemperature(float temperature) {
      this.temperature = temperature;
    }
  }
}
