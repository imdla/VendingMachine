package org.example;

public class Wallet {
    protected Type type;
    protected int balance;

    protected enum Type {
        CARD,
        CASH;
    }

    public Wallet(String type, int balance) {
        this.type = Type.valueOf(type.toUpperCase());
        this.balance = balance;
    }
}
