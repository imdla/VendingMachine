package org.example;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Admin extends User implements ProductManagable {

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

        if (productMap.containsKey(name)) {
            List<Integer> productList = productMap.get(name);
            productList.set(0, price);
            System.out.println(name + ": " + productList.get(0));
        } else {
            System.out.println("Invalid product name !");
        }
    }
}
