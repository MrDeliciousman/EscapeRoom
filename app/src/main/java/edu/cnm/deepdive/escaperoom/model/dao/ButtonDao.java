package edu.cnm.deepdive.escaperoom.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.escaperoom.model.entity.Button;
import java.util.List;

@Dao
public interface ButtonDao {

  /**
   * Inserts one {@link Button} instance into the local
   * database
   *
   * @param button {@link Button} instance to be inserted.
   * @return inserted Button Id(s).
   */
  @Insert
  long insert(Button button);


  /**
   * Inserts one or more {@link Button} instance into the local
   * database
   * @param buttons {@link Button} instance(s) to be inserted.
   * @return inserted Button or buttons.
   */
  @Insert
  List<Long> insert(List<Button> buttons);

  /**
   * Selects and returns all {@link Button} instances in the local
   * database.
   *
   * @param fromScenarioId desired {@link Button}.
   * @return all {@link Button} instances in local database.
   */
  @Query("SELECT * FROM Button WHERE from_scenario_id = :fromScenarioId")
  List<Button> getButtons(long fromScenarioId);

}
