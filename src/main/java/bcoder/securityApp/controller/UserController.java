package bcoder.securityApp.controller;

import bcoder.securityApp.dto.UserUpdateDTO;
import bcoder.securityApp.model.UserModel;
import bcoder.securityApp.service.interfaces.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {
  private final IUserService userService;

  public UserController ( IUserService userService ) {
    this.userService = userService;
  }

  @GetMapping("/info")
  public ResponseEntity<?> currentUserData (Principal principal){
    return userService.currentUserData(principal.getName());
  }
  @GetMapping("/jobs")
  public ResponseEntity<?> currentJobs (Principal principal){
    return userService.currentJobs(principal.getName());
  }
  @PutMapping("/updated")
  private ResponseEntity<UserModel> updateDisplayName( @RequestBody UserUpdateDTO updatedUser, Principal principal ){
    return userService.updateUser(principal.getName(), updatedUser);
  }
}
