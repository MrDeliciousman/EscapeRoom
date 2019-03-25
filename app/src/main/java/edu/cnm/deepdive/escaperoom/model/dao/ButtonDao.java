package edu.cnm.deepdive.escaperoom.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.escaperoom.model.entity.Button;
import java.util.List;

@Dao
public interface ButtonDao {

  @Insert
  long insert(Button button);

  @Insert
  List<Long> insert(Button... buttons);

  @Insert
  List<Long> insert(List<Button> buttons);


  @Query("SELECT * FROM Button WHERE from_scenario_id = :fromScenarioId")
  List<Button> getButtons(long fromScenarioId);

}
