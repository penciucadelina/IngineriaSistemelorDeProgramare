package aut.isp.lab4.exercise5;

import aut.isp.lab4.exercise2.FishFeeder;

public class Exercise5 {
    public static void main(String[] args) {
        FishFeeder fishFeeder = new FishFeeder("A40", "Pro");
        Sensor sensor = new Sensor("Samsung", "S10", "L/gC");
        LevelSensor levelSensor = new LevelSensor("Apple", "Pro", "L", 18.0F);
        TemperatureSensor temperatureSensor = new TemperatureSensor("Temperature", "Pro", "grade C", 10);
        Actuator actuator = new Actuator("Apple", "Pro", false);
        Alarm alarm = new Alarm("Samsung", "Alarm", false);
        Heater heater = new Heater("Nokia", "Heater", false);
        AquariumController aquariumController = new AquariumController(fishFeeder, "Samsung", "Pro",
                30, 20.0F, levelSensor, temperatureSensor, alarm, heater);

        System.out.println(aquariumController);
        aquariumController.setFeedingTime(10.00F);
        aquariumController.setCurrentTime(14.00F);
        aquariumController.setCurrentTime((float) 12.00F);

        aquariumController.checkTemperature();
        temperatureSensor.setValue(30);
        aquariumController.checkTemperature();
        temperatureSensor.setValue(23);
        aquariumController.checkTemperature();

        aquariumController.checkWaterLevel();
        levelSensor.setValue(20);
        aquariumController.checkWaterLevel();

    }
}