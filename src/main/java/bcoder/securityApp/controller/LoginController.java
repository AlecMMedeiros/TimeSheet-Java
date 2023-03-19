package bcoder.securityApp.controller;

import bcoder.securityApp.model.UserModel;
import bcoder.securityApp.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
  private final UserRepository userRepository;

  public LoginController ( UserRepository userRepository ) {
    this.userRepository = userRepository;
  }

  @PostMapping("/register")
  public ResponseEntity<String> registerUser ( @RequestBody UserModel newUser ) {
    UserModel savedUser = null;
    ResponseEntity response = null;
    try {
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
