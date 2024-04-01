package aut.isp.lab4.exercise5;

public class LevelSensor extends Sensor {
    private float value;

    public LevelSensor(String manufacturer, String model, String unitOfMeasurement, float value) {
        super(manufacturer, model, unitOfMeasurement);
        this.value = value;
    }

    public LevelSensor(float value) {
        this.value = value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "LevelSensor{" +
                "value=" + value +
                '}';
    }


}
