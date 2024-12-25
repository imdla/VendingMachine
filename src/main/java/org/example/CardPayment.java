package org.example;

public class CardPayment implements Paymentable, BalanceCheckable {

    // 결제
    @Override
    public void pay(Wallet wallet, int productPrice) {
        wallet.balance -= productPrice;
        checkBalance(wallet);
    }

    // 잔액 확인
    @Override
    public void checkBalance(Wallet wallet) {
        System.out.println("Balance: " + wallet.balance);
    }
}
