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


  /**
   * Returns the scenario id of this instance.
   *
   * @return scenarioId.
   */
  public long getScenarioID() {
    return scenarioID;
  }

  /**
   * Sets the scenario Id  of this instance. This method is invoked by Room when
   * loading the instance from the database.
   *
   * @param scenarioID long scenarioId.
   */

  public void setScenarioID(long scenarioID) {
    this.scenarioID = scenarioID;
  }

  /**
   * Returns the title of this instance.
   *
   * @return title.
   */
  @NonNull
  public String getTitle() {
    return title;
  }

  /**
   * Sets the title  of this instance. This method is invoked by Room when
   * loading the instance from the database.
   *
   * @param title String title.
   */

  public void setTitle(@NonNull String title) {
    this.title = title;
  }

  /**
   * Returns the resource name of this instance.
   *
   * @return resourceName.
   */

  public String getResourceName() {
    return resourceName;
  }

  /**
   * Sets the resource name of this instance. This method is invoked by Room when
   * loading the instance from the database.
   *
   * @param resourceName String resourceName.
   */
  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }


}
