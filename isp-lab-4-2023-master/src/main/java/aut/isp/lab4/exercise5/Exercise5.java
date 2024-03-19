package aut.isp.lab4.exercise5;

import aut.isp.lab4.exercise2.FishFeeder;

public class Exercise5 {
    public static void main(String[] args) {
        LevelSensor lvlSensor = new LevelSensor("Manufacturer", "Model", "Unit");
        TemperatureSensor tempSensor = new TemperatureSensor("Manufacturer", "Model", "Unit");
        Actuator alarm = new Actuator("AlarmManufacturer", "AlarmModel");
        Actuator heater = new Actuator("HeaterManufacturer", "HeaterModel");
        FishFeeder fishFeeder = new FishFeeder("FeederManufacturer", "FeederModel");


        AquariumController5 aquariumController = new AquariumController5(
                "AquariumControllerManufacturer",
                "AquariumControllerModel",
                0,
                8,
                26,
                0.5f,
                lvlSensor,
                tempSensor,
                alarm,
                heater, fishFeeder);


        lvlSensor.setValue(0.4f);
        tempSensor.setValue(25);

        //initial
        System.out.println(aquariumController);


        aquariumController.setCurrentTime(8);

        aquariumController.checkWaterLevel();

        aquariumController.checkTemperature();

        System.out.println("State after checking water level and temperature:");
        System.out.println(aquariumController);


        aquariumController.setCurrentTime(8);
        aquariumController.checkFeedingTime();

        System.out.println("State after feeding time : ");
        System.out.println(aquariumController);
    }
}
