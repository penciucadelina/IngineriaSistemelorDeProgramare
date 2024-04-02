package isp.lab6.exercise3;

import java.util.HashMap;
import java.util.Map;

import java.util.Map;
import java.util.Scanner;

class UserInterface {
    private LoginSystem loginSyst;
    private OnlineStore store;
    private Map<String, ActiveSession> sessions;

    public UserInterface(LoginSystem loginSyst, OnlineStore store) {
        this.loginSyst = loginSyst;
        this.store = store;
        this.sessions = new HashMap<>();
    }

    public void addToCart(String username, Product product, int quantity) {
        if (!loginSyst.getSessions().containsKey(username)) {
            loginSyst.addSession(username);
        }
        loginSyst.getSessions().get(username).addToCart(product, quantity);
    }

    public String checkout(String username) {
        if (loginSyst.getSessions().containsKey(username)) {
            return "Checkout successful!";
        } else {
            return "User not logged in!";
        }
    }
}