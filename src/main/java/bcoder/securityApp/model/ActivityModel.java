package bcoder.securityApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table(name = "activities")
public class ActivityModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotNull
  @Column(nullable = false)
  private String activity;
  @NotNull
  @Column(nullable = false)
  private String comment;


  public ActivityModel ( String activity, String comment, Set<ActivityModel> activities ) {
    this.activity = activity;
    this.comment = comment;
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


  public String getComment () {
    return comment;
  }

  public void setComment ( String comment ) {
    this.comment = comment;
  }


  @Override
  public String toString () {
    return "ActivityModel{" +
        "id=" + id +
        ", activity='" + activity + '\'' +
        ", comment='" + comment + '\'' +
        '}';
  }
}
