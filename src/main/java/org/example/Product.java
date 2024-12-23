package org.example;

public abstract class Product {
    protected String name;
    protected int price;
    protected int stock;
    protected Type type;

    protected enum Type {
        BEVERAGE,
        ETC;
    }

    public Product(String name, int price, int stock, Type type) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.type = type;
    }
}
