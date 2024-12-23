package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String word1 = scanner.next();
//        System.out.println(word1);

        // 제품 추가
        Product coke = new Beverage("coke", 1000, 10);
        Product milk = new Beverage("milk", 2000, 5);
        Product coffee = new Beverage("coffee", 3000, 15);
        Product candy = new EtcProduct("candy", 500, 10);
        Product snack = new EtcProduct("snack", 2000, 20);
        Product popcorn = new EtcProduct("popcorn", 3000, 10);

        VendingMachine vm = new VendingMachine();
        vm.addProduct(coke);
        vm.addProduct(milk);
        vm.addProduct(coffee);
        vm.addProduct(candy);
        vm.addProduct(snack);
        vm.addProduct(popcorn);

        // 고객 구매
        Wallet wallet = new Wallet("card", 10000);
        Customer customer = new Customer(vm, wallet);

        customer.buy("coke");
    }
}