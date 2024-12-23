package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    public List<Product> productList;
    public Map<Product, Integer> productSales;

    public VendingMachine() {
        this.productList = new ArrayList<>();
        this.productSales = new HashMap<>();
    }

    // 제품 추가
    public List<Product> addProduct(Product product) {
        productList.add(product);
        return productList;
    }

    // 결제 -> productSales integer(금액) 업데이트
}
