package org.example.user;

import org.example.vendingmachine.VendingMachine;

import java.util.Scanner;

public class Customer extends User implements ProductNameValidatable {
    protected Wallet wallet;

    public Customer(Wallet wallet) {
        this.wallet = wallet;
    }

    // 자판기 사용
    public void use(VendingMachine vendingMachine){
        boolean flag = true;
        while (flag) {
            if (vendingMachine.use(wallet)) {
                // 메뉴 선택
                Scanner scanner = new Scanner(System.in);
                System.out.println("What kind of product are you going to buy ?");
                System.out.println("[ If you don't want to buy something, type 'cancel'. ]");
                String productName = scanner.next();

                if (productName.toLowerCase().equals("cancel")) {
                    System.out.println("The puchase has been completed.");
                    break;
                }

                //상품 구매
                buy(productName, vendingMachine);
            } else {
                System.out.println("You have a small balance !");
                flag = false;
            }
        }
    }

    // 상품 구매
    public void buy(String productName, VendingMachine vendingMachine) {
        if (validateProductName(productName, vendingMachine)) {
            vendingMachine.pay(productName, wallet);
        } else {
            System.out.println("Invalid product name !");
        }
    }

    // 제품명 검사
    @Override
    public boolean validateProductName(String productName, VendingMachine vendingMachine) {
        if (vendingMachine.productMap.get(productName) == null) {
            return false;
        } else {
            return true;
        }
    }
}
