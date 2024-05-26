package isp.lab11.exercise1;

import java.util.HashMap;
import java.util.Map;

public class ATC {
    private Map<String, Aircraft> aircraftById = new HashMap<>();

    public void addAircraft(String id) {
        Aircraft aircraft = new Aircraft(id);
        aircraft.start();
        aircraftById.put(id, aircraft);

        System.out.println("Aircraft with id " + id + " added");
    }

    public void sendCommand(String id, AtcCommand command) {
        Aircraft aircraft = aircraftById.get(id);
        aircraft.receiveAtcCommand(command);
        System.out.println("Aircraft with id " + id + " received command " + command);
    }


    public void showAircrafts() {
        aircraftById.forEach((id, aircraft) -> {
            System.out.println("ID: " + id + ", State: " + aircraft.getState());
        });
    }
}

enum AtcCommand {
    TAKEOFF_CMD,
    LAND_CMD
}
