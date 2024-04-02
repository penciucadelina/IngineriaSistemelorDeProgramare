package isp.lab6.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
    VehicleRegistry registry = new VehicleRegistry();


        registry.addVehicle(new Vehicle("ABC123", "XYZ789", "Bmw", "X3", 2020));
        registry.addVehicle(new Vehicle("DEF456", "UVW321", "Bmw", "X5", 2018));
        registry.addVehicle(new Vehicle("GHI789", "DFR654", "Mercedes", "GLE", 2023));


        registry.displayRegistry();

        System.out.println("\nEste VIN DEF456 in registru? " +
                registry.containsVehicle("DEF456"));

        //il stergem

        registry.removeVehicle("DEF456");

        System.out.println("\nUpdated registry:");
        registry.displayRegistry();
}
}
