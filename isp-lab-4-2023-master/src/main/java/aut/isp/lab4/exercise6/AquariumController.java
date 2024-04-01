package aut.isp.lab4.exercise6;


import aut.isp.lab4.exercise5.LevelSensor;
import aut.isp.lab4.exercise5.TemperatureSensor;

public class AquariumController {
    private LevelSensor lvlSensor;
    private TemperatureSensor tempSensor;
    private pHSensor pHSensor;
    private Alarm alarm;
    private Actuator pHAdjuster;

    public AquariumController(LevelSensor lvlSensor, TemperatureSensor tempSensor, pHSensor pHSensor, Alarm alarm, Actuator pHAdjuster) {
        this.lvlSensor = lvlSensor;
        this.tempSensor = tempSensor;
        this.pHSensor = pHSensor;
        this.alarm = alarm;
        this.pHAdjuster = pHAdjuster;
    }

    public void checkpH() {
        float currentpH = pHSensor.getValue();
        System.out.println("pH level is: " + currentpH);
        if (currentpH < pHSensor.getLowerLimit() || currentpH > pHSensor.getUpperLimit()) {
            System.out.println("Raising an alarm.");
            alarm.turnOn();
        } else {
            alarm.turnOff();
        }
    }

}