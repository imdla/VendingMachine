package org.example.user;

import org.example.vendingmachine.VendingMachine;

import java.util.List;
import java.util.Scanner;

public class Customer extends User implements ProductNameValidatable {
    protected Wallet wallet;

    public Customer(Wallet wallet) {
        this.wallet = wallet;
    }

    // 자판기 사용
    public void use(VendingMachine vendingMachine){
        // 내가 가진 금액 > 자판기 최소 금액 확인
        if (validateProductsMinPrice(vendingMachine, wallet)) {
            // 자판기 상품 보여주기
            showProducts(vendingMachine);

            // 메뉴 선택
            Scanner scanner = new Scanner(System.in);
            System.out.println("What kind of product are you going to buy ?");
            String productName = scanner.next();

            // 상품 구매
            buy(productName, vendingMachine);
        } else {
            System.out.println("You have a small balance !");
        }
    }

    // 자판기 최소 금액보다 큰지 검사
    public boolean validateProductsMinPrice(VendingMachine vendingMachine, Wallet wallet) {
        int productMinPrice = 10000;
        for (List<Integer> productList : vendingMachine.productMap.values()) {
            int productPrice = productList.getFirst();
            productMinPrice = Math.min(productMinPrice, productPrice);
        }

        if (productMinPrice > wallet.balance) {
            return false;
        } else {
            return true;
        }
    }

    // 자판기 상품 보여주기
    public void showProducts(VendingMachine vendingMachine) {
        for (String name : vendingMachine.productMap.keySet()) {
            List<Integer> productList = vendingMachine.productMap.get(name);
            int productPrice = productList.getFirst();
            int productStock = productList.getLast();

            if (productStock == 0) {
                System.out.println(name + ": " + "SoldOut");
            } else {
                System.out.println(name + ": " + productPrice + "won");
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
