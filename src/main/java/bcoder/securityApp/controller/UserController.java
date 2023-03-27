package bcoder.securityApp.controller;

import bcoder.securityApp.dto.UserUpdateDTO;
import bcoder.securityApp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  public UserController ( UserService userService ) {
    this.userService = userService;
  }

  @GetMapping("/info")
  public ResponseEntity currentUserData (Principal principal){
    return userService.currentUserData(principal.getName());
  }
  @PutMapping("/updated")
  private void updateDisplayName( @RequestBody UserUpdateDTO updatedUser, Principal principal ){
    userService.updateUser(principal.getName(), updatedUser);
  }
}
