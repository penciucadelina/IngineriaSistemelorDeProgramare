package aut.isp.lab4.exercise6;


public class Alarm extends Actuator {

    public Alarm(String manufacturer, String model, boolean isOn) {
        super(manufacturer, model, isOn);
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println("The alarm is ON");
    }

    @Override
    public void turnOff() {
        super.turnOff();
        System.out.println("The alarm is OFF");
    }
}