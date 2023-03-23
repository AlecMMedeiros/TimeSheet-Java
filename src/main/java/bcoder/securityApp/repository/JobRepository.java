package bcoder.securityApp.repository;

import bcoder.securityApp.model.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRepository extends JpaRepository<JobModel, Long> {
    @Query("SELECT j FROM JobModel j JOIN FETCH j.users")
    List<JobModel> findAllWithUsers();
}
