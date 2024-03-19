package aut.isp.lab4.exercise2;

public class Exercise2 {
    public static void main(String[] args) {

        FishFeeder feeder = new FishFeeder("Manufacturer", "Model");

        feeder.fillUp();
        feeder.feed();

        System.out.println(feeder.toString());

    }
}
