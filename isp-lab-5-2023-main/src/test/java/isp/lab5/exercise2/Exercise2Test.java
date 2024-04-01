package isp.lab5.exercise2;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Exercise2Test {

    @Test
    public void testChargeLaptop() {
        Laptop laptop = new Laptop();
        laptop.charge(30);
        assertEquals(60, laptop.getBatteryLevel());
    }

    @Test
    public void testChargeSmartPhone() {
        SmartPhone smartPhone = new SmartPhone();
        smartPhone.charge(20);

        smartPhone.charge(10);
        assertEquals(90,smartPhone.getBatteryLevel());
    }

    @Test
    public void testChargeSmartWatch() {
        SmartWatch smartWatch = new SmartWatch();
        smartWatch.charge(10);
        assertEquals(20, smartWatch.getBatteryLevel());
    }
}
