package Homework6;

public class Homework6 {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Xavier");
        cat1.run(200);
        cat1.swim(5);

        Cat cat2 = new Cat("Runa");
        cat2.run(250);
        cat2.swim(0);

        Dog dog1 = new Dog("Marta");
        dog1.run(500);
        dog1.swim(10);

        Dog dog2 = new Dog("Lordy");
        dog2.run(570);
        dog2.swim(15);

        Animal.allAnimals();
    }
}
