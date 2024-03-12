package isp.lab3.exercise4;

import isp.lab3.exercise4.MyPoint;
import org.junit.Test;

import static org.junit.Assert.*;;

public class MyPointTest {

    @Test
    public void testDistance() {
        MyPoint point1 = new MyPoint(20, 0, 0);
        MyPoint point2 = new MyPoint(10, 0, 0);
        double expected = 10;
        double actual = point1.distance(point2);
        assertEquals(expected, actual, 0.001);

    }
}
