package isp.lab5.exercise3;

public class MonitoringService {
    private Sensor[] sensors;
    private int count;

    public MonitoringService() {
        this.sensors = new Sensor[10]; //array de 10 senz
        this.count = 0;
    }

    public void addSensor(Sensor sensor) {
        if (count < 10) {
            sensors[count++] = sensor;
        } else {
            System.out.println("Nu se mai pot adauga senzori");
        }
    }

    public int getSensorCount() {
        return count;
    }

    public double getAverageTemperatureSensors() {
        double sum = 0;
        int tempSensorCount = 0;
        for (Sensor sensor : sensors) {
            if (sensor instanceof TemperatureSensor) {
                sum += ((TemperatureSensor) sensor).getTemperature();
                tempSensorCount++;
            }
        }
        return tempSensorCount > 0 ? sum / tempSensorCount : 0;
    }

    public double getAverageAllSensors() {
        double sum = 0;
        int sensorCount = 0;
        for (Sensor sensor : sensors) {
            if (sensor != null) {
                if (sensor instanceof TemperatureSensor) {
                    sum += ((TemperatureSensor) sensor).getTemperature();
                } else if (sensor instanceof PressureSensor) {
                    sum += ((PressureSensor) sensor).getPressure();
                }
                sensorCount++;
            }
        }
        return sensorCount > 0 ? sum / sensorCount : 0;
    }
}
