package org.example;

public class Wallet {
    protected Type type;
    protected int balance;

    protected enum Type {
        CARD,
        CASH;
    }

    public Wallet(String type, int balance) {
        try {
            this.type = Type.valueOf(type.toUpperCase());
            this.balance = balance;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // 지갑 생성 시 타입 확인
    public static boolean initialValidation(String type) {
        try {
            Type.valueOf(type.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
