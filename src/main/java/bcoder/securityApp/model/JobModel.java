package bcoder.securityApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Table(name = "jobs")
public class JobModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotNull
  @Column(nullable = false)
  private String title;
  @NotNull
  @Column(nullable = false)
  private String description;
  @NotNull
  @Column(length = 20, nullable = false)
  private  Integer os;
  @NotNull
  @Column(length = 20, nullable = false)
  private String status;
  @CreationTimestamp
  private LocalDateTime createdAt;
  @UpdateTimestamp
  private LocalDateTime updatedAt;
  @ManyToMany
  @JoinTable(
      name = "job_activities",
      joinColumns = @JoinColumn(name = "job_id"),
      inverseJoinColumns = @JoinColumn(name = "activity_id")
  )
  private Set<ActivityModel> activities;
  @ManyToMany
  @JoinTable(
      name = "user_jobs",
      joinColumns = @JoinColumn(name = "job_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id")
  )
  private Set<UserModel> users;

  public JobModel ( String title , String description , Integer os , String status , LocalDateTime createdAt , LocalDateTime updatedAt , Set < ActivityModel > activities , Set < UserModel > users ) {
    this.title = title;
    this.description = description;
    this.os = os;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.activities = activities;
    this.users = users;
  }

  public Set<UserModel> getUsers () {
    return users;
  }

  public void setUsers ( Set<UserModel> users ) {
    this.users = users;
  }


  public JobModel () {}

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

  public Set < ActivityModel > getActivities ( ) {
    return activities;
  }

  public void setActivities ( Set < ActivityModel > activities ) {
    this.activities = activities;
  }

  public String getDescription () {
    return description;
  }

  public void setDescription ( String description ) {
    this.description = description;
  }

  public Integer getOs () {
    return os;
  }

  public void setOs ( Integer os ) {
    this.os = os;
  }

  public String getStatus () {
    return status;
  }

  public void setStatus ( String status ) {
    this.status = status;
  }

  public LocalDateTime getCreatedAt () {
    return createdAt;
  }

  public void setCreatedAt ( LocalDateTime createdAt ) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt () {
    return updatedAt;
  }

  public void setUpdatedAt ( LocalDateTime updatedAt ) {
    this.updatedAt = updatedAt;
  }

  @Override
  public String toString () {
    return "JobModel{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", os=" + os +
        ", status='" + status + '\'' +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        '}';
  }
}
