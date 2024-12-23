package org.example;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    public List<Product> productList;

    public VendingMachine() {
        this.productList = new ArrayList<>();
    }

    // 제품 추가
    public List<Product> addProduct(Product product) {
        productList.add(product);
        return productList;
    }
}
