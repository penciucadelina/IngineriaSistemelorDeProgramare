package aut.isp.lab4.exercise3;

import aut.isp.lab4.exercise2.FishFeeder;

public class Exercise3 {
    public static void main(String[] args) {
        FishFeeder feeder = new FishFeeder("Example FishFeeder Manufacturer", "Example FishFeeder Model");

        AquariumController controller = new AquariumController("Example Manufacturer", "Example Model", 10.5f, 12.0f, feeder);

        controller.setCurrentTime(12.0f);

        System.out.println(controller.toString());
    }
}
