package isp.lab8.airways;
import java.util.List;

public class Exercise {
        public static void main(String[] args) {
            RouteManagementApp app = new RouteManagementApp();

            app.createRoute("LRCL-LROP");

            Route route = app.loadRoute("LRCL-LROP");
            route.addWaypoint(new Waypoint("LRCL", 46.7852, 23.6862, 415));
            route.addWaypoint(new Waypoint("TASOD", 47.0548, 23.9212, 10460));
            route.addWaypoint(new Waypoint("SOPAV", 46.9804, 24.7365, 10900));
            route.addWaypoint(new Waypoint("BIRGU", 45.9467, 26.0217, 10200));
            route.addWaypoint(new Waypoint("LROP", 44.5711, 26.0858, 106));

            app.saveRoute(route);

            double totalDistance = route.calculateTotalDistance();
            System.out.println("Total distance of route LRCL-LROP: " + totalDistance + " km");


            List<String> routeNames = app.listRoutes();
            System.out.println("Available routes:");
            for (String name : routeNames) {
                System.out.println(name);
            }


            app.deleteRoute("LRCL-LROP");
            System.out.println("Route LRCL-LROP deleted.");

            routeNames = app.listRoutes();
            System.out.println("Available routes:");
            for (String name : routeNames) {
                System.out.println(name);
            }
        }
    }

