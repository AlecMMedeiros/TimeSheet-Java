package bcoder.securityApp.controller;

import bcoder.securityApp.dto.UserJobDTO;
import bcoder.securityApp.model.UserModel;
import bcoder.securityApp.service.StaffService;
import bcoder.securityApp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class StaffController {
  private final StaffService staffService;
  private final UserService userService;
  public StaffController ( StaffService staffService, UserService userService ) {
    this.staffService = staffService;
    this.userService = userService;
  }

  @GetMapping("/users")
  public List<UserModel> listUsers(){
    return staffService.listUsers();
  }

  @PostMapping("/users/register")
  public ResponseEntity registerUser( @RequestBody UserModel newUser){
    return  staffService.createUser(newUser);
  }

  @DeleteMapping("/users/remove")
  public ResponseEntity removeUser(@RequestBody Long id){
    return staffService.removeUser(id);
  }

  @GetMapping("/users/jobs")
  public List<UserJobDTO> getUsersWithJobs() {
    return userService.getUsersWithJobs();
  }
}
