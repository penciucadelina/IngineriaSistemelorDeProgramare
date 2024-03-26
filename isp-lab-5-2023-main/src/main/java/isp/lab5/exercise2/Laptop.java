package isp.lab5.exercise2;

class Laptop implements Chargeable {
    private int batteryLevel;

    public Laptop() {
        batteryLevel = 0;
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public void charge(int durationInMinutes) {
        int chargeRate = 2;
        batteryLevel = Math.min(100, batteryLevel + durationInMinutes * chargeRate);
    }
}