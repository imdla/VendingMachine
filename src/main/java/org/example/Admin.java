package org.example;

import java.util.List;

public class Admin extends User implements ProductManagable {
    protected VendingMachine vendingMachine;

    public Admin(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
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

    }

    // 상품 가격 설정
    @Override
    public void setProductPrice(int price) {

    }

}
