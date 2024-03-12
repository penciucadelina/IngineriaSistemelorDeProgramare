package isp.lab3.exercise5;

public class VendingMachine {

    private String[] products = {"Cola", "Chips", "Chocolate", "Pepsi"};
    private int credit;

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
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.userMenu();

        vendingMachine.displayProducts();

        vendingMachine.insertCoin(1);
        vendingMachine.insertCoin(2);
        vendingMachine.displayCredit(); //credit 3


        System.out.println(vendingMachine.selectProduct(1));
    }
}
