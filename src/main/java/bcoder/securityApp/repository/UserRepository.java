package bcoder.securityApp.repository;

import bcoder.securityApp.dto.UserWithoutPasswordDTO;
import bcoder.securityApp.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Long> {
  List < UserModel > findByEmail( String email);
  @Query("SELECT new bcoder.securityApp.dto.UserWithoutPasswordDTO(u.id, u.email, u.displayName, u.role) FROM UserModel u")
  List<UserWithoutPasswordDTO> findAllWithoutPassword();

}
