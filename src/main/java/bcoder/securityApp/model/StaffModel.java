package bcoder.securityApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "staff")
public class StaffModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column( length = 50, nullable = false, unique = true)
  @Email(message = "Email should be valid")
  @NotNull
  private String email;
  @Column(length = 20, nullable = false, unique = true)
  @NotNull
  private String login;
  @Column(length = 100, nullable = false)
  @NotNull
  private String password;

  public StaffModel ( String email , String login , String password ) {
    this.email = email;
    this.login = login;
    this.password = password;
  }

  public StaffModel ( ) {
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

  @Override
  public String toString ( ) {
    return "StaffModel{" +
        "id=" + id +
        ", email='" + email + '\'' +
        ", login='" + login + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
