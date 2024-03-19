package aut.isp.lab4.exercise1;

import org.junit.Test;

import static org.junit.Assert.*;;

public class AquariumControllerTest {
    @Test
    public void testSetCurrenttTime() {
        AquariumController a1 = new AquariumController();
        a1.setCurrentTime(14.1f);

        float expected = 14.1f;
        float actual = a1.getCurrentTime();
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testToString() {
        AquariumController a1 = new AquariumController("Test Manufacturer", "Test Model", 0.0f);
        a1.setCurrentTime(3.2f);

        String actual = a1.toString();
        String expected = "manufacturer=Test Manufacturer, model=Test Model, currentTime=3.2";

        assertEquals(actual, expected);


    }
}
