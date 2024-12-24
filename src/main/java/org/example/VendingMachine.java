package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    public Map<String, List<Integer>> productMap;
    public Map<String, Integer> productSales;

    public VendingMachine() {
        this.productMap = new HashMap<>();
        this.productSales = new HashMap<>();
    }

    // 제품 추가
    public Map<String, List<Integer>> putProduct(Product product) {
        List<Integer> productList = new ArrayList<>();
        productList.add(product.price);
        productList.add(product.stock);

        productMap.put(product.name, productList);
        productSales.put(product.name, 0);
        return productMap;
    }

    // 결제
    public void pay(String productName, Wallet wallet) {
        String paymentType = String.valueOf(wallet.type);
        Paymentable paymentable = null;

        // 금액 및 재고 확인, 재고 업데이트
        List<Integer> productList = productMap.get(productName);
        int productPrice = productList.getFirst();
        int productStock = productList.getLast();
        productStock = productStock - 1;

        // 결제
        switch (paymentType) {
            case "CASH":
                paymentable = new CashPayment();
                break;
            case "CARD":
                paymentable = new CardPayment();
                break;
        }
        paymentable.pay(wallet, productPrice);

        // 매출 업데이트
        int amount = productSales.getOrDefault(productName, 0);
        productSales.put(productName, amount + 1);
    }
}
