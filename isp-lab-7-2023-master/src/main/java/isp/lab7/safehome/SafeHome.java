package isp.lab7.safehome;

import java.util.Scanner;

public class SafeHome {

    public static void main(String[] args) {
        DoorLockController controller = new DoorLockController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select user type:");
            System.out.println("1. Admin");
            System.out.println("2. Tenant");
            System.out.println("3. Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    adminMenu(controller, scanner);
                    break;
                case 2:
                    tenantMenu(controller, scanner);
                    break;
                case 3:
                    System.out.println("Exiting program");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void adminMenu(DoorLockController controller, Scanner scanner) {
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Tenant");
            System.out.println("2. Remove Tenant");
            System.out.println("3. View Access Logs");
            System.out.println("4. Back to main menu");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter PIN:");
                    String pin = scanner.nextLine();
                    System.out.println("Enter Tenant Name:");
                    String tenantName = scanner.nextLine();
                    try {
                        controller.addTenant(pin, tenantName);
                        System.out.println("Tenant added successfully.");
                    } catch (TenantAlreadyExistsException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Enter Tenant Name:");
                    String name = scanner.nextLine();
                    try {
                        controller.removeTenant(name);
                        System.out.println("Tenant removed successfully.");
                    } catch (TenantNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Access Logs:");
                    for (AccessLog log : controller.getAccessLogs()) {
                        System.out.println(log);
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void tenantMenu(DoorLockController controller, Scanner scanner) {
        while (true) {
            System.out.println("Tenant Menu:");
            System.out.println("1. Enter PIN to open/close door");
            System.out.println("2. Back to main menu");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter PIN:");
                    String pin = scanner.nextLine();
                    try {
                        DoorStatus doorStatus = controller.enterPin(pin);
                        System.out.println("Door is now " + doorStatus);
                    } catch (InvalidPinException | TooManyAttemptsException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}


