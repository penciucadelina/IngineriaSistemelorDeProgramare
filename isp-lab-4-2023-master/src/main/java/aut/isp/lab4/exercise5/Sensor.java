package aut.isp.lab4.exercise5;

public class Sensor {
    private String manufacturer;
    private String model;
    private String unitOfMeasurement;

    // Constructor
    public Sensor(String manufacturer, String model, String unitOfMeasurement) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.unitOfMeasurement = unitOfMeasurement;
    }


    public String getManufacturer() {
        return manufacturer;
    }


    public String getModel() {
        return model;
    }


    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }


    @Override
    public String toString() {
        return "Sensor{" +
                "manufacturer=" + manufacturer + ", model=" + model + ", unitOfMeasurement=" + unitOfMeasurement;
    }
}
