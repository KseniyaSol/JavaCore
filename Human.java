package Homework8;

public class Human implements Jumpable, Runable{

    String name;
    int maxJumpHeight;
    int maxRunLenght;

    public Human(String name, int maxJumpHeight, int maxRunLenght) {
        this.name = name;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunLenght = maxRunLenght;
    }

    @Override
    public boolean Run(String name, int lenght, int maxRunLenght) {
        boolean done = false;
        if (lenght <= maxRunLenght) {
            System.out.println(name + " пробежал " + lenght + " метров.");
            return done = true;
        }
        else {
            System.out.println(name + " не смог пробежать " + lenght + " метров!");
            return done = false;
        }
    }

    @Override
    public boolean Jump(String name, int height, int maxJumpHeight) {
        boolean done = false;
        if (height <= maxJumpHeight) {
            System.out.println(name + " подпрыгнул на " + height + " метра(ов).");
            return done = true;
        }
        else {
            System.out.println(name + " не смог перепрыгнуть " + height + " метра(ов)!");
            return done = false;
        }
    }
}
