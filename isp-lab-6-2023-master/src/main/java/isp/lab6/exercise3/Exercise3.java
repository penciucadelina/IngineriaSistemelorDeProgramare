package isp.lab6.exercise3;

import java.util.Scanner;

public class Exercise3 {

    public static void main(String[] args) {
        OnlineStore store = new OnlineStore();
        LoginSystem loginSystem = new LoginSystem(store);


        loginSystem.register("user1", "password1");


        store.getProducts().add(new Product("Laptop", 999.99));
        store.getProducts().add(new Product("Smartphone", 599.99));
        store.getProducts().add(new Product("Headphones", 99.99));

        UserInterface userInterface = new UserInterface(loginSystem, store);

        userInterface.addToCart("user1", store.getProducts().get(0), 2);


        String result = userInterface.checkout("user1");

        System.out.println(result);
    }
}

