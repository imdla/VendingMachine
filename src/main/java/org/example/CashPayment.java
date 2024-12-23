package org.example;

public class CashPayment implements Paymentable, Changeable {

    // 결제
    @Override
    public void pay(Wallet wallet, int productPrice) {
        wallet.balance -= productPrice;
        calculationChange(wallet);
    }

    // 거스름돈 계산
    @Override
    public void calculationChange(Wallet wallet) {
        System.out.println("Change: " + wallet.balance);
    }
}
