package bcoder.securityApp.controller;

import bcoder.securityApp.dto.UserWithoutPasswordDTO;
import bcoder.securityApp.model.UserModel;
import bcoder.securityApp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdministrationController {
  private final UserService userService;

  public AdministrationController ( UserService userService ) {
    this.userService = userService;
  }

  @GetMapping("/users")
  public List<UserWithoutPasswordDTO> listUsers(){
    return userService.listUsers();
  }

  @PostMapping("/users/register")
  public ResponseEntity registerUser( @RequestBody UserModel newUser) throws Exception {
    return  userService.createUser(newUser);
  }
}
