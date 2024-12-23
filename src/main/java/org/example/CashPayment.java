package org.example;

public class CashPayment implements Paymentable {
    @Override
    public void pay(Wallet wallet, int productPrice) {
        wallet.balance -= productPrice;
    }
}
