package bcoder.securityApp.service;

import bcoder.securityApp.model.ActivityModel;
import bcoder.securityApp.model.JobModel;
import bcoder.securityApp.model.UserModel;
import bcoder.securityApp.repository.JobRepository;
import bcoder.securityApp.service.interfaces.IJobServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobService implements IJobServices {
  private final JobRepository jobRepository;
  private final UserService userService;
  private final ActivityService activityService;

  public JobService ( JobRepository jobRepository, UserService userService, ActivityService activityService ) {
    this.jobRepository = jobRepository;
    this.userService = userService;
    this.activityService = activityService;
  }

  public ResponseEntity<?> listJobs() {
    ResponseEntity<?> response;
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

  public ResponseEntity<?> createJob( JobModel job, String userEmail) {
    ResponseEntity<?> response;
    try {
      UserModel user = userService.findUserByEmail(userEmail);

      Set<UserModel> users = new HashSet<>();
      users.add(user);
      for ( ActivityModel activity : job.getActivities ( ) ) {
       activityService.simpleSaving ( activity );
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

  public ResponseEntity<String> removeJob(Long id){
    Optional<JobModel> job = jobRepository.findById(id);
    try{
      if( job.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job Not Found");
      }else {
        jobRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Job removed from Database");
      }
    }catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body( "An exception occurred due to " + exception.getMessage () );
    }
  }
}

