package org.example;

public class Customer extends User {
    // 현금, 10000 가짐

    public Customer(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    // 상품 구매
    public void buy(String productName) {
        vendingMachine.pay(productName, "wallet");
    }
}
