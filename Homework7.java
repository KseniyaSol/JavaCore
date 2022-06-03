package Homework7;

public class Homework7 {

    public static void main(String[] args) {
        Cat cat[] = new Cat[5];
        cat[0] = new Cat("Barsik", 5);
        cat[1] = new Cat("Murzik", 3);
        cat[2] = new Cat("Leva", 2);
        cat[3] = new Cat("Runa", 4);
        cat[4] = new Cat("Xavier", 7);
        Plate plate = new Plate(15);
        plate.info();
        System.out.println();
        for (int i = 0; i < cat.length; i++) {
            cat[i].eat(plate);
            cat[i].info();
            System.out.println();
        }
        plate.info();
        System.out.println();
        plate.increaseFood(10);
        System.out.println();
        plate.info();
    }
}
