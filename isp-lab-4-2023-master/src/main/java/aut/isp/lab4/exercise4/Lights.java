package aut.isp.lab4.exercise4;

public class Lights {
    private boolean isOn;

    public Lights(boolean isOn) {
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        this.isOn = true;
        System.out.println("The lights are ON!");
    }

    public void turnOff() {
        this.isOn = false;
        System.out.println("The lights are OFF!");
    }
}