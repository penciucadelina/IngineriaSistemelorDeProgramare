package isp.lab3.exercise3;

public class Vehicle {
    //atribute private
    private String model;
    private String type;
    private int speed;
    private char fuelType;

    //atribut static
    private static int count = 0;

    public Vehicle(String model, String type, int speed, char fuelType) {
        this.model = model;
        this.type = type;
        this.speed = speed;
        this.fuelType = fuelType;
        count++;
    }

    //Public getters/setters for all attributes
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public char getFuelType() {
        return fuelType;
    }

    public void setFuelType(char fuelType) {
        this.fuelType = fuelType;
    }

    public String toString() {
        return model + " (" + type + ") speed " + speed + " fuel type " + fuelType;
    }

    public static void displayCount() {
        System.out.println("Number of Vehicle " + count);
    }

    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null || getClass() != x.getClass()) return false;
        Vehicle vehicle = (Vehicle) x;
        return speed == vehicle.speed &&
                fuelType == vehicle.fuelType &&
                model.equals(vehicle.model) &&
                type.equals(vehicle.type);
    }


    public static void main(String[] args) {

        Vehicle vehicle1 = new Vehicle("Dacia", "Logan", 150, 'B');
        Vehicle vehicle2 = new Vehicle("BMW", "X6", 180, 'D');


        System.out.println("Vehicle 1: " + vehicle1);
        System.out.println("Vehicle 2: " + vehicle2);

        //modificam atributele prin setters
        vehicle1.setFuelType('D');
        vehicle1.setSpeed(170);

        System.out.println("Vehicle 1: " + vehicle1);

        //extragem atribute prin getters
        System.out.println(vehicle2.getModel() + " " + vehicle2.getType() + " " + vehicle2.getSpeed() + " " + vehicle2.getFuelType());


        System.out.println("sunt egale? " + vehicle1.equals(vehicle2));

        //nr de obiecte create
        Vehicle.displayCount();
    }
}

