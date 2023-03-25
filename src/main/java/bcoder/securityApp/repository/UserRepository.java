package bcoder.securityApp.repository;

import bcoder.securityApp.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
  UserModel findByEmail( String email);

}
