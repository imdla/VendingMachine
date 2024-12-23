package org.example;

public interface ProductManagable {
    // 재고 관리
    void stockManagement();

    // 매출 확인
    void showSales();

    // 상품 가격 설정
    void setProductPrice(int price);
}
