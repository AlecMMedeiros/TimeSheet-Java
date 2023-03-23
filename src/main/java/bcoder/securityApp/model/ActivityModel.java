package bcoder.securityApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "activities")
public class ActivityModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotNull
  @Column(length = 255, nullable = false)
  private String activity;
  @NotNull
  @Column(length = 20, nullable = false)
  private LocalTime hours;
  @NotNull
  @Column(nullable = false)
  private String comment;
  @NotNull
  @Column(nullable = false)
  private Date date;
  @ManyToMany
  @JoinTable(
      name = "user_activities",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "activity_id")
  )
  private Set<ActivityModel> activities;

  public ActivityModel ( String activity, LocalTime hours, String comment, Date date, Set<ActivityModel> activities ) {
    this.activity = activity;
    this.hours = hours;
    this.comment = comment;
    this.date = date;
    this.activities = activities;
  }

  public ActivityModel () {

  }

  public Long getId () {
    return id;
  }

  public void setId ( Long id ) {
    this.id = id;
  }

  public String getActivity () {
    return activity;
  }

  public void setActivity ( String activity ) {
    this.activity = activity;
  }

  public LocalTime getHours () {
    return hours;
  }

  public void setHours ( LocalTime hours ) {
    this.hours = hours;
  }

  public String getComment () {
    return comment;
  }

  public void setComment ( String comment ) {
    this.comment = comment;
  }

  public Date getDate () {
    return date;
  }

  public void setDate ( Date date ) {
    this.date = date;
  }

  public Set<ActivityModel> getActivities () {
    return activities;
  }

  public void setActivities ( Set<ActivityModel> activities ) {
    this.activities = activities;
  }

  @Override
  public String toString () {
    return "ActivityModel{" +
        "id=" + id +
        ", activity='" + activity + '\'' +
        ", hours=" + hours +
        ", comment='" + comment + '\'' +
        ", date=" + date +
        ", activities=" + activities +
        '}';
  }
}
