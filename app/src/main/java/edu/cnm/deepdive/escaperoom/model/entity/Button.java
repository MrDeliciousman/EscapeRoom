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

  public Long getToScenarioId() {
    return toScenarioId;
  }

  public void setToScenarioId(Long toScenarioId) {
    this.toScenarioId = toScenarioId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
