package isp.lab5.exercise4;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {

        TicketManager ticketManager = new TicketManager();
        ticketManager.generateTickets();

        User user = new User("George");
        

        PaymentGateway paymentGateway = new SimplePaymentGateway();

        UserApp userApp = new UserApp(user, ticketManager, paymentGateway);


        double paymentAmount = 60.0;
        userApp.buyTicket(EventType.CONCERT, "Concert rock", paymentAmount);
        userApp.viewTickets();


        Organiser organiser = new Organiser();
        OrganiserApp organiserApp = new OrganiserApp(organiser);

        organiserApp.scanTicket(EventType.CONCERT, "Concert rock");

        EventType eventType1 = EventType.CONCERT;


        boolean isConcertValid = ticketManager.validateTicket(eventType1, "Concert rock");

        System.out.println("Validitatea biletului pentru concert: " + isConcertValid);
    }
}








