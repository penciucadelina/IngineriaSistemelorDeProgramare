package isp.lab10.raceapp;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Semaphore");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SemaphorePanel semaphorePanel = new SemaphorePanel();
        frame.getContentPane().add(semaphorePanel);
        frame.pack();
        frame.setVisible(true);

        SemaphoreThread semaphoreThread = new SemaphoreThread(semaphorePanel);
        semaphoreThread.start();
        semaphoreThread.join();

        TimerThread timerThread = new TimerThread();
        timerThread.start();

        JFrame carFrame = new JFrame("Car Race!");
        carFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CarPanel carPanel = new CarPanel();
        carFrame.getContentPane().add(carPanel);
        carFrame.pack();
        carFrame.setSize(500, 300);
        carFrame.setVisible(true);

        PlaySound sound = new PlaySound();
        sound.playSound();

        Car car1 = new Car("BMW", carPanel);
        Car car2 = new Car("Dacia", carPanel);
        Car car3 = new Car("Mercedes", carPanel);
        Car car4 = new Car("Toyota", carPanel);

        car1.start();
        car2.start();
        car3.start();
        car4.start();

        car1.join();
        car2.join();
        car3.join();
        car4.join();


        timerThread.stopTimer();
        timerThread.join();

        sound.stopSound();

        long time = timerThread.getTime();
        System.out.println("Race finished in " + time / 1000.0f + " seconds");
    }
}

