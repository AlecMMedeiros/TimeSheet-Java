package bcoder.securityApp.service.interfaces;

import bcoder.securityApp.dto.UserJobDTO;
import bcoder.securityApp.dto.UserUpdateDTO;
import bcoder.securityApp.model.UserModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
  List<UserModel> listUsers ();
  ResponseEntity<UserModel> currentUserData ( String email);
  ResponseEntity<List<Object[]>> currentJobs ( String email);
  UserModel findUserByEmail (String email);
  UserModel save(UserModel newUser);
  ResponseEntity<UserModel> updateUser( String email, UserUpdateDTO request);
  void removeUser (Long id);
  List<UserJobDTO> getUsersWithJobs();
}
