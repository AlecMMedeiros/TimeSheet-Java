package bcoder.securityApp.service;

import bcoder.securityApp.model.ActivityModel;
import bcoder.securityApp.model.JobModel;
import bcoder.securityApp.model.UserModel;
import bcoder.securityApp.repository.ActivityRepository;
import bcoder.securityApp.repository.JobRepository;
import bcoder.securityApp.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobService {
  private final JobRepository jobRepository;
  private final UserRepository userRepository;
  private final ActivityRepository activityRepository;

  public JobService ( JobRepository jobRepository, UserRepository userRepository , ActivityRepository activityRepository ) {
    this.jobRepository = jobRepository;
    this.userRepository = userRepository;
    this.activityRepository = activityRepository;
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
      UserModel user = userRepository.findByEmail(userEmail);
      ActivityModel newActivity;
      Set<UserModel> users = new HashSet<>();
      Set<ActivityModel> activities = new HashSet<>();
      users.add(user);
      for ( ActivityModel activity : job.getActivities ( ) ) {
        newActivity = activityRepository.save ( activity );
        activities.add ( newActivity );
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

