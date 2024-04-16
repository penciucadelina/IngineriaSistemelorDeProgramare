package isp.lab8.airways;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Route implements Serializable {
    private String name;
    private List<Waypoint> waypoints;

    public Route(String name) {
        this.name = name;
        this.waypoints = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }

    public void addWaypoint(Waypoint waypoint) {
        waypoints.add(waypoint);
    }

    public double calculateTotalDistance() {
        double totalDistance = 0.0;
        for (int i = 0; i < waypoints.size() - 1; i++) {
            Waypoint waypoint1 = waypoints.get(i);
            Waypoint waypoint2 = waypoints.get(i + 1);
            totalDistance += calculateDistance(waypoint1, waypoint2);
        }
        return totalDistance;
    }

    private double calculateDistance(Waypoint waypoint1, Waypoint waypoint2) {
        double lat1 = Math.toRadians(waypoint1.getLatitude());
        double lon1 = Math.toRadians(waypoint1.getLongitude());
        double lat2 = Math.toRadians(waypoint2.getLatitude());
        double lon2 = Math.toRadians(waypoint2.getLongitude());

        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double radius = 6371;
        return radius * c;
    }
}