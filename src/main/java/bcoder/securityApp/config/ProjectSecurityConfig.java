package bcoder.securityApp.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;

@Configuration
public class ProjectSecurityConfig {

  public static final String[] ENDPOINTS_AUTHORIZED = {
      "/myAccount",
      "/myBalance",
      "/myLoans",
      "/myCards"
  };

  public static final String[] ENDPOINTS_PERMIT_ALL = {
      "/notices",
      "/contact",
      "/register",
      "/v3/api-docs/**",
      "/swagger-ui/**"
  };

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http.cors().configurationSource(new CorsConfigurationSource() {
          @Override
          public CorsConfiguration getCorsConfiguration ( HttpServletRequest request ) {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(Collections.singletonList("*"));
            configuration.setAllowedMethods(Collections.singletonList("*"));
            configuration.setAllowCredentials(true);
            configuration.setAllowedHeaders(Collections.singletonList("*"));
            configuration.setMaxAge(3600L);
            return configuration;
          }
        }).and()
        .csrf().disable()
        .authorizeHttpRequests()
        .requestMatchers(ENDPOINTS_AUTHORIZED).authenticated()
        .requestMatchers(ENDPOINTS_PERMIT_ALL).permitAll()
        .and().formLogin()
        .and().httpBasic();
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder (12 );
  }

}