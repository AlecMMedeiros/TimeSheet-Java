package bcoder.securityApp.dto;

import bcoder.securityApp.model.ActivityModel;

import java.util.Set;

public class JobDTO {
  private Long id;
  private String title;
  private String description;
  private Long os;
  private Set<ActivityModel> activities;

  public JobDTO ( Long id, String title, String description, Long os, Set<ActivityModel> activities ) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.os = os;
    this.activities = activities;
  }

  public Long getId () {
    return id;
  }

  public void setId ( Long id ) {
    this.id = id;
  }

  public String getTitle () {
    return title;
  }

  public void setTitle ( String title ) {
    this.title = title;
  }

  public String getDescription () {
    return description;
  }

  public void setDescription ( String description ) {
    this.description = description;
  }

  public Long getOs () {
    return os;
  }

  public void setOs ( Long os ) {
    this.os = os;
  }

  public Set<ActivityModel> getActivities () {
    return activities;
  }

  public void setActivities ( Set<ActivityModel> activities ) {
    this.activities = activities;
  }
}
