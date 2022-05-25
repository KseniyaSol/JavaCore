package Homework3;

import java.util.Random;
import java.util.Scanner;

public class Homework3 {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        while (true) {
            System.out.println("=========================================");
            System.out.println("|ВАС ПРИВЕТСТВУЕТ ГЛАВНОЕ МЕНЮ ПРОГРАММЫ|");
            System.out.println("=========================================");
            System.out.println("|1 - Игра Угадай число                  |");
            System.out.println("|2 - Игра Угадай слово                  |");
            System.out.println("|0 - Выход                              |");
            System.out.println("=========================================");
            System.out.print("Введите пункт меню: ");
            if (scanner.hasNextInt())
            {
                int number = scanner.nextInt();
                scanner.nextLine();
                switch (number)
                {
                    case 0:
                        scanner.close();
                        System.out.println("Завершение работы приложения");
                        return;
                    case 1:
                        System.out.println();
                        findNumber();
                        break;
                    case 2:
                        System.out.println();
                        findWord();
                        break;
                    default:
                        System.out.println("Номер задачи не найден.\nПожалуйста, повторите попытку ввода.");
                        break;
                }
            }
            else
            {
                System.out.println("Введено некорректное значение.\nПопробуйте еще раз.");
                scanner.nextLine();
            }
        }

    }

    /**
     * Метод представляет собой игру, в которой нужно угадать загаданное компьютером число за 3 попытки
     */
    public static void findNumber()
    {
        System.out.println("Я загадал число от 0 до 9.\nПопробуй угадать его за 3 попытки.");
        while (true)
        {
            int number = random.nextInt(10);
            for (int i = 0; i < 3; i++) {
                System.out.println("Попытка номер " + (i + 1));
                System.out.print("Введите число: ");
                if (scanner.hasNextInt())
                {
                    int userNumber = scanner.nextInt();
                    scanner.nextLine();
                    if (userNumber == number)
                    {
                        System.out.println("Вы угадали!");
                        while (true)
                        {
                            System.out.println("Хотите сыграть еще раз?");
                            System.out.println("1 - Да");
                            System.out.println("0 - Нет");
                            if (scanner.hasNextInt())
                            {
                                int more = scanner.nextInt();
                                scanner.nextLine();
                                switch (more)
                                {
                                    case 1:
                                        System.out.println();
                                        findNumber();
                                    case 0:
                                        return;
                                    default:
                                        System.out.println("Введено некорректное значение.\nПопробуйте еще раз.");
                                }
                            }
                            else
                            {
                                System.out.println("Введено некорректное значение.\nПопробуйте еще раз.");
                                scanner.nextLine();
                            }
                        }
                    }
                    else
                    {
                        if (i != 2)
                        {
                            System.out.println("Вы не угадали. Попробуйте еще раз.");
                            if (userNumber > number) System.out.println("Загаданное число меньше.");
                            else System.out.println("Загаданное число больше.");
                        }
                        else
                        {
                            System.out.println("Вы не угадали число за 3 попытки.");
                            while (true)
                            {
                                System.out.println("Хотите сыграть еще раз?");
                                System.out.println("1 - Да");
                                System.out.println("0 - Нет");
                                if (scanner.hasNextInt())
                                {
                                    int more = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (more)
                                    {
                                        case 1:
                                            System.out.println();
                                            findNumber();
                                        case 0:
                                            return;
                                        default:
                                            System.out.println("Введено некорректное значение.\nПопробуйте еще раз.");
                                    }
                                }
                                else
                                {
                                    System.out.println("Введено некорректное значение.\nПопробуйте еще раз.");
                                    scanner.nextLine();
                                }
                            }
                        }
                    }
                }
                else
                {
                    System.out.println("Введено некорректное значение.\nПопробуйте еще раз.");
                    scanner.nextLine();
                    i--;
                }
            }
        }
    }

    /**
     * Метод представляет собой игру, в которой нужно угадать загаданное компьютером слово
     */
    public static void findWord()
    {
        System.out.println("Я загадал слово. Попробуй его угадать.\nНе волнуйся, я буду тебе помогать и конечно же покажу все возможные слова!");
        System.out.print("Возможные слова: ");
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + " ");
        }
        System.out.println();
        while (true)
        {
            String myWord = words[random.nextInt(words.length)];
            boolean findedWord = true;
            while (true)
            {
                System.out.println();
                System.out.println("Введите слово: ");
                String userWord = scanner.nextLine();
                if (myWord.length() > userWord.length())
                {
                    for (int i = 0; i < userWord.length(); i++) {
                        if (userWord.charAt(i) == myWord.charAt(i))
                        {
                            System.out.print(userWord.charAt(i));
                            if ((myWord.length() == userWord.length()) && (i == userWord.length() - 1) && (findedWord == true))
                            {
                                System.out.println();
                                System.out.println("Вы угадали!");
                                System.out.println();
                                return;
                            }
                        }
                        else
                        {
                            System.out.print("#");
                            findedWord = false;
                        }
                    }
                    for (int i = userWord.length(); i < 15; i++) {
                        System.out.print("#");
                    }
                }
                else
                {
                    for (int i = 0; i < myWord.length(); i++) {
                        if (userWord.charAt(i) == myWord.charAt(i))
                        {
                            System.out.print(userWord.charAt(i));
                            if ((myWord.length() == userWord.length()) && (i == userWord.length() - 1) && (findedWord == true))
                            {
                                System.out.println();
                                System.out.println("Вы угадали!");
                                System.out.println();
                                return;
                            }
                        }
                        else
                        {
                            System.out.print("#");
                            findedWord = false;
                        }
                    }
                    for (int i = myWord.length(); i < 15; i++) {
                        System.out.print("#");
                    }
                }
                findedWord = true;
            }
        }
    }
}
