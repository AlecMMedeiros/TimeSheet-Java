package bcoder.securityApp.config;

import bcoder.securityApp.model.StaffModel;
import bcoder.securityApp.model.UserModel;
import bcoder.securityApp.repository.StaffRepository;
import bcoder.securityApp.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetails implements UserDetailsService {

  private final UserRepository userRepository;
  private final StaffRepository staffRepository;

  public CustomUserDetails ( UserRepository customerRepository , StaffRepository staffRepository) {
    this.userRepository = customerRepository;
    this.staffRepository = staffRepository;
  }


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    String userName, password = null;
    List<GrantedAuthority> authorities = null;
    List< UserModel > customer = userRepository.findByLogin ( username);
    if (customer.size() == 0) {
      List< StaffModel > staff = staffRepository.findByLogin ( username);
      if(staff.size() == 0)
        throw new UsernameNotFoundException("User details not found for the user : " + username);
      else {
        userName = staff.get(0).getLogin ();
        password = staff.get(0).getPassword ();
        authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("staff"));
      }
    } else{
      userName = customer.get(0).getLogin ();
      password = customer.get(0).getPassword ();
      authorities = new ArrayList<>();
      authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
    }
    return new User(username,password,authorities);
  }

}