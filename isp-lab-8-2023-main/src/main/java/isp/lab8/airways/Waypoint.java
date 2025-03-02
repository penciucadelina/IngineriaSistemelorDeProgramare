package isp.lab8.airways;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Example waypoint class which can be extended to be used in implementation of the exercise. Add constructor, getters, setters, etc.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Waypoint {
    private int index;
    private String name;
    private double latitude;
    private double longitude;
    private int altitude;
}
