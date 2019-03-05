package edu.cnm.deepdive.escaperoom.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(
    foreignKeys = {@ForeignKey
        (entity = User.class, parentColumns = "user_id", childColumns = "user_id"),
        @ForeignKey
        (entity = Scenario.class, parentColumns = "scenario_id", childColumns = "scenario_id"),
        @ForeignKey
        (entity = Buttons.class, parentColumns = "buttons_id", childColumns = "buttons_id")
    }
)
public class ActionHistory {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "action_history")
  private long actionHistory;
  @ColumnInfo(name = "user_id")
  private long userId;
  @ColumnInfo(name = "scenario_id")
  private long scenarioId;
  @ColumnInfo(name = "buttons_id")
  private long buttonsId;
  @ColumnInfo(name = "buttons_title")
  private String buttonsTitle;

  public long getActionHistory() {
    return actionHistory;
  }

  public void setActionHistory(long actionHistory) {
    this.actionHistory = actionHistory;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public long getScenarioId() {
    return scenarioId;
  }

  public void setScenarioId(long scenarioId) {
    this.scenarioId = scenarioId;
  }

  public long getButtonsId() {
    return buttonsId;
  }

  public void setButtonsId(long buttonsId) {
    this.buttonsId = buttonsId;
  }

  public String getButtonsTitle() {
    return buttonsTitle;
  }

  public void setButtonsTitle(String buttonsTitle) {
    this.buttonsTitle = buttonsTitle;
  }
}
