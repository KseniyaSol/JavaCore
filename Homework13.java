package Homework13;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Homework13 {

    public static final int CARS_COUNT = 4;

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
        Semaphore semaphore = new Semaphore(2);
        String start = "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!";

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(semaphore), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        Thread t[] = new Thread[cars.length];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(countDownLatch, start, race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            t[i] = new Thread(cars[i]);
            t[i].start();
        }
        for (int i = 0; i < t.length; i++) {
            t[i].join();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
