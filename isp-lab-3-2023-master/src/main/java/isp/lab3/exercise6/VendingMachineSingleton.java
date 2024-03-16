package isp.lab3.exercise6;

import java.util.Arrays;

public class VendingMachineSingleton {

    private static String[] products = {"Lemon", "Juice", "Oreo", "Kinder", "Cola"};

    private static final VendingMachineSingleton INSTANCE = new VendingMachineSingleton(0, products);

    private int credit;

    private VendingMachineSingleton(int credit, String[] products) {
        this.credit = credit;
        this.products = products;

    }

    public static VendingMachineSingleton getInstance() {
        return INSTANCE;
    }


    public void displayProducts() {
        System.out.println("Available products:");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ": " + products[i]);
        }
    }


    public void insertCoin(int value) {
        credit += value;
    }

    public int getCredit() {
        return credit;
    }

    public String selectProduct(int id) {
        if (id >= 1 && id <= products.length) {
            if (credit >= 1) {
                String product = products[id - 1];
                credit -= 1;
                return "Dispensing " + product;
            } else {
                return "Insufficient credit, insert coins.";
            }
        } else {
            return "Invalid product selection.";
        }
    }

    public void displayCredit() {
        System.out.println("Current credit: " + credit);
    }

    public void userMenu() {
        System.out.println("1. Products");
        System.out.println("2. Insert coin");
        System.out.println("3. Select product");
        System.out.println("4. Credit");
        System.out.println("5. Exit");
    }


    public static void main(String[] args) {


        VendingMachineSingleton vendingMachineSingleton = VendingMachineSingleton.getInstance();
        vendingMachineSingleton.userMenu();
        vendingMachineSingleton.displayProducts();
        vendingMachineSingleton.insertCoin(3);
        vendingMachineSingleton.displayCredit();
        System.out.println(vendingMachineSingleton.selectProduct(2));
        System.out.println(vendingMachineSingleton.selectProduct(4));
        System.out.println(vendingMachineSingleton.selectProduct(1));
        System.out.println(vendingMachineSingleton.selectProduct(2));


    }
}
