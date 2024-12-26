package org.example.user;

import org.example.vendingmachine.VendingMachine;

public interface ProductNameValidatable {

    boolean validateProductName(String productName, VendingMachine vendingMachine);
}
