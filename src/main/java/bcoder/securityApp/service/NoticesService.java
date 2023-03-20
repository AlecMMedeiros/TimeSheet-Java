package bcoder.securityApp.service;

import org.springframework.stereotype.Service;

@Service
public class NoticesService {

  public String getNotices() {
    return "Here are the notices details from the DB";
  }

}
