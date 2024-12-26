package org.example;

import org.example.user.Wallet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine implements Updatable, stockCheckable {
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

        List<Integer> productList = productMap.get(productName);
        int productPrice = productList.getFirst();

        // 재고 조회
        if (checkStock(productName)) {
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

            // 재고 업데이트
            updateStock(productName);
            // 매출 업데이트
            updateSales(productName);
        } else {
            System.out.println("Out of stock !");
        }
    }

    // 재고 조회
    @Override
    public boolean checkStock(String productName) {
        List<Integer> productList = productMap.get(productName);
        int productStock = productList.getLast();

        if (productStock > 0) {
            return true;
        } else {
            return false;
        }
    }

    // 재고 업데이트
    @Override
    public void updateStock(String productName) {
        List<Integer> productList = productMap.get(productName);
        productList.set(1, productList.get(1)-1);
    }

    // 매출 업데이트
    @Override
    public void updateSales(String productName) {
        int amount = productSales.getOrDefault(productName, 0);
        productSales.put(productName, amount + 1);
    }
}
