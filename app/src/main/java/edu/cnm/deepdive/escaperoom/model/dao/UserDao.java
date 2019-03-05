package edu.cnm.deepdive.escaperoom.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import edu.cnm.deepdive.escaperoom.model.entity.Buttons;
import edu.cnm.deepdive.escaperoom.model.entity.User;

@Dao
public interface UserDao {
  @Query("SELECT * FROM User WHERE user_id = :userId")
  Buttons getUser(long userId);

  @Update
  public void updateUser(String userId);
}
