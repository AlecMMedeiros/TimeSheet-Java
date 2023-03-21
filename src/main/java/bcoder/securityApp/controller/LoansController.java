package bcoder.securityApp.controller;

import bcoder.securityApp.service.LoansService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
  private final LoansService loansService;

  public LoansController ( LoansService loansService ) {
    this.loansService = loansService;
  }

  @GetMapping("/myLoans")
  public String getLoanDetails() {
    return loansService.getLoanDetails ();
  }

}
