package org.example.product;

public abstract class Product {
    public String name;
    public int price;
    public int stock;
    public Type type;

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
