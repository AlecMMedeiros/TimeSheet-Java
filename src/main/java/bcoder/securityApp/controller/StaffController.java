package bcoder.securityApp.controller;

import bcoder.securityApp.model.UserModel;
import bcoder.securityApp.service.StaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class StaffController {
  private final StaffService staffService;
  public StaffController ( StaffService staffService ) {
    this.staffService = staffService;
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
}
