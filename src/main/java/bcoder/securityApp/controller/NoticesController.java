package bcoder.securityApp.controller;

import bcoder.securityApp.service.NoticesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

  NoticesService noticesService;

  @GetMapping("/notices")
  public String getNotices() {
    return noticesService.getNotices ();
  }

}
