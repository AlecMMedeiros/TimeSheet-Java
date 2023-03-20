package bcoder.securityApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

  public static final String[] ENDPOINTS_AUTHORIZED = {
      "/myAccount",
      "/myBalance",
      "/myLoans",
      "/myCards"
  };

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeHttpRequests()
        .requestMatchers(ENDPOINTS_AUTHORIZED).authenticated()
        .requestMatchers("/notices","/contact","/register").permitAll()
        .and().formLogin()
        .and().httpBasic();
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder (12  );
  }

}