package aut.isp.lab4.exercise3;

import aut.isp.lab4.exercise2.FishFeeder;

public class AquariumControllerAg {

    private String manufacturer;
    private String model;
    private float currentTime;
    private FishFeeder feeder; // Aggregation
    private float feedingTime;


    // Constructor
    public AquariumControllerAg(String manufacturer, String model, float currentTime, float feedingTime, FishFeeder feeder) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime = feedingTime;
        this.feeder = feeder;
    }


    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
        checkFeedingTime();
    }

    private void checkFeedingTime() {
        if (currentTime == feedingTime) {
            feeder.feed();
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
        return "manufacturer=" + manufacturer + ", model=" + model + ", currentTime=" + currentTime + ", feedingTime=" + feedingTime + ", feeder=" + getFishFeeder();
    }
}
