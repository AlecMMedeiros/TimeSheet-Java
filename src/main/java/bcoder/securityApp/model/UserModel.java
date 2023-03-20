package bcoder.securityApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class UserModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long id;
  @Column( length = 50, nullable = false, unique = true)
  @Email(message = "Email should be valid")
  @NotNull
  private String email;
  @Column(length = 20, nullable = false, unique = true)
  @NotNull
  private String login;
  @Column(length = 20, nullable = false, unique = true)
  @NotNull
  private String username;
  @Column(length = 100, nullable = false)
  @NotNull
  private String password;
  @Column(length = 20, nullable = false)
  @NotNull
  private String role;


  public UserModel ( ) {
  }

  public Long getId ( ) {
    return id;
  }

  public void setId ( Long id ) {
    this.id = id;
  }

  public String getEmail ( ) {
    return email;
  }

  public void setEmail ( String email ) {
    this.email = email;
  }

  public String getLogin ( ) {
    return login;
  }

  public void setLogin ( String login ) {
    this.login = login;
  }

  public String getUsername ( ) {
    return username;
  }

  public void setUsername ( String username ) {
    this.username = username;
  }

  public String getPassword ( ) {
    return password;
  }

  public void setPassword ( String password ) {
    this.password = password;
  }

  public String getRole ( ) {
    return role;
  }

  public void setRole ( String role ) {
    this.role = role;
  }

  @Override
  public String toString ( ) {
    return "UserModel{" +
        "id=" + id +
        ", email='" + email + '\'' +
        ", login='" + login + '\'' +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", role='" + role + '\'' +
        '}';
  }
}
