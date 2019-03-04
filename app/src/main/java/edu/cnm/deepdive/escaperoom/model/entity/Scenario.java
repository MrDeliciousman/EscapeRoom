package edu.cnm.deepdive.escaperoom.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Scenario {

  @PrimaryKey
  private int id;

  @NonNull
  @ColumnInfo
  private String title;

  @ColumnInfo(name = "media_picture")
  private String mediaPicture;

  @ColumnInfo(name = "accessible_text")
  private String accessibleText;

}
