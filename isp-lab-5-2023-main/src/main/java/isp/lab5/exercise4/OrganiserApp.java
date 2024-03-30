package isp.lab5.exercise4;

public class OrganiserApp {
    private OrganiserActions organiser;
    private TicketsManager ticketsManager;
    private UserApp userApp;


    public OrganiserApp(OrganiserActions organiser) {
        this.organiser = organiser;
    }

    public OrganiserApp(OrganiserActions organiser, TicketsManager ticketsManager, UserApp userApp) {
        this.organiser = organiser;
        this.ticketsManager = ticketsManager;
        this.userApp = userApp;
    }

    // metoda pentru check-in
    public void checkIn(String eventName) {
        organiser.checkIn(eventName);
    }

    //metoda pt scan
    public void scanTicket(EventType eventType, String eventName) {
        if (userApp != null) {
            organiser.checkIn(eventName);  //verificare bilet
        }
    }

}
