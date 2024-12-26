package org.example.user;

import org.example.PriceValidatable;
import org.example.ProductManagable;
import org.example.ProductNameValidatable;
import org.example.VendingMachine;

import java.util.List;
import java.util.Map;

public class Admin extends User implements ProductManagable, ProductNameValidatable, PriceValidatable {
    protected VendingMachine vendingMachine;

    public Admin(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    // 재고 관리
    @Override
    public void manageStock() {
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
            int productPrice = productList.getFirst();
            int sales = productSales.get(name) * productPrice;
            System.out.println(name + ": " + sales + " won");
        }
    }

    // 상품 가격 설정
    @Override
    public void setProductPrice(String name, int price) {
        Map<String, List<Integer>> productMap = vendingMachine.productMap;

        if (validateProductName(name, vendingMachine) && validatePrice(price)) {
            List<Integer> productList = productMap.get(name);
            productList.set(0, price);
            System.out.println(name + ": " + productList.getFirst());
        } else {
            System.out.println("Invalid product name !");
        }
    }

    // 금액 검사
    @Override
    public boolean validatePrice(int price) {
        if (price > 0 || Math.log10(price)+1 > 3) {
            return true;
        } else {
            System.out.println("Enter 1000 won or more");
            return false;
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
