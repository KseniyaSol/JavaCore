package Homework11;

import java.util.ArrayList;

public class Box <T extends Fruit>{

    private ArrayList<T> box = new ArrayList<T>();
    private T fruit;
    private String name;

    public Box(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(T fruit, int amount){
        for (int i = 0; i < amount; i++) {
            box.add(fruit);
        }
        this.fruit = fruit;
        System.out.println(getName() + " пополнена " + amount + " фруктами типа " + fruit.getType());
    }

    public boolean compare(Box box){
        if (getWeight() == box.getWeight()) return true;
        else return false;
    }

    public void moveToOtherBox(Box<T> box){
        System.out.println("Фрукты типа " + fruit.getType() + " из " + getName() + " переложены в " + box.getName() + " в количестве " + this.box.size() + " штук");
        box.add(fruit, this.box.size());
        this.box = new ArrayList<T>();
    }

    public float getWeight(){
        if (!isEmpty()) return fruit.getWeight() * box.size();
        else return 0;
    }

    @Override
    public String toString() {
        if (!isEmpty()) return getName() + " содержит фрукты типа " + fruit.getType() + " в количестве " + box.size() + " штук.";
        else return getName() + " пуста.";
    }

    public boolean isEmpty(){
        if (box.isEmpty()) return true;
        else return false;
    }
}
