package com.paradigmas.Service;

import com.paradigmas.TDA.Client;

public class AccountOperationService {

  public void withdrawMoney(Client aClient, int value) {

    // AccountValidationService. En esta clase encapsulamos todos los métodos relativos a
    // verificación de la identidad y validación de la cuenta y cliente
    // Para esto instanciamos un objeto de esa clase y utilizamos sus métodos
    AccountValidationService accountValidationService = new AccountValidationService();

    try {
      if (accountValidationService.canClientOperate(aClient)
          && aClient.getAccount().getCurrentMoney() > 0) {
        int totalMoneyAfterWithdraw = aClient.getAccount().getCurrentMoney() - value;
        aClient.getAccount().setCurrentMoney(totalMoneyAfterWithdraw);
      }
    } catch (Exception e) {
      System.out.println("Something went wrong.");
    }
  }
}
