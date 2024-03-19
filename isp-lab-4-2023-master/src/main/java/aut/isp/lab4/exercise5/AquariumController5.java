package aut.isp.lab4.exercise5;

import aut.isp.lab4.exercise2.FishFeeder;

public class AquariumController5 {
    private FishFeeder feeder;
    private String manufacturer;
    private String model;
    private float currentTime;
    private float feedingTime;
    private int presetTemperature;
    private float presetLevel;
    private LevelSensor lvlSensor;
    private TemperatureSensor tempSensor;
    private Actuator alarm;
    private Actuator heater;

    public AquariumController5(String manufacturer, String model, float currentTime, float feedingTime, int presetTemperature, float presetLevel,
                               LevelSensor lvlSensor, TemperatureSensor tempSensor, Actuator alarm, Actuator heater, FishFeeder feeder) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime = feedingTime;
        this.presetTemperature = presetTemperature;
        this.presetLevel = presetLevel;
        this.lvlSensor = lvlSensor;
        this.tempSensor = tempSensor;
        this.alarm = alarm;
        this.heater = heater;
        this.feeder = feeder;
    }

    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
        checkFeedingTime();
        checkTemperature();
    }

    public void setFeedingTime(float feedingTime) {
        this.feedingTime = feedingTime;
        checkFeedingTime();
    }

    public void checkFeedingTime() {
        if (currentTime == feedingTime) {
            feeder.feed();
        }
    }

    public void checkTemperature() {
        int currentTemperature = tempSensor.getValue();
        if (currentTemperature < presetTemperature) {
            heater.turnOn();
        } else if (currentTemperature == presetTemperature) {
            heater.turnOff();
        }
    }

    public void checkWaterLevel() {
        float currentLevel = lvlSensor.getValue();
        if (currentLevel < presetLevel) {
            alarm.turnOn();
        }
    }

    @Override
    public String toString() {
        return "AquariumController:" + "manufacturer=" + manufacturer + ", model=" + model +
                ", currentTime=" + currentTime +
                ", feedingTime=" + feedingTime +
                ", presetTemperature=" + presetTemperature +
                ", presetLevel=" + presetLevel +
                ", lvlSensor=" + lvlSensor +
                ", tempSensor=" + tempSensor +
                ", alarm=" + alarm +
                ", heater=" + heater;
    }
}
