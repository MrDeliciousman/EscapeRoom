package edu.cnm.deepdive.escaperoom.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(
    foreignKeys = {
        @ForeignKey(
        entity = Scenario.class, parentColumns = "scenario_id", childColumns = "from_scenario_id"),
        @ForeignKey(
        entity = Scenario.class, parentColumns = "scenario_id", childColumns = "to_scenario_id")
    }
)
public class Button {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "buttons_id")
  private long buttonsId;
  @ColumnInfo(name = "from_scenario_id", index = true)
  private long fromScenarioId;
  @ColumnInfo(name = "to_scenario_id", index = true)
  private Long toScenarioId;
  private String title;

  /**
   * Returns the buttons id of this instance.
   *
   * @return buttonsId.
   */
  public long getButtonsId() {
    return buttonsId;
  }


  /**
   * Sets the frp, scenario Id  of this instance. This method is invoked by Room when
   * loading the instance from the database.
   *
   * @param buttonsId long buttonsId.
   */
  public void setButtonsId(long buttonsId) {
    this.buttonsId = buttonsId;
  }

  /**
   * Returns the from scenario id of this instance.
   *
   * @return fromscenarioId.
   */

  public long getFromScenarioId() {
    return fromScenarioId;
  }

  /**
   * Sets the frp, scenario Id  of this instance. This method is invoked by Room when
   * loading the instance from the database.
   *
   * @param fromScenarioId long fromScenarioId.
   */

  public void setFromScenarioId(long fromScenarioId) {
    this.fromScenarioId = fromScenarioId;
  }

  /**
   * Returns the get to scenario id of this instance.
   *
   * @return getToscenarioId.
   */

  public Long getToScenarioId() {
    return toScenarioId;
  }


  /**
   * Sets the to scenario Id  of this instance. This method is invoked by Room when
   * loading the instance from the database.
   *
   * @param toScenarioId Long toScenarioId.
   */
  public void setToScenarioId(Long toScenarioId) {
    this.toScenarioId = toScenarioId;
  }

  /**
   * Returns the title of this instance.
   *
   * @return title.
   */

  public String getTitle() {
    return title;
  }

  /**
   * Sets the title  of this instance. This method is invoked by Room when
   * loading the instance from the database.
   *
   * @param title String title.
   */

  public void setTitle(String title) {
    this.title = title;
  }
}
