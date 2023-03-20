package bcoder.securityApp.config;

import bcoder.securityApp.model.StaffModel;
import bcoder.securityApp.repository.StaffRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffUsernamePasswordAuthenticationProvider implements AuthenticationProvider {

  private final StaffRepository staffRepository;
  private PasswordEncoder passwordEncoder;

  public StaffUsernamePasswordAuthenticationProvider ( StaffRepository staffRepository , PasswordEncoder passwordEncoder ) {
    this.staffRepository = staffRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public Authentication authenticate ( Authentication authentication ) throws AuthenticationException {
    String username = authentication.getName ( );
    String password = authentication.getCredentials ( ).toString ( );
    List < StaffModel > staff = staffRepository.findByLogin ( username );
    if (staff.size ( ) > 0) {
      if (passwordEncoder.matches ( password , staff.get ( 0 ).getPassword ( ) )) {
        List < GrantedAuthority > authorities = new ArrayList <> ( );
        authorities.add ( new SimpleGrantedAuthority ( "staff" ) );
        return new UsernamePasswordAuthenticationToken ( username , password , authorities );
      } else {

        throw new BadCredentialsException ( "Invalid password!" );
      }
    } else {
      throw new BadCredentialsException ( "No user registered with this details!" );
    }
  }

  @Override
  public boolean supports ( Class < ? > authentication ) {
    return ( UsernamePasswordAuthenticationToken.class.isAssignableFrom ( authentication ) );
  }
}