package aut.isp.lab4.exercise2;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FishFeederTest {

    @Test
    public void testFillUp() {
        FishFeeder feeder = new FishFeeder("Test Manufacturer", "Test Model");
        feeder.fillUp();
        assertEquals(14, feeder.getMeals());
    }


    @Test
    public void testFeed() {
        FishFeeder feeder = new FishFeeder("Test Manufacturer", "Test Model");
        feeder.fillUp();
        feeder.feed();
        assertEquals(13, feeder.getMeals());
    }

    @Test
    public void testToString() {
        FishFeeder feeder = new FishFeeder("Test Manufacturer", "Test Model");
        String expected = "FishFeeder: manufacturer=Test Manufacturer, model=Test Model, meals=0";
        assertEquals(expected, feeder.toString());
    }
}