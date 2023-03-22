package bcoder.securityApp.controller;

import bcoder.securityApp.service.BalanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BalanceController {

  private final BalanceService balanceService;

  public BalanceController ( BalanceService balanceService ) {
    this.balanceService = balanceService;
  }

  @GetMapping("/myBalance")
  public String getBalanceDetails() {
    return balanceService.getBalanceDetails ();
  }

}