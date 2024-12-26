package org.example;

import org.example.product.Beverage;
import org.example.product.EtcProduct;
import org.example.product.Product;
import org.example.user.Admin;
import org.example.user.Customer;
import org.example.user.Wallet;
import org.example.vendingmachine.VendingMachine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 제품 추가
        Product coke = new Beverage("coke", 1000, 10);
        Product milk = new Beverage("milk", 2000, 5);
        Product coffee = new Beverage("coffee", 3000, 15);
        Product candy = new EtcProduct("candy", 1000, 10);
        Product snack = new EtcProduct("snack", 2000, 20);
        Product popcorn = new EtcProduct("popcorn", 3000, 10);

        VendingMachine vm = new VendingMachine();
        vm.putProduct(coke);
        vm.putProduct(milk);
        vm.putProduct(coffee);
        vm.putProduct(candy);
        vm.putProduct(snack);
        vm.putProduct(popcorn);

        /// ////////////////////////////////////////////////////////////////////////////
        // 고객
        // 1. 지갑 생성
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the method of payment? (card / cash)");
        String type = scanner.next();
        System.out.println("How much balance do you have? (Exceeded 0)");
        int balance = scanner.nextInt();
        Wallet wallet = Wallet.makeWallet(type, balance);

        // 1-2. 지갑 생성 검사
//        Wallet wallet = null;
//        if (Wallet.initialValidationType(type, balance)) {
//            wallet = new Wallet(type, balance);
//        } else {
//            System.out.println("Incorrect type or balance !");
//        }

        // 2. 고객 생성
        Customer customer = new Customer(wallet);

        // 3. 상품 구매
        System.out.println();
        customer.use(vm);

        // 관리자
        // 1. 재고 관리
        System.out.println();
        Admin admin = new Admin(vm);
        admin.manageStock();

        // 2. 매출 확인
        System.out.println();
        admin.showSales();

        // 3. 상품 가격 설정
        System.out.println();
        admin.setProductPrice("coke", 100);
    }
}