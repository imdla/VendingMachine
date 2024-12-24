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

    // 지갑 생성
    public static Wallet makeWallet(String type, int balance){
        try {
            Type.valueOf(type.toUpperCase());
            if (balance > 0) {
                return new Wallet(type, balance);
            } else {
                System.out.println("Incorrect balance !");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect type !");
            System.out.println(e.getMessage());
        }
        return null;
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
