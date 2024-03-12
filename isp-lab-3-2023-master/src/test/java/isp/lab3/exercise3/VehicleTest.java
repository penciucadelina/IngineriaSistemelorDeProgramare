package isp.lab3.exercise3;

import isp.lab3.exercise3.Vehicle;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {

    @Test
    public void testtoString() {
        Vehicle vehicle1 = new Vehicle("Dacia", "Logan", 150, 'B');

        String expected = "Dacia (Logan) speed 150 fuel type B";
        String actual = vehicle1.toString();
        assertEquals(expected, actual);

    }
}

