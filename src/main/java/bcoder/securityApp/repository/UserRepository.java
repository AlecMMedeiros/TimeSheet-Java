package bcoder.securityApp.repository;

import bcoder.securityApp.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Long> {
  List < UserModel > findByLogin( String login);
}
