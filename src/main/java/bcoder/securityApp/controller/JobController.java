package bcoder.securityApp.controller;

import bcoder.securityApp.model.JobModel;
import bcoder.securityApp.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/jobs")
public class JobController {
  private final JobService jobService;


  public JobController ( JobService jobService) {
    this.jobService = jobService;
  }

  @GetMapping
  public ResponseEntity listJobs(){
    return jobService.listJobs();
  }

  @PostMapping("/register")
  public ResponseEntity createJob( @RequestBody JobModel job, Principal principal) {
    return jobService.createJob( job, principal.getName());
  }

  @DeleteMapping("/remove")
  public ResponseEntity<String> removeJob (@RequestBody Long id){
    return jobService.removeJob(id);
  }
}


