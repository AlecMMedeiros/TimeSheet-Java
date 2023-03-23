package bcoder.securityApp.model;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class UserModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column( length = 50, nullable = false, unique = true)
  private String email;
  @Column(length = 64, nullable = false, unique = true)
  private String displayName;
  @Column(length = 64, nullable = false, unique = true)
  private String password;
  @Column(length = 64, nullable = false)
  private String role;


  public UserModel ( ) {
  }

  public Long getId () {
    return id;
  }

  public String getEmail () {
    return email;
  }

  public void setEmail ( String email ) {
    this.email = email;
  }

  public String getDisplayName () {
    return displayName;
  }

  public void setDisplayName ( String displayName ) {
    this.displayName = displayName;
  }

  public String getPassword () {
    return password;
  }

  public void setPassword ( String password ) {
    this.password = password;
  }

  public String getRole () {
    return role;
  }

  public void setRole ( String role ) {
    this.role = role;
  }
}
