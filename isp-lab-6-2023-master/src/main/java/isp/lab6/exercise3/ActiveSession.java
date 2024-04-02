package isp.lab6.exercise3;

import java.util.HashMap;
import java.util.Map;

class ActiveSession {
    private String username;
    private Map<Product, Integer> shoppingCart;

    public ActiveSession(String username) {
        this.username = username;
        this.shoppingCart = new HashMap<>();
    }

    public void addToCart(Product product, int quantity) {
        shoppingCart.put(product, quantity);
    }

    public Map<Product, Integer> getShoppingCart() {
        return shoppingCart;
    }
}