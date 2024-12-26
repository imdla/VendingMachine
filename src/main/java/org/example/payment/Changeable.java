package org.example.payment;

import org.example.user.Wallet;

public interface Changeable {

    void calculateChange(Wallet wallet);
}
