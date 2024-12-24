package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
//    public List<Product> productList;
    public Map<String, List<Integer>> productList;
    public Map<String, Integer> productSales;

    public VendingMachine() {
//        this.productList = new ArrayList<>();
        this.productList = new HashMap<>();
        this.productSales = new HashMap<>();
    }

//    // 제품 추가
//    public List<Product> addProduct(Product product) {
//        productList.add(product);
//        productSales.put(product.name, 0);
//        return productList;
//    }
//
//    // 결제
//    public void pay(String productName, Wallet wallet) {
//        String paymentType = String.valueOf(wallet.type);
//        Paymentable paymentable = null;
//        int productPrice = 0;
//
//        for (Product product : productList) {
//            if (product.name.equals(productName)) {
//                productPrice = product.price;
//            }
//        }
//
//        // 결제
//        switch (paymentType) {
//            case "CASH":
//                paymentable = new CashPayment();
//                break;
//            case "CARD":
//                paymentable = new CardPayment();
//                break;
//        }
//        paymentable.pay(wallet, productPrice);
//
//        // 재고 업데이트
//        for (Product product : productList) {
//            if (product.name.equals(productName)) {
//                product.stock = product.stock - 1;
//            }
//        }
//
//        // 매출 업데이트
//        int amount = productSales.getOrDefault(productName, 0);
//        productSales.put(productName, amount + 1);
//    }
//
//    // 제품명 검사
//    public boolean validationProductName(String productName) {
//        for (Product product : productList) {
//            if (product.name.equals(productName)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
