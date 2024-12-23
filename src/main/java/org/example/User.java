package org.example;

public abstract class User {
    protected VendingMachine vendingMachine;

    public User(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
}
