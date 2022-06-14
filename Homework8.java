package Homework8;

import java.util.Random;

public class Homework8 {

    static Random random = new Random();
    static Object[] players = new Object[9];
    static Object[] steps = new Object[random.nextInt(11 - 1) + 1];

    public static void main(String[] args) {

        generatePlayers();
        generateSteps();
        for (int i = 0; i < players.length; i++) {
            System.out.println("Препятствия проходит " + (i + 1) + " игрок.");
            for (int j = 0; j < steps.length; j++) {
                System.out.println((j + 1) + " препятствие:");
                if (steps[j] instanceof Treadmill) {
                    if (players[i] instanceof Human) if ((((Human)players[i]).Run(((Human)players[i]).name, ((Treadmill) steps[j]).lenght, ((Human)players[i]).maxRunLenght)) == false) break;
                    if (players[i] instanceof Cat) if ((((Cat)players[i]).Run(((Cat)players[i]).name, ((Treadmill) steps[j]).lenght, ((Cat)players[i]).maxRunLenght)) == false) break;
                    if (players[i] instanceof Robot) if ((((Robot)players[i]).Run(((Robot)players[i]).name, ((Treadmill) steps[j]).lenght, ((Robot)players[i]).maxRunLenght)) == false) break;
                }
                else if (steps[j] instanceof Wall){
                    if (players[i] instanceof Human) if ((((Human)players[i]).Jump(((Human)players[i]).name, ((Wall) steps[j]).height, ((Human)players[i]).maxJumpHeight)) == false) break;
                    if (players[i] instanceof Cat) if (((Cat)players[i]).Jump(((Cat)players[i]).name, ((Wall) steps[j]).height, ((Cat)players[i]).maxJumpHeight) == false) break;
                    if (players[i] instanceof Robot) if (((Robot)players[i]).Jump(((Robot)players[i]).name, ((Wall) steps[j]).height, ((Robot)players[i]).maxJumpHeight) == false) break;
                }
            }
            System.out.println();
        }
    }

    /**
     * Метод создает 9 участников
     */
    static public void generatePlayers(){

        String[] humanNames = new String[] {"Василий", "Игорь", "Александр", "Анатолий", "Иван", "Сергей", "Максим", "Михаил", "Эдуард"};
        String[] catNames = new String[] {"Мурзик", "Пушок", "Барсик", "Ксавьер", "Йогурт", "Беляш", "Черныш", "Боря", "Лева"};
        for (int i = 0; i < 9; i+=3) {
            players[i] = new Human(humanNames[random.nextInt(9)], random.nextInt(3 - 1) + 1, random.nextInt(1000 - 100) + 100);
            players[i + 1] = new Cat(catNames[random.nextInt(9)], random.nextInt(3), random.nextInt(5000 - 1000) + 1000);
            players[i + 2] = new Robot("Robot" + random.nextInt(100), random.nextInt(10 - 1) + 1, random.nextInt(50000 - 5000) + 5000);
        }
    }

    /**
     * Метод создает массив препятствий
     */
    public static void generateSteps(){

        for (int i = 0; i < steps.length; i++) {
            int typeIndex = random.nextInt(2);
            switch (typeIndex){
                case 0:
                    steps[i] = new Treadmill(random.nextInt(50001 - 100) + 100);
                    break;
                case 1:
                    steps[i] = new Wall(random.nextInt(11 - 1) + 1);
                    break;
            }
        }
    }
}
