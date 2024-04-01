package aut.isp.lab4.exercise5;

public class TemperatureSensor extends Sensor {
    private int value;


    public TemperatureSensor(String manufacturer, String model, String unitOfMeasurement, int value) {
        super(manufacturer, model, unitOfMeasurement);
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "TemperatureSensor{" +
                "value=" + value +
                '}';
    }
}