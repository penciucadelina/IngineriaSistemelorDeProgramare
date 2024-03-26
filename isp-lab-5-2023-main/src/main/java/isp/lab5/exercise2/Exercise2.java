package isp.lab5.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        SmartPhone smartPhone = new SmartPhone();
        SmartWatch smartWatch = new SmartWatch();

        laptop.charge(30);
        smartPhone.charge(15);
        smartWatch.charge(10);

        System.out.println("Laptop battery level: " + laptop.getBatteryLevel() + "%");
        System.out.println("Smartphone battery level: " + smartPhone.getBatteryLevel() + "%");
        System.out.println("Smartwatch battery level: " + smartWatch.getBatteryLevel() + "%");
    }
}
