package edu.cnm.deepdive.escaperoom.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(
    foreignKeys = {@ForeignKey
        (entity = User.class, parentColumns = "id", childColumns = "user_id"),
        @ForeignKey
        (entity = Scenario.class, parentColumns = "id", childColumns = "scenario_id"),
        @ForeignKey
        (entity = Buttons.class, parentColumns = "id", childColumns = "buttons_id")
    }
)
public class ActionHistory {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "action_history")
  private int actionHistory;
  @ColumnInfo(name = "user_id")
  private int userId;
  @ColumnInfo(name = "scenario_id")
  private int scenarioId;
  @ColumnInfo(name = "buttons_id")
  private int buttonsId;
}
