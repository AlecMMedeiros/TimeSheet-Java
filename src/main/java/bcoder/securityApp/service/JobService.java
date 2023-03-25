package bcoder.securityApp.service;

import bcoder.securityApp.model.JobModel;
import bcoder.securityApp.model.UserModel;
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

  public JobService ( JobRepository jobRepository, UserRepository userRepository ) {
    this.jobRepository = jobRepository;
    this.userRepository = userRepository;
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
      Set<UserModel> users = new HashSet<>();
      users.add(user);
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

