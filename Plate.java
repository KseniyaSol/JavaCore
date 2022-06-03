package Homework7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n, String name) {
        if (n <= food)
        {
            food -= n;
            System.out.println("Котик " + name + " покушал.");
            return true;
        }
        else
        {
            System.out.println("Котик " + name + " не может поесть. Еды недостаточно!");
            return false;
        }
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("На тарелке: " + food + " единиц(ы) еды.");
    }

    public void increaseFood(int n){
        System.out.println("Человек добавил в тарелку " + n + " единиц(ы) еды.");
        food += n;
    }
}
