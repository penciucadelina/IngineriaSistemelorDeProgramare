package exercise5;

import aut.isp.lab4.exercise2.FishFeeder;
import aut.isp.lab4.exercise5.*;
import org.junit.Assert;
import org.junit.Test;

public class AquariumControllerTest {
    @Test
    public void testChecks() {
        FishFeeder fishFeeder = new FishFeeder("A40", "Pro");
        Sensor sensor = new Sensor("Samsung", "S10", "L/gC");
        LevelSensor levelSensor = new LevelSensor("Apple", "Pro", "L", 18.0F);
        TemperatureSensor temperatureSensor = new TemperatureSensor("Temperature", "Pro", "grade C", 10);
        Actuator actuator = new Actuator("Apple", "Pro", false);
        Alarm alarm = new Alarm("Samsung", "Alarm", false);
        Heater heater = new Heater("Nokia", "Heater", false);
        AquariumController aquariumController = new AquariumController(fishFeeder, "Samsung", "Pro",
                30, 20.0F, levelSensor, temperatureSensor, alarm, heater);

        aquariumController.checkTemperature();
        Assert.assertTrue(heater.getisOn());

        temperatureSensor.setValue(30);
        aquariumController.checkTemperature();
        Assert.assertFalse(heater.getisOn());

        temperatureSensor.setValue(30);
        aquariumController.checkTemperature();
        Assert.assertFalse(heater.getisOn());

        aquariumController.checkWaterLevel();
        Assert.assertTrue(alarm.getisOn());

        levelSensor.setValue(21);
        aquariumController.checkWaterLevel();
        Assert.assertFalse(alarm.getisOn());

    }
}