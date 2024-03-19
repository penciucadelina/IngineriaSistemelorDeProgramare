package aut.isp.lab4.exercise4;

import aut.isp.lab4.exercise2.FishFeeder;

public class AquariumControllerL {

    private String manufacturer;
    private String model;
    private float currentTime;
    private FishFeeder feeder; // Agregare
    private float feedingTime;

    private float lightOnTime;
    private float lightsOffTime;


    // Constructor
    public AquariumControllerL(String manufacturer, String model, float currentTime, float feedingTime, float lightOnTime, float lightsOffTime, FishFeeder feeder) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime = feedingTime;
        this.lightOnTime = lightOnTime;
        this.lightsOffTime = lightsOffTime;
        this.feeder = feeder;
    }


    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
        checkFeedingTime();
        controlLights();
    }

    private void checkFeedingTime() {
        if (currentTime == feedingTime) {
            feeder.feed();
        }
    }

    private void controlLights() {
        if (currentTime >= lightOnTime && currentTime < lightsOffTime) {
            System.out.println("Turning lights on.");
        } else {
            System.out.println("Turning lights off.");
        }
    }

    public void setFeedingTime(float feedingTime) {
        this.feedingTime = feedingTime;
        checkFeedingTime();
    }

    public float getFeedingTime() {
        return feedingTime;
    }

    public float getCurrentTime() {
        return currentTime;
    }

    public FishFeeder getFishFeeder() {
        return feeder;
    }

    @Override
    public String toString() {
        return "manufacturer=" + manufacturer + ", model=" + model + ", currentTime=" + currentTime + ", feedingTime=" + feedingTime + ", feeder=" + getFishFeeder() + ", lightOnTime=" + lightOnTime +
                ", lightsOffTime=" + lightsOffTime;
    }
}
