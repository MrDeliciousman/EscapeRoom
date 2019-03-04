package edu.cnm.deepdive.escaperoom.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(
    foreignKeys = {
        @ForeignKey(
        entity = Scenario.class, parentColumns = "id", childColumns = "from_scenario_id"),
        @ForeignKey(
        entity = Scenario.class, parentColumns = "id", childColumns = "to_scenario_id")
    }
)
public class Buttons {

  @PrimaryKey
  private long id;
  @ColumnInfo(name = "from_scenario_id")
  private long fromScenarioId;
  @ColumnInfo(name = "to_scenario_id")
  private long toScenarioId;
  @ColumnInfo(name = "buttons_title")
  private String buttonsTitle;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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
