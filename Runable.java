package Homework8;

public interface Runable {

    default boolean Run(String name, int lenght, int maxRunLenght) {
        return false;
    }
}
