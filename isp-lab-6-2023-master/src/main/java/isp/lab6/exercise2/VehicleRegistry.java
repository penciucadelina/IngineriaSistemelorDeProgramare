package isp.lab6.exercise2;

import java.util.HashSet;
import java.util.Set;

class VehicleRegistry {
    private Set<Vehicle> registry;

    public VehicleRegistry() {
        registry = new HashSet<>();
    }

    public void addVehicle(Vehicle vehicle) {
        registry.add(vehicle);
    }

    public void removeVehicle(String vin) {
        Vehicle vehicleToRemove = null;
        for (Vehicle vehicle : registry) {
            if (vehicle.getVin().equals(vin)) {
                vehicleToRemove = vehicle;
                break;
            }
        }
        if (vehicleToRemove != null) {
            registry.remove(vehicleToRemove);
            System.out.println("Vehicle with VIN " + vin + " removed from registry");
        } else {
            System.out.println("Vehicle with VIN " + vin + " not found in registry");
        }
    }

    public boolean containsVehicle(String vin) {
        for (Vehicle vehicle : registry) {
            if (vehicle.getVin().equals(vin)) {
                return true;
            }
        }
        return false;
    }

    public void displayRegistry() {
        System.out.println("Vehicle Registry:");
        for (Vehicle vehicle : registry) {
            System.out.println(vehicle);
        }
    }
}