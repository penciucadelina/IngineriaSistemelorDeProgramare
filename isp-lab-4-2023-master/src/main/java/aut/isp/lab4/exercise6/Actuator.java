package aut.isp.lab4.exercise6;


public class Actuator {
    private String manufacturer;
    private String model;
    private boolean isOn;

    public Actuator(String manufacturer, String model, boolean isOn) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.isOn = isOn;
    }

    public void turnOn() {
        this.isOn = true;
    }

    public void turnOff() {
        this.isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public String toString() {
        return "Actuator{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", isOn=" + isOn +
                '}';
    }
}