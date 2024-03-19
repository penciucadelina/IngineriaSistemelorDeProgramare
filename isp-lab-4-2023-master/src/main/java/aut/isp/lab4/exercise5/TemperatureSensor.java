package aut.isp.lab4.exercise5;

public class TemperatureSensor extends Sensor {
    private int value;

    // Constructor
    public TemperatureSensor(String manufacturer, String model, String unitOfMeasurement) {
        super(manufacturer, model, unitOfMeasurement);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // toString() method to represent object as a String
    @Override
    public String toString() {
        return "TemperatureSensor: " + super.toString() + ", value=" + value;
    }
}
