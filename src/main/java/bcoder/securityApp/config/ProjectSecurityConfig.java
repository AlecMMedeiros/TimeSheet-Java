package bcoder.securityApp.config;

import bcoder.securityApp.filter.CsrfCookieFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.cors.CorsConfiguration;


import java.util.Collections;

@Configuration
public class ProjectSecurityConfig {

  public static final String[] ENDPOINTS_STAFF_ONLY = {
      "/admin/**",
  };
  public static final String[] ENDPOINTS_USERS = {
      "/jobs/**",
      "/users/**"
  };

  public static final String[] ENDPOINTS_PERMIT_ALL = {
      "/v3/api-docs/**",
      "/swagger-ui/**"
  };

  public static final RequestMatcher[] ignoringRequestMatchers = {
  };

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    CsrfTokenRequestAttributeHandler requestAttributeHandler = new CsrfTokenRequestAttributeHandler();
    http.cors().configurationSource(request -> {
      CorsConfiguration configuration = new CorsConfiguration();
      configuration.setAllowedOrigins(Collections.singletonList("*"));
      configuration.setAllowedMethods(Collections.singletonList("*"));
      configuration.setAllowCredentials(true);
      configuration.setAllowedHeaders(Collections.singletonList("*"));
      configuration.setMaxAge(3600L);
      return configuration;
    }).and()
        .csrf((csrf)-> csrf.csrfTokenRequestHandler(requestAttributeHandler).ignoringRequestMatchers(ignoringRequestMatchers )
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
        .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
        .authorizeHttpRequests()
        .requestMatchers(ENDPOINTS_STAFF_ONLY).hasAuthority("staff")
        .requestMatchers(ENDPOINTS_USERS).hasAnyAuthority("staff", "USER")
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