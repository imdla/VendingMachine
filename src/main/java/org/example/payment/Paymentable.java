package org.example.payment;

import org.example.user.Wallet;

public interface Paymentable {

    void pay(Wallet wallet, int productPrice);
}