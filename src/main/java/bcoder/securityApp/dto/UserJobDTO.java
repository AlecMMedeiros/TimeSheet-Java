package bcoder.securityApp.dto;

import bcoder.securityApp.model.JobModel;
import bcoder.securityApp.model.UserModel;

import java.util.List;

public class UserJobDTO {
  private UserModel user;
  private List<JobModel> jobs;

  public UserJobDTO(UserModel user, List<JobModel> jobs) {
    this.user = user;
    this.jobs = jobs;
  }


  public UserModel getUser() {
    return user;
  }

  public void setUser(UserModel user) {
    this.user = user;
  }

  public List<JobModel> getJobs() {
    return jobs;
  }

  public void setJobs(List<JobModel> jobs) {
    this.jobs = jobs;
  }
}
