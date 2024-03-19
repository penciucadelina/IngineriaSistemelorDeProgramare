package aut.isp.lab4.exercise3;

import aut.isp.lab4.exercise2.FishFeeder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AquariumControllerAgTest {

    @Test
    public void testSetCurrentTime() {
        AquariumControllerAg controller = new AquariumControllerAg("Test Manufacturer", "Test Model", 0.0f, 0.0f, new FishFeeder("Test Feeder Manufacturer", "Test Feeder Model"));
        controller.setCurrentTime(5.5f);
        assertEquals(5.5f, controller.getCurrentTime(), 0.001f); // Delta value used for floating-point comparison
    }

    @Test
    public void testSetFeedingTime() {
        AquariumControllerAg controller = new AquariumControllerAg("Test Manufacturer", "Test Model", 0.0f, 0.0f, new FishFeeder("Test Feeder Manufacturer", "Test Feeder Model"));
        controller.setFeedingTime(12.0f);
        assertEquals(12.0f, controller.getFeedingTime(), 0.001f); // Delta value used for floating-point comparison
    }

    @Test
    public void testToString() {
        FishFeeder feeder = new FishFeeder("Test Feeder Manufacturer", "Test Feeder Model");
        AquariumControllerAg controller = new AquariumControllerAg("Test Manufacturer", "Test Model", 0.0f, 0.0f, feeder);
        String expected = "manufacturer=Test Manufacturer, model=Test Model, currentTime=0.0, feedingTime=0.0, feeder=" + feeder.toString();
        assertEquals(expected, controller.toString());
    }
}