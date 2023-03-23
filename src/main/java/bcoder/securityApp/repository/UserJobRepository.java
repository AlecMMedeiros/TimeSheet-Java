package bcoder.securityApp.repository;

import bcoder.securityApp.model.UserJobModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJobRepository extends JpaRepository<UserJobModel, Long>{

}