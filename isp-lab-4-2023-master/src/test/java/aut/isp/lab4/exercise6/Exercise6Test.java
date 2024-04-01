package aut.isp.lab4.exercise6;

import aut.isp.lab4.exercise5.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class Exercise6Test {

    @Test
    public void testpHSensor() {
        pHSensor pH = new pHSensor("Acme", "Model 1", "pH", 6.5F, 7.5F);
        assertEquals(6.5F, pH.getLowerLimit(), 0.001);
        assertEquals(7.5F, pH.getUpperLimit(), 0.001);

        pH.setValue(7.0F);
        assertEquals(7.0F, pH.getValue(), 0.001);
    }

    @Test
    public void testAquariumController() {
        LevelSensor levelSensor = new LevelSensor("Apple", "Pro", "L", 18.0F);
        TemperatureSensor temperatureSensor = new TemperatureSensor("Temperature", "Pro", "grade C", 10);
        pHSensor pHSensor = new pHSensor("Acme", "Model 1", "pH", 6.5F, 7.5F);
        Alarm alarm = new Alarm("Samsung", "Alarm", false);
        Actuator pHAdjuster = new Actuator("pH Adjuster", "Model X", false);

        AquariumController aquariumController = new AquariumController(levelSensor, temperatureSensor, pHSensor, alarm, pHAdjuster);

        pHSensor.setValue(7.0F);
        aquariumController.checkpH();
        assertFalse(alarm.isOn());

        pHSensor.setValue(8.0F);
        aquariumController.checkpH();
        assertTrue(alarm.isOn());
    }
}