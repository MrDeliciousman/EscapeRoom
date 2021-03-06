package edu.cnm.deepdive.escaperoom.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * This Table is not currently being used. It was intended to store the users actions
 * and scenarios that they have done in the past. I did not have enough time to implement them this
 * sprint.
 */
@Entity(
    foreignKeys = {@ForeignKey
        (entity = User.class, parentColumns = "user_id", childColumns = "user_id"),
        @ForeignKey
        (entity = Scenario.class, parentColumns = "scenario_id", childColumns = "scenario_id"),
        @ForeignKey
        (entity = Button.class, parentColumns = "buttons_id", childColumns = "buttons_id")
    }, indices = {
        @Index("action_history"), @Index("user_id"), @Index("scenario_id"), @Index("buttons_id"), @Index("buttons_title")}
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
