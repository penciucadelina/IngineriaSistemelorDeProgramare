package isp.lab6.exercise2;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestExercise2 {

    @Test
    public void testAddVehicle() {
        VehicleRegistry registry = new VehicleRegistry();
        Vehicle vehicle = new Vehicle("ABC123", "XYZ789", "Bmw", "X6", 2020);

        registry.addVehicle(vehicle);

        assertTrue(registry.containsVehicle("ABC123"));
    }

    @Test
    public void testRemoveVehicle() {
        VehicleRegistry registry = new VehicleRegistry();
        Vehicle vehicle = new Vehicle("ABC123", "XYZ789", "Bmw", "X6", 2020);

        registry.addVehicle(vehicle);
        registry.removeVehicle("ABC123");

        assertFalse(registry.containsVehicle("ABC123"));
    }

    @Test
    public void testContainsVehicle() {
        VehicleRegistry registry = new VehicleRegistry();
        Vehicle vehicle = new Vehicle("ABC123", "XYZ789", "Bmw", "X6", 2020);

        registry.addVehicle(vehicle);

        assertTrue(registry.containsVehicle("ABC123"));
        assertFalse(registry.containsVehicle("DEF456"));
    }
}
