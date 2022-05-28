package Homework4;

import java.util.Random;
import java.util.Scanner;

public class Homework4 {

    public static final char DOT_EMPTY = ' ';
    public static final char DOT_HUMAN = 'X';
    public static final char DOT_AI = '0';
    public static char[][] field;
    public static int fieldX;
    public static int fieldY;
    public static int winLenght;
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {

        initialize();
        drawField();
        while (true)
        {
            humanTurn();
            drawField();
            if (isWin(DOT_HUMAN))
            {
                System.out.println("Вы победили!");
                break;
            }
            if (isDraw())
            {
                System.out.println("Ничья!");
                break;
            }
            aiTurn();
            drawField();
            if (isWin(DOT_AI))
            {
                System.out.println("Компьютер победил!");
                break;
            }
            if (isDraw())
            {
                System.out.println("Ничья!");
                break;
            }
        }
        System.out.println("Игра окончена");
    }

    /**
     * Метод инициализирует все объекты
     */
    public static void initialize()
    {
        System.out.print("Укажите любой размер игрового поля X на Y через пробел -> ");
        fieldX = scanner.nextInt();
        fieldY = scanner.nextInt();
        winLenght = fieldX >= 4 && fieldY >= 4 ? 4 : 3;
        field = new char[fieldX][fieldY];
        for (int i = 0; i < fieldX; i++) {
            for (int j = 0; j < fieldY; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    /**
     * Метод отрисовывает игровое поле
     */
    public static void drawField()
    {
        System.out.print("  ");
        for (int i = 0; i < fieldY; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < fieldX; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldY; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        System.out.print("  ");
        for (int i = 0; i < fieldY; i++) {
            System.out.print("- ");
        }
        System.out.println();
    }

    /**
     * Метод позволяет игроку сделать ход
     */
    public static void humanTurn()
    {
        int x, y;
        do
        {
            System.out.print("Введите координаты вашего хода в формате X (верт) и Y (гориз) через пробел -> ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!(isValid(x, y) && isEmpty(x, y)));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Метод проверяет валидность координат в рамках поля
     * @param x
     * @param y
     * @return
     */
    public static boolean isValid(int x, int y)
    {
        return (x < fieldX && y < fieldY && x >= 0 && y >= 0) ? true : false;
    }

    /**
     * Метод определяет, свободны ли координаты
     * @param x
     * @param y
     * @return
     */
    public static boolean isEmpty(int x, int y)
    {
        return (field[x][y] == DOT_EMPTY) ? true : false;
    }

    /**
     * Метод позволяет компьютеру сделать ход
     */
    public static void aiTurn()
    {
        int x, y;
        boolean temp = false;
        //Поиск своего последнего выигрышного хода
        for (int i = 0; i < fieldX; i++) {
            for (int j = 0; j < fieldY; j++){
                if (isEmpty(i, j))
                {
                    field[i][j] = DOT_AI;
                    if (isWin(DOT_AI)) return;
                    else field[i][j] = DOT_EMPTY;
                }
            }
        }
        //Поиск последнего выигрышного хода игрока
        for (int i = 0; i < fieldX; i++) {
            for (int j = 0; j < fieldY; j++){
                if (isEmpty(i, j))
                {
                    field[i][j] = DOT_HUMAN;
                    if (isWin(DOT_HUMAN))
                    {
                        field[i][j] = DOT_AI;
                        return;
                    }
                    else field[i][j] = DOT_EMPTY;
                }
            }
        }
        if (winLenght == 4)
        {
            //Поиск 2 своих поставленных знаков
            for (int i = 0; i < fieldX; i++) {
                for (int j = 0; j < fieldY; j++){
                    if (isEmpty(i, j))
                    {
                        field[i][j] = DOT_AI;
                        for (int k = 0; k < fieldX; k++) {
                            for (int l = 0; l < fieldY; l++) {
                                if (isEmpty(k, l))
                                {
                                    field[k][l] = DOT_AI;
                                    if (isWin(DOT_AI))
                                    {
                                        field[k][l] = DOT_EMPTY;
                                        temp = true;
                                        break;
                                    }
                                    else field[k][l] = DOT_EMPTY;
                                }
                            }
                        }
                        if (temp) return;
                        else field[i][j] = DOT_EMPTY;
                    }
                }
            }
        }
        do
        {
            x = random.nextInt(fieldX);
            y = random.nextInt(fieldY);
        }
        while (!(isEmpty(x, y) && isValid(x, y)));
        field[x][y] = DOT_AI;
    }

    /**
     * Метод определяет, наступила ли ничья
     * @return
     */
    public static boolean isDraw()
    {
        for (int i = 0; i < fieldX; i++) {
            for (int j = 0; j < fieldY; j++) {
                if (field[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    /**
     * Метод проверяет, случилась ли победа
     * @param dot
     * @return
     */
    public static boolean isWin(char dot)
    {
        int temp = 0, tempJ;
        for (int i = 0; i < fieldX; i++) {
            for (int j = 0; j < fieldY; j++) {
                temp++;
                if (field[i][j] == dot)
                {
                    if ((fieldY - j >= winLenght) && ((field[i][j + winLenght - 3] == dot) && (field[i][j + winLenght - 2] == dot) && (field[i][j + winLenght - 1] == dot))) return true;
                    if ((fieldX - i >= winLenght) && ((field[i + winLenght - 3][j] == dot) && (field[i + winLenght - 2][j] == dot) && (field[i + winLenght - 1][j] == dot))) return true;
                    if ((fieldX - i >= winLenght) && (fieldY - j >= winLenght) && ((field[i + winLenght - 3][j + winLenght - 3] == dot) && (field[i + winLenght - 2][j + winLenght - 2] == dot)
                            && (field[i + winLenght - 1][j + winLenght - 1] == dot))) return true;
                }
                if ((fieldX - i >= winLenght) && (fieldY - j >= winLenght))
                {
                    tempJ = fieldY - temp;
                    if ((field[i][tempJ] == dot) && (field[i + winLenght - 3][tempJ - (winLenght - 3)] == dot) && (field[i + winLenght - 2][tempJ - (winLenght - 3) - 1] == dot)
                            && (field[i + winLenght - 1][tempJ - (winLenght - 3) - 2] == dot)) return true;
                }
            }
            temp = 0;
        }
        return false;
    }
}
