package org.example;

public class Customer extends User implements ProductNameValidatable {
    protected Wallet wallet;

    public Customer(VendingMachine vendingMachine, Wallet wallet) {
        super(vendingMachine);
        this.wallet = wallet;
    }

    // 상품 구매
    public void buy(String productName) {
        메뉴 출력
        scanner
        if (validateProductName(productName)) {
            vendingMachine.pay(productName, wallet);
        } else {
            System.out.println("Invalid product name !");
        }
    }

    use(){
        show menu
        choose menu
        buy
    }
    // 제품명 검사
    @Override
    public boolean validateProductName(String productName) {
        if (vendingMachine.productMap.get(productName) == null) {
            return false;
        } else {
            return true;
        }
    }
}
