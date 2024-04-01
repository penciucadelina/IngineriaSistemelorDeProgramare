package aut.isp.lab4.exercise4;

import aut.isp.lab4.exercise2.FishFeeder;

public class Exercise4 {
    public static void main(String[] args) {

        FishFeeder feeder1 = new FishFeeder("A123", "Pro");
        Lights lights = new Lights(false);

        AquariumController aquariumController = new AquariumController(feeder1, "A20", "PRO LED", lights);
        System.out.println(aquariumController);

        aquariumController.setLightOnTime((float) 6.00F);
        aquariumController.setLightOffTime(5.00F);
        aquariumController.setFeedingTime(4.00F);
        aquariumController.setCurrentTime(3.10F);
        System.out.println(aquariumController);

        aquariumController.setFeedingTime(10.0F);
        aquariumController.setCurrentTime(10.0F);
        System.out.println(aquariumController);

    }
}