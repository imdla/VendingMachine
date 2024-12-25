package org.example;

import java.util.List;
import java.util.Map;

public class Admin extends User implements ProductManagable, ProductNameValidable, PriceValidable {

    public Admin(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    // 재고 관리
    @Override
    public void stockManagement() {
        for (String name : vendingMachine.productMap.keySet()) {
            List<Integer> productList = vendingMachine.productMap.get(name);
            System.out.println(name + ": " + productList.getLast());
        }
    }

    // 매출 확인
    @Override
    public void showSales() {
        Map<String, Integer> productSales = vendingMachine.productSales;

        for (String name : vendingMachine.productMap.keySet()) {
            List<Integer> productList = vendingMachine.productMap.get(name);
            int productPrice = productList.getLast();
            int sales = productSales.get(name) * productPrice;
            System.out.println(name + ": " + sales + " won");
        }
    }

    // 상품 가격 설정
    @Override
    public void setProductPrice(String name, int price) {
        Map<String, List<Integer>> productMap = vendingMachine.productMap;

        if (validationProductName(name) && validationPrice(price)) {
            List<Integer> productList = productMap.get(name);
            productList.set(0, price);
            System.out.println(name + ": " + productList.getFirst());
        } else {
            System.out.println("Invalid product name !");
        }
    }

    // 금액 검사
    @Override
    public boolean validationPrice(int price) {
        if (price > 0 || Math.log10(price)+1 > 3) {
            return true;
        } else {
            System.out.println("Enter 1000 won or more");
            return false;
        }
    }

    // 제품명 검사
    @Override
    public boolean validationProductName(String productName) {
        if (vendingMachine.productMap.get(productName) == null) {
            return false;
        } else {
            return true;
        }
    }
}
