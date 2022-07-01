package Homework13;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Car implements Runnable {

    private static int CARS_COUNT;
    private static String winner = null;
    private Race race;
    private int speed;
    private String name;
    private CountDownLatch countDownLatch;
    private String start;
    private int last;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(CountDownLatch countDownLatch, String start, Race race, int speed) {
        this.countDownLatch = countDownLatch;
        this.start = start;
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        last = CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            try {
                System.out.println(this.name + " готовится");
                Thread.sleep(500 + (int)(Math.random() * 800));
                System.out.println(this.name + " готов");
                countDownLatch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (last == 4) System.out.println(start);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (winner == null) System.out.println(this.name + " - WIN");
        winner = this.name;
    }
}
