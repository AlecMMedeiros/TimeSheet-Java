package bcoder.securityApp.service;

import bcoder.securityApp.model.UserModel;
import bcoder.securityApp.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserService ( UserRepository userRepository, PasswordEncoder passwordEncoder ) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }
  public List<UserModel> listUsers (){
    return userRepository.findAll ();
  }


  public ResponseEntity createUser( UserModel newUser ) {
    UserModel savedUser;
    ResponseEntity response = null;
    try {
      String hashPwd = passwordEncoder.encode ( newUser.getPassword () );
      newUser.setPassword ( hashPwd );
      savedUser = userRepository.save ( newUser );
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
}
