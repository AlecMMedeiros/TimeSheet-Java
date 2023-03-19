package bcoder.securityApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
  @Column(length = 12, nullable = false)
  @NotNull
  private String password;
  @Column(length = 20, nullable = false)
  @NotNull
  private String role;

  public UserModel () {}

  public UserModel ( String email , String login , String password , String role ) {
    this.id = id;
    this.email = email;
    this.login = login;
    this.password = password;
    this.role = role;
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
        ", password='" + password + '\'' +
        ", role='" + role + '\'' +
        '}';
  }
}
