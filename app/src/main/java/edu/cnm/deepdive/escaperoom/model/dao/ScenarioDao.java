package edu.cnm.deepdive.escaperoom.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.escaperoom.model.entity.Scenario;

@Dao
public interface ScenarioDao {

  @Query("SELECT * FROM Scenario WHERE scenario_id = :scenarioId")
  Scenario getScenario(long scenarioId);

}
