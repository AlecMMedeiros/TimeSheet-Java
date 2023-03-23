package bcoder.securityApp.dto;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;



@Embeddable
public class UserJobId implements Serializable {

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "job_id")
  private Long jobId;

  public UserJobId() {
  }

  public UserJobId(Long userId, Long jobId) {
    this.userId = userId;
    this.jobId = jobId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getJobId() {
    return jobId;
  }

  public void setJobId(Long jobId) {
    this.jobId = jobId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserJobId that = (UserJobId) o;
    return Objects.equals(userId, that.userId) && Objects.equals(jobId, that.jobId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, jobId);
  }
}
