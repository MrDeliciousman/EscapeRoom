package edu.cnm.deepdive.escaperoom.model.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class User {

  @PrimaryKey
  private int id;
  @ColumnInfo
  private String name;

}
