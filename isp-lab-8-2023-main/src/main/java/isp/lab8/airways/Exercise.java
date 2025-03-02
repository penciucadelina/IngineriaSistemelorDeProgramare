package isp.lab8.airways;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) throws IOException {
        Route route = new Route();
        String directorName = "Routes";
        File director = new File(directorName);
        if (!director.exists()) {
            boolean created = director.mkdir();
            if (created) {
                System.out.println("Director creat cu succes!");
            } else {
                System.out.println("Eroare");
            }
        }


        Scanner scanner = new Scanner(System.in);
        int option = -5;
        while (option != 0) {
            System.out.println("1.Add \n2.Remove \n3.Display all routes\n" +
                    "4.Load a route\n0.Exit");
            System.out.println("Select an option:");
            option = scanner.nextInt();
            switch (option) {
                case 1 -> route.addRoute();
                case 2 -> route.removeRoute();
                case 3 -> route.displayAllRoutes();
                case 4 -> route.loadRoute();
            }
        }
    }
}
