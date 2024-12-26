package org.example.vendingmachine;

public interface Updatable {

    void updateStock(String productName);

    void updateSales(String productName);
}
