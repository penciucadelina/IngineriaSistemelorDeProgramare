package isp.lab8.airways;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RouteManagementApp {
    private static final String ROUTES_FOLDER = "routes/";

    private List<Route> routes;

    public RouteManagementApp() {
        this.routes = new ArrayList<>();
    }

    public void createRoute(String name) {
        Route route = new Route(name);
        routes.add(route);
    }

    public void deleteRoute(String name) {
        routes.removeIf(route -> route.getName().equals(name));
        File file = new File(ROUTES_FOLDER + name);
        file.delete();
    }

    public List<String> listRoutes() {
        List<String> routeNames = new ArrayList<>();
        File folder = new File(ROUTES_FOLDER);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                routeNames.add(file.getName());
            }
        }
        return routeNames;
    }

    public void saveRoute(Route route) {
        try (FileOutputStream fos = new FileOutputStream(ROUTES_FOLDER + route.getName());
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(route);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Route loadRoute(String name) {
        Route route = null;
        try (FileInputStream fis = new FileInputStream(ROUTES_FOLDER + name);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            route = (Route) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return route;
    }

}