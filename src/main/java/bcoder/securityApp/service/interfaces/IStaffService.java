package bcoder.securityApp.service.interfaces;

import bcoder.securityApp.model.UserModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStaffService {
  List<UserModel> listUsers ();
  ResponseEntity<?> createUser( UserModel newUser );
  void updateUser (UserModel updatedUser);
  ResponseEntity<String> removeUser( Long id);
}
