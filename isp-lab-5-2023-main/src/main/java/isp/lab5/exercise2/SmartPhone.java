package isp.lab5.exercise2;

class SmartPhone implements Chargeable {
    private int batteryLevel;

    public SmartPhone() {
        batteryLevel = 0;
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public void charge(int durationInMinutes) {
        int chargeRate = 3;
        batteryLevel = Math.min(100, batteryLevel + durationInMinutes * chargeRate);
    }
}
