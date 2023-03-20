package bcoder.securityApp.controller;

import bcoder.securityApp.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  private final AccountService accountService;

  public AccountController ( AccountService accountService ) {
    this.accountService = accountService;
  }

  @GetMapping("/myAccount")
  public String getAccountDetails() {
    return accountService.getAccountDetails ();
  }

}