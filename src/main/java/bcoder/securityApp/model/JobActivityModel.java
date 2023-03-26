package bcoder.securityApp.model;

import bcoder.securityApp.dto.JobActivityId;
import jakarta.persistence.*;

@Entity
@Table(name = "job_activities")
public class JobActivityModel {
  @EmbeddedId
  private JobActivityId id;
  @ManyToOne
  @MapsId("jobId")
  @JoinColumn(name = "job_id", nullable = false)
  private JobModel job;
  @ManyToOne
  @MapsId("activityId")
  @JoinColumn(name = "activity_id", nullable = false)
  private ActivityModel activity;

  public JobActivityModel ( ) {
  }

  public JobActivityModel ( JobModel job , ActivityModel activity) {
    this.activity = activity;
    this.job = job;
    this.id = new JobActivityId ( job.getId ( ), activity.getId ( ));
  }

  public JobActivityId getId ( ) {
    return id;
  }

  public void setId ( JobActivityId id ) {
    this.id = id;
  }

  public JobModel getJob ( ) {
    return job;
  }

  public void setJob ( JobModel job ) {
    this.job = job;
  }

  public ActivityModel getActivity ( ) {
    return activity;
  }

  public void setActivity ( ActivityModel activity ) {
    this.activity = activity;
  }
}