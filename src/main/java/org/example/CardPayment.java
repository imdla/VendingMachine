package org.example;

public class CardPayment implements Paymentable {

    // 결제
    @Override
    public void pay(Wallet wallet, int productPrice) {
        wallet.balance -= productPrice;
    }
}
