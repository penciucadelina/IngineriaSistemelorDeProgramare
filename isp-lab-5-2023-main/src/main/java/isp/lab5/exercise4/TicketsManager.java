package isp.lab5.exercise4;

public interface TicketsManager {
        boolean validateTicket(EventType eventType, String eventName);
        void generateTickets();
    }
