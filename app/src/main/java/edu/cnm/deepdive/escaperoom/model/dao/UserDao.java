package edu.cnm.deepdive.escaperoom.model.dao;

import android.arch.persistence.room.Query;
import edu.cnm.deepdive.escaperoom.model.entity.Buttons;

public interface UserDao {
  @Query("SELECT * FROM User WHERE user_id = :userId")
  Buttons getUser(long userId);
}
