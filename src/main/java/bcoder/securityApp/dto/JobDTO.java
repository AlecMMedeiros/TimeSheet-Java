package bcoder.securityApp.dto;

import java.time.LocalDateTime;
import java.util.Set;

public class JobDTO {
  private Long id;
  private String title;
  private String description;
  private Integer os;
  private String status;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private Set<UserWithoutPasswordDTO> users;

  public JobDTO(Long id, String title, String description, Integer os, String status, LocalDateTime createdAt, LocalDateTime updatedAt) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.os = os;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Long getId () {
    return id;
  }

  public void setId ( Long id ) {
    this.id = id;
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

  public String getStatus () {
    return status;
  }

  public void setStatus ( String status ) {
    this.status = status;
  }

  public LocalDateTime getCreatedAt () {
    return createdAt;
  }

  public void setCreatedAt ( LocalDateTime createdAt ) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt () {
    return updatedAt;
  }

  public void setUpdatedAt ( LocalDateTime updatedAt ) {
    this.updatedAt = updatedAt;
  }

  public Set<UserWithoutPasswordDTO> getUsers () {
    return users;
  }

  public void setUsers ( Set<UserWithoutPasswordDTO> users ) {
    this.users = users;
  }

}

