package isp.lab5.exercise3;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise3Test {

    @Test
    public void testAddSensor() {
        MonitoringService monitoringService = new MonitoringService();

        // un senzor de temperatura
        monitoringService.addSensor(new TemperatureSensor("location1", "Temperature Sensor 1", 25.5));
        assertEquals(1, monitoringService.getSensorCount());

        // un senzor de presiune
        monitoringService.addSensor(new PressureSensor("location2", "Pressure Sensor 1", 1013.25));
        assertEquals(2, monitoringService.getSensorCount());
    }

    @Test
    public void testGetAverageTemperatureSensors() {
        MonitoringService monitoringService = new MonitoringService();

        // doi senzori de temperatură cu valori diferite
        monitoringService.addSensor(new TemperatureSensor("location1", "Temperature Sensor 1", 25.5));
        monitoringService.addSensor(new TemperatureSensor("location2", "Temperature Sensor 2", 26.0));

        assertEquals(25.75, monitoringService.getAverageTemperatureSensors(), 0.001);
    }

    @Test
    public void testGetAverageAllSensors() {
        MonitoringService monitoringService = new MonitoringService();

        // doi senzori de temperatura și un senzor de presiune
        monitoringService.addSensor(new TemperatureSensor("location1", "Temperature Sensor 1", 25.5));
        monitoringService.addSensor(new TemperatureSensor("location2", "Temperature Sensor 2", 26.0));
        monitoringService.addSensor(new PressureSensor("location3", "Pressure Sensor 1", 1013.25));

        assertEquals(354.916, monitoringService.getAverageAllSensors(), 0.001);
    }
}
