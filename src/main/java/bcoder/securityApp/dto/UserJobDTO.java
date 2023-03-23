package bcoder.securityApp.dto;

import java.util.Set;

public class UserJobDTO {
    private String title;
    private String description;
    private Integer os;
  private Set<UserWithoutPasswordDTO> users;

  public UserJobDTO ( String title, String description, Integer os, Set<UserWithoutPasswordDTO> users ) {
    this.title = title;
    this.description = description;
    this.os = os;
    this.users = users;
  }



  public String getTitle () {
    return title;
  }

  public void setTitle ( String title ) {
    this.title = title;
  }

  public String getDescription () {
    return description;
  }

  public void setDescription ( String description ) {
    this.description = description;
  }

  public Integer getOs () {
    return os;
  }

  public void setOs ( Integer os ) {
    this.os = os;
  }

  public Set<UserWithoutPasswordDTO> getUsers () {
    return users;
  }

  public void setUsers ( Set<UserWithoutPasswordDTO> users ) {
    this.users = users;
  }
}
