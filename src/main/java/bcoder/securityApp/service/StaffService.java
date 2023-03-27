package bcoder.securityApp.service;

import bcoder.securityApp.model.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
  private final UserService userService;
  private final PasswordEncoder passwordEncoder;


  public StaffService ( UserService userService, PasswordEncoder passwordEncoder ) {
    this.userService = userService;
    this.passwordEncoder = passwordEncoder;  }


  public List<UserModel> listUsers (){
    return userService.listUsers ();
  }

  public ResponseEntity createUser( UserModel newUser ) {
    UserModel savedUser;
    ResponseEntity response = null;
    try {
      String hashPwd = passwordEncoder.encode ( newUser.getPassword () );
      newUser.setPassword ( hashPwd );
      savedUser = userService.save ( newUser );
      if(savedUser.getId () > 0) {
        response = ResponseEntity
            .status ( HttpStatus.CREATED )
            .body (savedUser);
      }
    }catch (Exception exception){
      return ResponseEntity
          .status ( HttpStatus.INTERNAL_SERVER_ERROR )
          .body ( "An exception occurred due to " + exception.getMessage () );
    }
    return response;
  }

  public void updateUser (UserModel updatedUser){

  }
  public ResponseEntity<String> removeUser( Long id){
    try {
      userService.removeUser(id);
      return ResponseEntity.status(HttpStatus.OK).body("User Removed from Database");
    } catch (Exception exception) {
      return ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body( "An exception occurred due to " + exception.getMessage () + " , please verify if the user has linked Jobs.");
    }
  }
}
