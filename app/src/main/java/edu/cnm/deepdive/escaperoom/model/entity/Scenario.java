package edu.cnm.deepdive.escaperoom.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Scenario {

  @PrimaryKey
  private long id;

  @NonNull
  @ColumnInfo
  private String title;

  @ColumnInfo(name = "media_picture")
  private String mediaPicture;

  @ColumnInfo(name = "accessible_text")
  private String accessibleText;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public String getTitle() {
    return title;
  }

  public void setTitle(@NonNull String title) {
    this.title = title;
  }

  public String getMediaPicture() {
    return mediaPicture;
  }

  public void setMediaPicture(String mediaPicture) {
    this.mediaPicture = mediaPicture;
  }

  public String getAccessibleText() {
    return accessibleText;
  }

  public void setAccessibleText(String accessibleText) {
    this.accessibleText = accessibleText;
  }
}
