package aut.isp.lab4.exercise5;

public class Actuator {
    private String manufacturer;
    private String model;

    // Constructor
    public Actuator(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public void turnOn() {
        System.out.println("Turning on " + manufacturer + " " + model);
    }

    public void turnOff() {
        System.out.println("Turning off " + manufacturer + " " + model);
    }


    @Override
    public String toString() {
        return "Actuator: " + "manufacturer=" + manufacturer + ", model='" + model;
    }
}
