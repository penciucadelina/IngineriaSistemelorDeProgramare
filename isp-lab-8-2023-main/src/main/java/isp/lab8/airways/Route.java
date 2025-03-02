package isp.lab8.airways;

import static isp.lab8.airways.WaypointDistanceCalculator.calculateDistance;
import com.fasterxml.jackson.databind.ObjectMapper;
import examples.files.FileReadUtil;
import lombok.Getter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.io.FileWriter;
import java.io.IOException;



@Getter
public class Route {
    private double totalDistance = 0;
    private final List<Waypoint> waypoints = new ArrayList<>();
    private static final String workingFolder = "Routes/";

    public void addRoute() throws IOException {
        boolean exists = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name:");
        String routeName = scanner.next();
        String directorName = workingFolder + routeName;
        File newDirector = new File(directorName);
        if (!newDirector.exists()) {
            boolean created = newDirector.mkdir();
            if (!created) {
                System.out.println("Error");
            }
        } else {
            exists = true;
            System.out.println("Already exists");
        }
        if (!exists) {
            String newFolder = workingFolder + routeName;
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println("Number of waypoints");
            int noWaypoints = scanner.nextInt();
            for (int i = 1; i <= noWaypoints; i++) {
                System.out.print("Waypoint" + i + "s name:");
                String name = scanner.next();
                System.out.print("Waypoint" + i + "'s latitude:");
                double latitude = scanner.nextDouble();
                System.out.print("Waypoint" + i + "'s longitude:");
                double longitude = scanner.nextDouble();
                System.out.print("Waypoint" + i + "'s altitude:");
                int altitude = scanner.nextInt();
                Waypoint waypoint = new Waypoint(i, name, latitude, longitude, altitude);
                objectMapper.writeValue(new FileWriter(newFolder + "\\" + waypoint.getName() + ".json"), waypoint);
            }
        }
    }

    public void removeRoute() {
        try {
            if (!availableRoutes()) {
                throw new NoRouteException();
            } else {
                System.out.println("Insert the name");
                Scanner scanner = new Scanner(System.in);
                String name = scanner.next();

                String Path = workingFolder + name;
                File routeName = new File(Path);
                if (routeName.exists() && routeName.isDirectory()) {
                    delete1(routeName);
                    System.out.println("Removed");
                } else {
                    System.out.println("Doesn't exist");
                }
            }
        } catch (NoRouteException e) {
        }
    }

    private void delete1(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    delete1(file);
                } else {
                    file.delete();
                }
            }
        }
        directory.delete();
    }

    public void loadRoute() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the name:");
        String name = scanner.next();
        File directory = new File(workingFolder);
        File[] routeList = directory.listFiles();
        boolean exist = false;
        assert routeList != null;
        for (File route : routeList) {
            if (route.getName().equals(name) && route.isDirectory()) {
                exist = true;
                break;
            }
        }
        if (exist) {
            String Path = workingFolder + name;
            File newDirector = new File(Path);
            ObjectMapper objectMapper = new ObjectMapper();
            if (newDirector.exists() && newDirector.isDirectory()) {
                File[] jsonn = newDirector.listFiles();
                assert jsonn != null;
                int noWaypoints = 0;
                Waypoint lastWaypoint = new Waypoint();
                for (File json : jsonn) {
                    noWaypoints++;
                    String jsonnn = FileReadUtil.readAllFileLines(Path + "\\" + json.getName()).stream().collect(Collectors.joining("\n"));
                    Waypoint currentWaypoint = objectMapper.readValue(jsonnn, Waypoint.class);
                    waypoints.add(currentWaypoint);
                    if (noWaypoints >= 2) {
                        totalDistance += calculateDistance(lastWaypoint.getLatitude(), lastWaypoint.getLongitude(), currentWaypoint.getLatitude(), currentWaypoint.getLongitude());
                    }
                    lastWaypoint = objectMapper.readValue(jsonnn, Waypoint.class);
                }
                waypoints.sort(Comparator.comparingInt(Waypoint::getIndex));
                for (Waypoint waypoint : waypoints) {
                    System.out.println(waypoint);
                }
            }
            System.out.println("Total distance:" + totalDistance);
        } else {
            System.out.println("Doesn't exist");
        }
    }


    private boolean availableRoutes() {
        File directory = new File(workingFolder);
        File[] routeList = directory.listFiles();
        assert routeList != null;
        for (File route : routeList) {
            if (route.isDirectory()) {
                return true;
            }
        }
        return false;
    }

    public void displayAllRoutes() {
        File directory = new File(workingFolder);
        File[] routeList = directory.listFiles();
        assert routeList != null;
        for (File route : routeList) {
            if (route.isDirectory()) {
                System.out.println(route.getName());
            }
        }
    }
}
