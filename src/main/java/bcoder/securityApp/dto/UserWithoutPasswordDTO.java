package bcoder.securityApp.dto;

public class UserWithoutPasswordDTO {
  private Long id;
  private String email;
  private String displayName;
  private String role;

  public UserWithoutPasswordDTO ( Long id, String email, String displayName, String role ) {
    this.id = id;
    this.email = email;
    this.displayName = displayName;
    this.role = role;
  }

  public Long getId () {
    return id;
  }

  public void setId ( Long id ) {
    this.id = id;
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

  public String getRole () {
    return role;
  }

  public void setRole ( String role ) {
    this.role = role;
  }
}