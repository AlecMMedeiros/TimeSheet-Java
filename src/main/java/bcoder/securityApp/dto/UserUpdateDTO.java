package bcoder.securityApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserUpdateDTO {
  @JsonProperty("displayName")
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  private String displayName;
  public String getDisplayName() {
    return displayName;
  }

}
