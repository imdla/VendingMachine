package org.example;

import org.example.user.Wallet;

public class CashPayment implements Paymentable, Changeable {

    // 결제
    @Override
    public void pay(Wallet wallet, int productPrice) {
        wallet.balance -= productPrice;
        calculateChange(wallet);
    }

    // 거스름돈 계산
    @Override
    public void calculateChange(Wallet wallet) {
        System.out.println("Change: " + wallet.balance);
    }
}
