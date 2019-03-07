package edu.cnm.deepdive.escaperoom.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import edu.cnm.deepdive.escaperoom.model.entity.User;

@Dao
public interface UserDao {
  @Query("SELECT * FROM User WHERE user_id = :userId")
  User getUser(long userId);

  @Update
  void updateUser(User user);
}
