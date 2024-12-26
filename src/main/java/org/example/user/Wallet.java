package org.example.user;

public class Wallet {
    public Type type;
    public int balance;

    public enum Type {
        CARD,
        CASH;
    }

    public Wallet(String type, int balance) {
        this.type = Type.valueOf(type.toUpperCase());
        this.balance = balance;
    }

    // 지갑 생성
    public static Wallet makeWallet(String type, int balance){
        try {
            Type.valueOf(type.toUpperCase());
            if (balance > 0) {
                return new Wallet(type, balance);
            } else {
                System.out.println("Your basic balance is 10,000won !");
                return new Wallet(type, 10000);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Your basic payment method is cash !");
        }
        return new Wallet("cash", balance);
    }

    // 지갑 생성 시 타입 확인
//    public static boolean initialValidationType(String type, int balance) {
//        try {
//            Type.valueOf(type.toUpperCase());
//            if (balance > 0) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (IllegalArgumentException e) {
//            return false;
//        }
//    }
}
