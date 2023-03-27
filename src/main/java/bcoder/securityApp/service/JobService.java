package bcoder.securityApp.service;

import bcoder.securityApp.model.ActivityModel;
import bcoder.securityApp.model.JobModel;
import bcoder.securityApp.model.UserModel;
import bcoder.securityApp.repository.JobRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobService {
  private final JobRepository jobRepository;
  private final UserService userService;
  private final ActivityService activityService;

  public JobService ( JobRepository jobRepository, UserService userService, ActivityService activityService ) {
    this.jobRepository = jobRepository;
    this.userService = userService;
    this.activityService = activityService;
  }

  public ResponseEntity listJobs() {
    ResponseEntity response;
    try {
      List<JobModel> jobs = jobRepository.findAll ();
      response = ResponseEntity.status(HttpStatus.OK).body(jobs);
    } catch (Exception exception){
      response = ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("An exception occurred due to " + exception.getMessage ());
    }
    return response;
  }

  public ResponseEntity createJob( JobModel job, String userEmail) {
    ResponseEntity response;
    try {
      UserModel user = userService.findUserByEmail(userEmail);
      ActivityModel newActivity;
      Set<UserModel> users = new HashSet<>();
      users.add(user);
      for ( ActivityModel activity : job.getActivities ( ) ) {
        newActivity = activityService.simpleSaving ( activity );
      }
      job.setStatus("Awaiting");
      job.setUsers(users);
      jobRepository.save(job);
      response = ResponseEntity.status(HttpStatus.CREATED).body(job);
    } catch (Exception exception) {
      response = ResponseEntity
          .status ( HttpStatus.INTERNAL_SERVER_ERROR )
          .body ( "An exception occurred due to " + exception.getMessage () );
    }
    return response;
  }
}

