package bcoder.securityApp.service;


import org.springframework.stereotype.Service;

@Service
public class AccountService {
  public String getAccountDetails() {
    return "Here are the account details from the DB";
  }


}
