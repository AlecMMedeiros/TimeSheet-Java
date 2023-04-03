package bcoder.securityApp.service.interfaces;

import bcoder.securityApp.model.JobModel;
import org.springframework.http.ResponseEntity;


public interface IJobServices {
 ResponseEntity<?> listJobs();
 ResponseEntity<?> createJob( JobModel job, String userEmail);
 ResponseEntity<String> removeJob(Long id);
}
