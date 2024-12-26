package org.example.vendingmachine;

import org.example.user.Wallet;

public interface ProductMinPriceValidatable {

    boolean validateProductMinPrice(Wallet wallet);
}
