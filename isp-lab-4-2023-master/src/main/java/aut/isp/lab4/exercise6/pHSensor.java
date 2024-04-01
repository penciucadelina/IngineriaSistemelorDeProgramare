package aut.isp.lab4.exercise6;

import aut.isp.lab4.exercise5.Sensor;

public class pHSensor extends Sensor {
    private float value;
    private float lowerLimit;
    private float upperLimit;

    public pHSensor(String manufacturer, String model, String unitOfMeasurement, float lowerLimit, float upperLimit) {
        super(manufacturer, model, unitOfMeasurement);
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public float getLowerLimit() {
        return lowerLimit;
    }

    public float getUpperLimit() {
        return upperLimit;
    }

    @Override
    public String toString() {
        return "pHSensor{" +
                "value=" + value +
                ", lowerLimit=" + lowerLimit +
                ", upperLimit=" + upperLimit +
                '}';
    }
}