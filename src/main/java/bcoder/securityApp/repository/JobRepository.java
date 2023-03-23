package bcoder.securityApp.repository;

import bcoder.securityApp.model.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobModel, Long> {
}
