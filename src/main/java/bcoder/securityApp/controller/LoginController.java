package bcoder.securityApp.controller;

import bcoder.securityApp.model.UserModel;
import bcoder.securityApp.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;


  public LoginController ( UserRepository userRepository , PasswordEncoder passwordEncoder ) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }


  @PostMapping("/register")
  public ResponseEntity<String> registerUser ( @RequestBody UserModel newUser ) {
    UserModel savedUser = null;
    ResponseEntity response = null;
    try {
      String hashPwd = passwordEncoder.encode ( newUser.getPassword () );
      newUser.setPassword ( hashPwd );
      savedUser = userRepository.save ( newUser );
      if(savedUser.getId () > 0) {
        response = ResponseEntity
            .status ( HttpStatus.CREATED )
            .body ( "Give user details are successfully registered" );
      }
    }catch (Exception exception){
      response = ResponseEntity
          .status ( HttpStatus.INTERNAL_SERVER_ERROR )
          .body ( "An exception occurred due to " + exception.getMessage () );
    }
    return response;
  }
}
