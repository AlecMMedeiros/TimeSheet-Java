package bcoder.securityApp.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JobActivityId implements Serializable {
  @Column(name = "job_id")
  private Long jobId;

  @Column(name = "activity_id")
  private Long activityId;

  public JobActivityId() {
  }

  public JobActivityId(Long jobId, Long activityId) {
    this.activityId = activityId;
    this.jobId = jobId;
  }

  public Long getJobId ( ) {
    return jobId;
  }

  public void setJobId ( Long jobId ) {
    this.jobId = jobId;
  }

  public Long getActivityId ( ) {
    return activityId;
  }

  public void setActivityId ( Long activityId ) {
    this.activityId = activityId;
  }

  @Override
  public boolean equals ( Object o ) {
    if (this == o) return true;
    if (o == null || getClass ( ) != o.getClass ( )) return false;
    JobActivityId that = (JobActivityId) o;
    return Objects.equals ( jobId , that.jobId ) && Objects.equals ( activityId , that.activityId );
  }

  @Override
  public int hashCode ( ) {
    return Objects.hash ( jobId , activityId );
  }
}
