package aut.isp.lab4.exercise5;

public class LevelSensor extends Sensor {
    private float value;

    // Constructor
    public LevelSensor(String manufacturer, String model, String unitOfMeasurement) {
        super(manufacturer, model, unitOfMeasurement);
    }


    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "LevelSensor: +" + super.toString() + ", value=" + value;
    }
}
