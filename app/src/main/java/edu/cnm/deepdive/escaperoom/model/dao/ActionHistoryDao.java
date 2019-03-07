package edu.cnm.deepdive.escaperoom.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import edu.cnm.deepdive.escaperoom.model.entity.ActionHistory;

@Dao
public interface ActionHistoryDao {

  @Query("SELECT * FROM ActionHistory")
  ActionHistory getActionHistory();

  @Insert
  long insert(ActionHistory actionHistory);
}
