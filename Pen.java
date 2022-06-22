package Homework11;

public class Pen {

    public String color;
    public double price;

    public Pen(String color, double price) {
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ручка: " + "цвет - " + color + ", цена - " + price;
    }
}
