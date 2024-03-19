package aut.isp.lab4.exercise2;

public class FishFeeder {
    private String manufacturer;
    private String model;
    private int meals;

    // Constructor
    public FishFeeder(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.meals = 0;
    }

    public void fillUp() {
        this.meals = 14; // Reset
        System.out.println("Capacity -> 14 meals.");
    }


    public int getMeals() {
        return meals;
    }

    public void feed() {
        if (meals > 0) {
            meals--;
            System.out.println("Remaining meals: " + meals);
        } else {
            System.out.println("No more meals left in the fish feeder.");
        }
    }

    @Override
    public String toString() {
        return "FishFeeder: " +
                "manufacturer=" + manufacturer + ", model=" + model + ", meals=" + meals;
    }
}

