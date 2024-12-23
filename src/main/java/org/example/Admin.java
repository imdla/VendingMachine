package org.example;

import java.util.List;
import java.util.Map;

public class Admin extends User implements ProductManagable {

    public Admin(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    // 재고 관리
    @Override
    public void stockManagement() {
        List<Product> productList = vendingMachine.productList;
        for (Product product : productList) {
            System.out.println(product.name + ": " + product.stock);
        }
    }

    // 매출 확인
    @Override
    public void showSales() {
        Map<String, Integer> products = vendingMachine.productSales;
        int productPrice = 0;
        for (String name : products.keySet()) {
            for (Product product : vendingMachine.productList) {
                if (product.name.equals(name)) {
                    productPrice = product.price;
                }
            }

            int sales = (int) products.get(name) * productPrice;
            System.out.println(name + ": " + sales + " won");
        }
    }

    // 상품 가격 설정
    @Override
    public void setProductPrice(String name, int price) {
        List<Product> productList = vendingMachine.productList;
        boolean flag = false;

        for (Product product : productList) {
            if (product.name.equals(name)) {
                flag = true;
                product.price = price;
                System.out.println(product.name + ": " + product.price);
            }
        }

        if (!flag) {
            System.out.println("Invalid product name !");
        }
    }

}
