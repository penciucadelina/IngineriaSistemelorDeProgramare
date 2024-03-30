package isp.lab5.exercise4;

public class UserApp {
    private UserActions user;
    private TicketsManager ticketsManager;

    private PaymentGateway paymentGateway;

    public UserApp(UserActions user, TicketsManager ticketsManager) {
        this.user = user;
        this.ticketsManager = ticketsManager;
    }

    public UserApp(UserActions user, TicketsManager ticketsManager, PaymentGateway paymentGateway) {
        this.user = user;
        this.ticketsManager = ticketsManager;
        this.paymentGateway = paymentGateway;
    }

    // metoda pentru achiziționarea biletelor
    public void buyTicket(EventType eventType, String eventName, double amount) {
        if (ticketsManager.validateTicket(eventType, eventName)) {
            if (paymentGateway.processPayment(amount)) {
                user.buyTicket(eventName);
            } else {
                System.out.println("Plata a eșuat.");
            }
        } else {
            System.out.println("Biletul nu este disponibil.");
        }
    }


    // metoda pentru vizualizarea biletelor
    public void viewTickets() {
        user.viewTickets();
    }


}
