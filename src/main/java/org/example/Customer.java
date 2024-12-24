package org.example;

public class Customer extends User {
    protected Wallet wallet;

    public Customer(VendingMachine vendingMachine, Wallet wallet) {
        super(vendingMachine);
        this.wallet = wallet;
    }

    // 상품 구매
    public void buy(String productName) {
        vendingMachine.pay(productName, wallet);
    }
}
