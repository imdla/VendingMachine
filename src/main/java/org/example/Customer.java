package org.example;

public class Customer extends User implements ProductNameValidable {
    protected Wallet wallet;

    public Customer(VendingMachine vendingMachine, Wallet wallet) {
        super(vendingMachine);
        this.wallet = wallet;
    }

    // 상품 구매
    public void buy(String productName) {
        if (validationProductName(productName)) {
            vendingMachine.pay(productName, wallet);
        } else {
            System.out.println("Wrong product name !");
        }
    }



    // 제품명 검사
    public boolean validationProductName(String productName) {
        if (vendingMachine.productMap.get(productName) == null) {
            return false;
        } else {
            return true;
        }
    }
}
