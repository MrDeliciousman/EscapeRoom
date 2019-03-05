package edu.cnm.deepdive.escaperoom.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.escaperoom.model.entity.Buttons;

@Dao
public interface ButtonsDao {

  @Query("SELECT * FROM Buttons WHERE from_scenario_id = :fromScenarioId")
  Buttons getButtons(long fromScenarioId);

}
