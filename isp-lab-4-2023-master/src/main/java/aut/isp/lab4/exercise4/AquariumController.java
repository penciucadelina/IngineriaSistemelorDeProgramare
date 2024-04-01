package aut.isp.lab4.exercise4;

import aut.isp.lab4.exercise2.FishFeeder;

public class AquariumController {

    private FishFeeder feeder;
    private final String manufacturer;
    private final String model;
    private float currentTime;
    private float feedingTime;
    private float lightOnTime;
    private float lightOffTime;
    private Lights lights;

    public AquariumController(FishFeeder feeder, String manufacturer, String model, Lights lights) {
        this.feeder = feeder;
        this.manufacturer = manufacturer;
        this.model = model;
        this.lights = lights;
    }

    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
        if (this.currentTime == this.feedingTime) {
            feeder.feed();
        } else {
            System.out.println("It's not feeding time!");
        }

        if (currentTime >= lightOnTime && currentTime < lightOffTime) {
            if (!lights.isOn()) {
                lights.turnOn();
            }
        } else {
            if (lights.isOn()) {
                lights.turnOff();
            }
        }
    }

    public void setLightOnTime(float lightOnTime) {
        this.lightOnTime = lightOnTime;
    }

    public void setLightOffTime(float lightOffTime) {
        this.lightOffTime = lightOffTime;
    }

    public float getCurrentTime() {
        return currentTime;
    }

    public void setFeedingTime(float feedingTime) {
        this.feedingTime = feedingTime;
    }

    public float getFeedingTime() {
        return feedingTime;
    }

    public float getLightOnTime() {
        return lightOnTime;
    }

    public float getLightOffTime() {
        return lightOffTime;
    }

    @Override
    public String toString() {
        return "AquariumController{" +
                "feeder=" + feeder +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", currentTime=" + currentTime +
                ", feedingTime=" + feedingTime +
                ", lightOnTime=" + lightOnTime +
                ", lightOffTime=" + lightOffTime +
                "," + " Lights state: " + (lights.isOn() ? "On" : "Off") +
                '}';
    }
}