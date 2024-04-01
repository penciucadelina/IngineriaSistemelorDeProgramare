package aut.isp.lab4.exercise5;


public class Heater extends Actuator {

    public Heater(String manufacturer, String model, boolean isOn) {
        super(manufacturer, model, isOn);
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println("The heater is ON");
    }

    @Override
    public void turnOff() {
        super.turnOff();
        System.out.println("The heater is OFF");
    }

}

