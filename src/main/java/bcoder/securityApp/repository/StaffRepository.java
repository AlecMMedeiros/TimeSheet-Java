package bcoder.securityApp.repository;

import bcoder.securityApp.model.StaffModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepository extends JpaRepository< StaffModel, Long > {
  List <StaffModel> findByLogin(String login);
}
