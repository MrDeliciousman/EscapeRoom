package edu.cnm.deepdive.escaperoom.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import edu.cnm.deepdive.escaperoom.model.entity.ActionHistory;
import edu.cnm.deepdive.escaperoom.model.entity.User;

/**
 * This interface is currently not being used. My intention was
 * to store and list the scenario titles to the local database.
 *
 */
@Dao
public interface ActionHistoryDao {

  /**
   * Selects and returns the single {@link ActionHistory} instance
   * from the local database
   *
   * @return {@link ActionHistory} instance.
   */
  @Query("SELECT * FROM ActionHistory")
  ActionHistory getActionHistory(User user);

  /**
   * Inserts one {@link ActionHistory} instance int the local database.
   *
   * @param actionHistory {@link ActionHistory} scenario.
   * @return {@link ActionHistory} Id(s).
   */
  @Insert
  long insert(ActionHistory actionHistory);
}
