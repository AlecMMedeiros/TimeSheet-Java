package bcoder.securityApp.controller;

import bcoder.securityApp.service.CardsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

  CardsService cardsService;

  public CardsController ( CardsService cardsService ) {
    this.cardsService = cardsService;
  }

  @GetMapping("/myCards")
  public String getCardDetails() {
    return cardsService.getCardsDetails ();
  }

}