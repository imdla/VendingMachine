package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    public List<Product> productList;
    public Map<String, Integer> productSales;

    public VendingMachine() {
        this.productList = new ArrayList<>();
        this.productSales = new HashMap<>();
    }

    // 제품 추가
    public List<Product> addProduct(Product product) {
        productList.add(product);
        productSales.put(product.name, 0);
        return productList;
    }

    // 결제 -> productSales integer 업데이트
    public void pay(String productName, String paymentType) {
        Paymentable paymentable = null;

        // 결제
        switch (paymentType) {
            case "cash":
                paymentable = new CashPayment();
                break;
            case "card":
//                paymentable = new CardPayment();
                break;
        }
        paymentable.pay();

        // 매출 업데이트
        int amount = productSales.getOrDefault(productName, 0);
        productSales.put(productName, amount + 1);
    }
}
