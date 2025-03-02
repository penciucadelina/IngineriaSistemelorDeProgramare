package aut.isp.lab4.exercise6;

import aut.isp.lab4.exercise5.LevelSensor;
import aut.isp.lab4.exercise5.TemperatureSensor;

public class Exercise6 {
    public static void main(String[] args) {
        LevelSensor levelSensor = new LevelSensor("Apple", "Pro", "L", 18.0F);
        TemperatureSensor temperatureSensor = new TemperatureSensor("Temperature", "Pro", "grade C", 10);
        pHSensor pHSensor = new pHSensor("Acme", "Model 1", "pH", 6.5F, 7.5F);
        Alarm alarm = new Alarm("Samsung", "Alarm", false);
        Actuator pHAdjuster = new Actuator("pH Adjuster", "Model X", false);

        AquariumController aquariumController = new AquariumController(levelSensor, temperatureSensor, pHSensor, alarm, pHAdjuster);

        aquariumController.checkpH();
        pHSensor.setValue(8.0F);
        aquariumController.checkpH();
        pHSensor.setValue(7.0F);
        aquariumController.checkpH();
    }
}