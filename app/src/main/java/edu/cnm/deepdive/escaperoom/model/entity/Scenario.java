package edu.cnm.deepdive.escaperoom.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(indices = {
    @Index("scenario_id"), @Index("title"), @Index("resource_name")})
public class Scenario {

  @PrimaryKey
  @ColumnInfo(name = "scenario_id")
  private long scenarioID;

  @NonNull
  @ColumnInfo
  private String title;

  @ColumnInfo(name = "resource_name")
  private String resourceName;


  public long getScenarioID() {
    return scenarioID;
  }

  public void setScenarioID(long scenarioID) {
    this.scenarioID = scenarioID;
  }

  @NonNull
  public String getTitle() {
    return title;
  }

  public void setTitle(@NonNull String title) {
    this.title = title;
  }

  public String getResourceName() {
    return resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }


}
