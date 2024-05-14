package isp.lab10.raceapp;

import isp.lab10.raceapp.Car;
import isp.lab10.raceapp.CarPanel;
import isp.lab10.raceapp.SemaphorePanel;
import isp.lab10.raceapp.SemaphoreThread;

import javax.swing.*;


import javax.swing.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Race!");
        JFrame frame1 = new JFrame("Semaphore");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SemaphorePanel semaphorePanel = new SemaphorePanel();
        frame1.getContentPane().add(semaphorePanel);
        frame1.pack();
        frame1.setVisible(true);
        SemaphoreThread semaphoreThread = new SemaphoreThread(semaphorePanel);
        semaphoreThread.start();

        JFrame frame = new JFrame("Car Race");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CarPanel carPanel = new CarPanel();
        frame.getContentPane().add(carPanel);
        frame.pack();
        frame.setSize(500, 300);
        frame.setVisible(true);

        PlaySound sound = new PlaySound();

        Car car1 = new Car("Red car", carPanel);
        Car car2 = new Car("Blue car", carPanel);
        Car car3 = new Car("Green car", carPanel);
        Car car4 = new Car("Yellow car", carPanel);

        semaphoreThread.join();


        sound.playSound();


        car1.start();
        car2.start();
        car3.start();
        car4.start();

        car1.join();
        car2.join();
        car3.join();
        car4.join();

        sound.stopSound();
    }
}
