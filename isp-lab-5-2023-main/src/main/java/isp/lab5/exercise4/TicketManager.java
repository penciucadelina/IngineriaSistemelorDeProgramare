package isp.lab5.exercise4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketManager implements TicketsManager {
    private Map<EventType, List<String>> availableTickets;

    public TicketManager() {
        availableTickets = new HashMap<>();
    }


    // metoda pentru validarea biletelor
    public boolean validateTicket(EventType eventType, String eventName) {
        List<String> tickets = availableTickets.get(eventType);
        return tickets != null && tickets.contains(eventName);
    }

    // metoda pentru generarea biletelor
    public void generateTickets() {
        // bilete pentru fiecare tip de eveniment
        availableTickets.put(EventType.CONCERT, Arrays.asList("Concert rock", "Concert jazz"));
        availableTickets.put(EventType.THEATER, Arrays.asList("Piesă de teatru", "Comedie"));
        availableTickets.put(EventType.WORKSHOP, Arrays.asList("Curs de programare", "Atelier de artă"));
    }

}