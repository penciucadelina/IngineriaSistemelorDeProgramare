package isp.lab11.exercise1;

public class Aircraft implements Runnable {

    private String id;
    private String lock = "lock";
    private AircraftState state;
    private int cruisingAltitude = 3;
    private int cruisingTime = 0;

    public int getCruisingAltitude() {
        return cruisingAltitude;
    }

    public Aircraft(String id) {
        this.id = id;
        this.state = AircraftState.ON_STAND;
        FileUtils.writeMessageToFile(this.id, "Aircraft " + id + " is created. Ready to take off.");
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

            this.state = AircraftState.ASCENDING;
            FileUtils.writeMessageToFile(this.id, "Aircraft " + id + " is ascending.");
            for (int i = 0; i < cruisingAltitude; i++) {
                Thread.sleep(10000);
                FileUtils.writeMessageToFile(this.id, "Aircraft " + id + " has reached altitude of " + i * 1000 + " meters.");
            }
            FileUtils.writeMessageToFile(this.id, "Aircraft " + id + " has reached cruising altitude of " + (cruisingAltitude * 1000) + " meters.");

            // Aircraft is cruising
            this.state = AircraftState.CRUISING;
            FileUtils.writeMessageToFile(this.id, "Aircraft " + id + " is cruising.");
            long cruisingStartTime = System.currentTimeMillis();

            synchronized (lock) {
                lock.wait();
            }
            cruisingTime += (int) ((System.currentTimeMillis() - cruisingStartTime) / 1000);

            // Aircraft is descending
            FileUtils.writeMessageToFile(this.id, "Aircraft " + id + " is descending.");
            for (int i = cruisingAltitude; i > 0; i--) {
                FileUtils.writeMessageToFile(this.id, "Aircraft " + id + " has reached altitude of " + i * 1000 + " meters.");
                Thread.sleep(10000);
            }
            FileUtils.writeMessageToFile(this.id, "Aircraft " + id + " has reached altitude of 0 meters.");

            // Aircraft has landed
            this.state = AircraftState.LANDED;
            FileUtils.writeMessageToFile(this.id, "Aircraft " + id + " has landed. Total cruising time: " + cruisingTime + " seconds.");

        }
        catch (InterruptedException ignored) {
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

    public AircraftState getState() {
        return state;
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
