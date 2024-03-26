package isp.lab5.exercise3;

public class Exercise3 {

    public static void main(String[] args) {
        MonitoringService monitoringService = new MonitoringService();

        // adaug senzori
        monitoringService.addSensor(new TemperatureSensor("location1", "Temperature Sensor 1", 28.5));
        monitoringService.addSensor(new TemperatureSensor("location2", "Temperature Sensor 2", 23.0));
        monitoringService.addSensor(new PressureSensor("location3", "Pressure Sensor 1", 1003.25));

        // media pt senzorii de temp
        double averageTemperature = monitoringService.getAverageTemperatureSensors();
        System.out.println("Average temperature " + averageTemperature + "°C");

        // media pt toti senzorii
        double averageAllSensors = monitoringService.getAverageAllSensors();
        System.out.println("Average of all sensors: " + averageAllSensors);
    }
}
