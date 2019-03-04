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
  private int id;
  @ColumnInfo(name = "from_scenario_id")
  private int fromScenarioId;
  @ColumnInfo(name = "to_scenario_id")
  private int toScenarioId;
  @ColumnInfo(name = "buttons_title")
  private String buttonsTitle;

}
