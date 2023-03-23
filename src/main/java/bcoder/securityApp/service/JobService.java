package bcoder.securityApp.service;

import bcoder.securityApp.dto.JobDTO;
import bcoder.securityApp.dto.UserJobDTO;
import bcoder.securityApp.dto.UserWithoutPasswordDTO;
import bcoder.securityApp.model.JobModel;
import bcoder.securityApp.model.UserModel;
import bcoder.securityApp.repository.JobRepository;
import bcoder.securityApp.repository.UserJobRepository;
import bcoder.securityApp.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JobService {
  private final JobRepository jobRepository;
  private final UserJobRepository userJobRepository;
  private final UserRepository userRepository;

  public JobService ( JobRepository jobRepository, UserJobRepository userJobRepository, UserRepository userRepository ) {
    this.jobRepository = jobRepository;
    this.userJobRepository = userJobRepository;
    this.userRepository = userRepository;
  }

  public ResponseEntity listJobs() {
    ResponseEntity response = null;
    try {
      List<JobModel> jobs = jobRepository.findAllWithUsers();
      List<JobDTO> result = jobs.stream().map(this::convertToJobDTO).toList();
      response = ResponseEntity.status(HttpStatus.OK).body(result);
    } catch (Exception exception){
      response = ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("An exception occurred due to " + exception.getMessage ());
    }
    return response;
  }

  private JobDTO convertToJobDTO(JobModel jobModel) {
    JobDTO jobDTO = new JobDTO(jobModel.getId(), jobModel.getTitle(), jobModel.getDescription(), jobModel.getOs(), jobModel.getStatus(), jobModel.getCreatedAt(), jobModel.getUpdatedAt());
    Set<UserWithoutPasswordDTO> userDTOs = jobModel.getUsers().stream().map(UserWithoutPasswordDTO::new).collect(Collectors.toSet());
    jobDTO.setUsers(userDTOs);
    return jobDTO;
  }

  private UserWithoutPasswordDTO populateUserDTO(UserModel user) {
    return new UserWithoutPasswordDTO(user);
  }

  private UserJobDTO populateJobDTO(JobModel job, UserModel user) throws Exception {
    Set<UserWithoutPasswordDTO> usersDTO = new HashSet<>();
    UserWithoutPasswordDTO userDTO = this.populateUserDTO(user);
    usersDTO.add(userDTO);
    return new UserJobDTO(
        job.getTitle(),
        job.getDescription(),
        job.getOs(),
        usersDTO );
  }
  public ResponseEntity createJob( UserJobDTO job, String userEmail) {
    ResponseEntity response = null;
    try {
      JobModel jobSaver = new JobModel();
      UserModel user = userRepository.findByEmail(userEmail);
      Set<UserModel> users = new HashSet<>();
      users.add(user);
      jobSaver.setTitle(job.getTitle());
      jobSaver.setDescription(job.getDescription());
      jobSaver.setOs(job.getOs());
      jobSaver.setStatus("Awaiting");
      jobSaver.setUsers(users);
      jobRepository.save(jobSaver);
      return response = ResponseEntity.status(HttpStatus.CREATED).body(this.populateJobDTO(jobSaver, user));
    } catch (Exception exception) {
      response = ResponseEntity
          .status ( HttpStatus.INTERNAL_SERVER_ERROR )
          .body ( "An exception occurred due to " + exception.getMessage () );
    }
    return response;
  }
}

