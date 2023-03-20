package bcoder.securityApp.service;

import org.springframework.stereotype.Service;

@Service
public class BalanceService {

  public String getBalanceDetails() {
    return "Here are the balance details from the DB";
  }

}
