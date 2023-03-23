package bcoder.securityApp.controller;

import bcoder.securityApp.dto.UserJobDTO;
import bcoder.securityApp.repository.UserRepository;
import bcoder.securityApp.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/jobs")
public class JobController {
  private final JobService jobService;
  private final UserRepository userRepository;


  public JobController ( JobService jobService, UserRepository userRepository ) {
    this.jobService = jobService;
    this.userRepository = userRepository;
  }

  @GetMapping
  public ResponseEntity listJobs(){
    return jobService.listJobs();
  }

  @PostMapping("/register")
  public ResponseEntity createJob( @RequestBody UserJobDTO job, Principal principal) {
    ResponseEntity createdJob = jobService.createJob(job, principal.getName());
    return createdJob;
  }
}


