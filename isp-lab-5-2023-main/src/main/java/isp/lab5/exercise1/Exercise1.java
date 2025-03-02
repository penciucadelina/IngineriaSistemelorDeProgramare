package isp.lab5.exercise1;

import java.time.LocalDateTime;

public class Exercise1 {

    public static void main(String[] args) {
        Address address1 = new Address("2nd Long Str.", "New-York");

        Customer customer1 = new Customer("custOO7", "James B.", "007-007-007");
        customer1.setAddress(address1); //asociere

        Product product1 = new Product("prod1", "best shampoo", 250, ProductCategory.BEAUTY);
        Product product2 = new Product("prod2", "screwdriver", 15, ProductCategory.HOME_AND_GARDEN);
        Product product3 = new Product("prod3", "teddy bear", 60, ProductCategory.TOYS);

        Order order1 = new Order("order123", LocalDateTime.now(), 0);
        order1.setCustomer(customer1);
        order1.addProduct(product1);
        order1.addProduct(product3);

        Order order2 = new Order("order223", LocalDateTime.now(), 0);
        order2.setCustomer(customer1);
        order2.addProduct(product2);

        System.out.println(order1);
        System.out.println(order2);

        ProductCategory productCategory1=ProductCategory.valueOf("HOME_AND_GARDEN");
        System.out.println(productCategory1);
        System.out.println(productCategory1.compareTo(ProductCategory.TOYS));
        System.out.println(productCategory1.ordinal());
        System.out.println(productCategory1.name());
    }
}


