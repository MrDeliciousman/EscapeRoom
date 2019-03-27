package edu.cnm.deepdive.escaperoom.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.escaperoom.model.entity.Scenario;
import java.util.List;

@Dao
public interface ScenarioDao {

  /**
   * Inserts one or more {@link Scenario} instances into the local
   * database.
   *
   * @param scenarios {@link Scenario} instance(s) to be inserted.
   * @return inserted scenario ID(s).
   */
  @Insert
  List<Long> insert(List<Scenario> scenarios);

  /**
   * Selects and returns the {@link Scenario} instances in the
   * local database.
   *
   * @return list of {@link Scenario} instances in the local database.
   */
  @Query("SELECT * FROM Scenario ORDER BY scenario_id ASC")
  List<Scenario> findAll();

  /**
   * Selects and returns one {@link Scenario} instance in the
   * local database.
   *
   * @return one {@link Scenario} instance in local database.
   */
  @Query("SELECT * FROM Scenario WHERE scenario_id = :scenarioId")
  Scenario findAllByScenarioId(long scenarioId);

}
