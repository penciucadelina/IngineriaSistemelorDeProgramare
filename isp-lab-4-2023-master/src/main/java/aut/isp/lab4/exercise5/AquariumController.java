package aut.isp.lab4.exercise5;

import aut.isp.lab4.exercise2.FishFeeder;

public class AquariumController {
    private FishFeeder feeder;
    private String manufacturer;
    private String model;
    private float currentTime;
    private float feedingTime;
    private int presetTemperature;
    private float presetLevel;
    private LevelSensor lvlSensor;
    private TemperatureSensor tempSensor;
    private Alarm alarm;
    private Heater heater;


    public AquariumController(FishFeeder feeder, String manufacturer, String model,
                              int presetTemperature, float presetLevel, LevelSensor lvlSensor,
                              TemperatureSensor tempSensor, Alarm alarm, Heater heater) {
        this.feeder = feeder;
        this.manufacturer = manufacturer;
        this.model = model;
        this.presetTemperature = presetTemperature;
        this.presetLevel = presetLevel;
        this.lvlSensor = lvlSensor;
        this.tempSensor = tempSensor;
        this.alarm = alarm;
        this.heater = heater;
    }

    public void setFeedingTime(float feedingTime) {
        this.feedingTime = feedingTime;
    }

    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
        if (this.currentTime == this.feedingTime) {
            feeder.feed();
        } else {
            System.out.println("It's not feeding time");
        }
    }

    public void checkTemperature() {
        int currentTemperature = tempSensor.getValue();
        System.out.println("Temperature is: " + tempSensor.getValue());
        if (currentTemperature < presetTemperature) {
            heater.turnOn();
        } else if (currentTemperature == presetTemperature) {
            heater.turnOff();
        } else {
            heater.turnOff();
        }
    }

    public void checkWaterLevel() {
        float currentLevel = lvlSensor.getValue();
        System.out.println("Water level  is: " + lvlSensor.getValue());
        if (currentLevel < presetLevel) {
            alarm.turnOn();
        } else {
            alarm.turnOff();
        }
    }

    @Override
    public String toString() {
        return "AquariumController{" +
                "feeder=" + feeder +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", currentTime=" + currentTime +
                ", feedingTime=" + feedingTime +
                ", presetTemperature=" + presetTemperature +
                ", presetLevel=" + presetLevel +
                ", lvlSensor=" + lvlSensor +
                ", tempSensor=" + tempSensor +
                ", alarm=" + alarm +
                ", heater=" + heater +
                '}';
    }
}
