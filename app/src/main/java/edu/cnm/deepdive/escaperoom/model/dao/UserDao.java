package edu.cnm.deepdive.escaperoom.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import edu.cnm.deepdive.escaperoom.model.entity.User;

/**
 * This interface is not currently being used. My plan was to add insert methods
 * so the the local database would store user data.
 *
 */
@Dao
public interface UserDao {

  /**
   * Selects and returns single {@link User} instance in the local database.
   *
   * @param userId {@link User}.
   * @return {@link User} instance in local database.
   */
  @Query("SELECT * FROM User WHERE user_id = :userId")
  User getUser(long userId);

  /**
   * Selects and updates {@link User} instance in the database.
   *
   * @param user {@link User}.
   */
  @Update
  void updateUser(User user);
}
