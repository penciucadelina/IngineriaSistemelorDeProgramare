package isp.lab5.exercise4;

import java.util.ArrayList;
import java.util.List;
public class User implements UserActions {
    public String name;
    private List<String> purchasedTickets; //bilete achizionate de user

    public User(String name) {
        purchasedTickets = new ArrayList<>();
        this.name = name;
    }

    public void buyTicket(String eventName) {
        purchasedTickets.add(eventName);
        System.out.println("Bilet achiziționat pentru evenimentul: " + eventName);
    }

    public void viewTickets() {
        System.out.println("Biletele achiziționate:");
        for (String eventName : purchasedTickets) {
            System.out.println(eventName);
        }
    }
}
