package bcoder.securityApp.controller;

import bcoder.securityApp.service.LoansService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

  LoansService loansService;

  @GetMapping("/myLoans")
  public String getLoanDetails() {
    return loansService.getLoanDetails ();
  }

}
