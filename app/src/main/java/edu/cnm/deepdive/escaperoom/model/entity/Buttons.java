package edu.cnm.deepdive.escaperoom.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(
    foreignKeys = {
        @ForeignKey(
        entity = Scenario.class, parentColumns = "scenario_id", childColumns = "from_scenario_id"),
        @ForeignKey(
        entity = Scenario.class, parentColumns = "scenario_id", childColumns = "to_scenario_id")
    }
)
public class Buttons {

  @PrimaryKey(autoGenerate = true)
  private long buttonsId;
  @ColumnInfo(name = "from_scenario_id")
  private long fromScenarioId;
  @ColumnInfo(name = "to_scenario_id")
  private long toScenarioId;
  @ColumnInfo(name = "buttons_title")
  private String buttonsTitle;

  public long getButtonsId() {
    return buttonsId;
  }

  public void setButtonsId(long buttonsId) {
    this.buttonsId = buttonsId;
  }

  public long getFromScenarioId() {
    return fromScenarioId;
  }

  public void setFromScenarioId(long fromScenarioId) {
    this.fromScenarioId = fromScenarioId;
  }

  public long getToScenarioId() {
    return toScenarioId;
  }

  public void setToScenarioId(long toScenarioId) {
    this.toScenarioId = toScenarioId;
  }

  public String getButtonsTitle() {
    return buttonsTitle;
  }

  public void setButtonsTitle(String buttonsTitle) {
    this.buttonsTitle = buttonsTitle;
  }
}
