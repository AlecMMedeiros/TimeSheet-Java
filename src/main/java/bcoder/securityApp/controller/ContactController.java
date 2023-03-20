package bcoder.securityApp.controller;

import bcoder.securityApp.service.ContactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

  ContactService contactService;

  public ContactController ( ContactService contactService ) {
    this.contactService = contactService;
  }

  @GetMapping("/contact")
  public String saveContactInquiryDetails ( ) {
    return contactService.saveContactInquiryDetails ();
  }

}