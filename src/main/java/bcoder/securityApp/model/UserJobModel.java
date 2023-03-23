package bcoder.securityApp.model;

import bcoder.securityApp.dto.UserJobId;
import jakarta.persistence.*;

@Entity
@Table(name = "user_jobs")
public class UserJobModel {
  @EmbeddedId
  private UserJobId id;
  @ManyToOne
  @MapsId("userId")
  @JoinColumn(name = "user_id", nullable = false)
  private UserModel user;
  @ManyToOne
  @MapsId("jobId")
  @JoinColumn(name = "job_id", nullable = false)
  private JobModel job;
  public UserJobModel() {
  }
  public UserJobModel(UserModel user, JobModel job) {
    this.user = user;
    this.job = job;
    this.id = new UserJobId(user.getId(), job.getId());
  }

  public UserJobId getId() {
    return id;
  }

  public void setId(UserJobId id) {
    this.id = id;
  }

  public UserModel getUser() {
    return user;
  }

  public void setUser(UserModel user) {
    this.user = user;
  }

  public JobModel getJob() {
    return job;
  }

  public void setJob(JobModel job) {
    this.job = job;
  }
}
