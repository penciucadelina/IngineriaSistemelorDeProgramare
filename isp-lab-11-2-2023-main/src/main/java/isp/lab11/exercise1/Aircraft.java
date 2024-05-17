package isp.lab11.exercise1;

public class Aircraft implements Runnable {

    private String id;
    private String lock = "lock";
    private AircraftState state;
    private int k = 0;

    public Aircraft(String id) {
        this.id = id;
        this.state = AircraftState.ON_STAND;
        FileUtils.writeMessageToFile(this.id, "Aircraft " + id + " is created. Ready to take off.");
    }

    public AircraftState getState() {
        return state;
    }

    public void start() {
        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        try {
            // aircraft is on stand
            synchronized (lock) {
                lock.wait();
            }

            // aircraft is taxing
            FileUtils.writeMessageToFile(this.id, "Aircraft " + id + " is taxing.");
            Thread.sleep(10000);

            // aircraft is taking off
            this.state = AircraftState.TAKING_OFF;
            FileUtils.writeMessageToFile(this.id, "Aircraft " + id + " is taking off.");
            Thread.sleep(5000);

            // TODO implement the rest

        } catch (InterruptedException ignored) {
        }
    }

    public void receiveAtcCommand(AtcCommand cmd) {
        if (this.state.equals(AircraftState.ON_STAND) && cmd.equals(AtcCommand.TAKEOFF_CMD)) {
            this.state = AircraftState.TAXING;

            synchronized (lock) {
                lock.notify();
            }
        } else if (this.state.equals(AircraftState.CRUISING) && cmd.equals(AtcCommand.LAND_CMD)) {
            this.state = AircraftState.DESCENDING;

            synchronized (lock) {
                lock.notify();
            }
        }

    }


    enum AircraftState {
        ON_STAND,
        TAXING,
        TAKING_OFF,
        ASCENDING,
        CRUISING,
        DESCENDING,
        LANDED
    }
}
