package bcoder.securityApp.service;

import bcoder.securityApp.dto.UserUpdateDTO;
import bcoder.securityApp.model.UserModel;
import bcoder.securityApp.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService ( UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<UserModel> listUsers (){
    return userRepository.findAll ();
  }

  public ResponseEntity<UserModel> currentUserData ( String email){
    return ResponseEntity.status(HttpStatus.OK).body(userRepository.findByEmail(email));
  }

  public UserModel findUserByEmail (String email){
    return userRepository.findByEmail(email);
  }

  public UserModel save(UserModel newUser){
    return userRepository.save(newUser);
  }

  public void updateUser( String email, UserUpdateDTO request) {
    UserModel user = userRepository.findByEmail(email);
    user.setDisplayName(request.getDisplayName());
    userRepository.save(user);
  }

  public void removeUser (Long id){
    userRepository.deleteById(id);
  }

}
