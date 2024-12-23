package org.example;

public class Beverage extends Product {

    public Beverage(String name, int price, int stock) {
        super(name, price, stock, Type.BEVERAGE);
    }
}
