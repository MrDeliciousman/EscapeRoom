package edu.cnm.deepdive.escaperoom.model;

import android.support.annotation.NonNull;
import java.io.Serializable;

public class Weather implements Serializable {

  private static final long SerialVersionUID = 2547946263420122184L;

  @NonNull
  private String temp;

  @NonNull
  public String getTemp() { return temp;}
}
