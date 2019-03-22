package edu.cnm.deepdive.escaperoom.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.support.annotation.NonNull;
import edu.cnm.deepdive.escaperoom.model.entity.Scenario;
import java.util.List;

@Dao
public interface ScenarioDao {

  @Insert
  List<Long> insert(Scenario... scenarios);

  @Insert
  long insert(Scenario scenario);

  @Insert
  List<Long> insert(List<Scenario> scenarios);

  @Query("SELECT * FROM Scenario ORDER BY scenario_id ASC")
  List<Scenario> findAll();

  @Query("SELECT * FROM Scenario WHERE scenario_id = :scenarioId")
  Scenario findAllByScenarioId(long scenarioId);

  @Query("SELECT * FROM Scenario WHERE scenario_id = :title")
  Scenario findAllByTitle(String title);

}
