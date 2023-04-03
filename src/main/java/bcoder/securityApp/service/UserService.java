package bcoder.securityApp.service;

import bcoder.securityApp.dto.UserJobDTO;
import bcoder.securityApp.dto.UserUpdateDTO;
import bcoder.securityApp.model.UserModel;
import bcoder.securityApp.repository.UserRepository;
import bcoder.securityApp.service.interfaces.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements IUserService {
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

  public ResponseEntity<List<Object[]>> currentJobs ( String email){
    return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAllWithJobsRawByEmail(email));
  }

  public UserModel findUserByEmail (String email){
    return userRepository.findByEmail(email);
  }

  public UserModel save(UserModel newUser){
    return userRepository.save(newUser);
  }

  public ResponseEntity<UserModel> updateUser( String email, UserUpdateDTO request) {
    UserModel user = userRepository.findByEmail(email);
    user.setDisplayName(request.getDisplayName());
    userRepository.save(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }

  public void removeUser (Long id){
    userRepository.deleteById(id);
  }

  public List<UserJobDTO> getUsersWithJobs(){
   return userRepository.findAllWithJobs();
  }

}



