package Homework9;

import java.util.Scanner;

public class Array {

    int sizeX;
    int sizeY;
    int needableSize = 4;
    String[][] arr = new String[sizeX][sizeY];

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    void getSizeOfArray(){
        System.out.println("Введите размер двумерного массива.");
        Scanner scanner = new Scanner(System.in);
        sizeX = scanner.nextInt();
        sizeY = scanner.nextInt();
    }

    void initializeArray(){
        String[][] array = new String[sizeX][sizeY];
        System.out.println("Вводите элементы массива (цифры). Всего " + (sizeX * sizeY) + " элементов.");
        Scanner scanner = new Scanner(System.in).useDelimiter("\\s");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = scanner.next();
            }
        }
        arr = array;
        scanner.close();
    }

    void calculateSumOfArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        if ((arr.length != 4) || (arr[0].length != 4)) throw new MyArraySizeException("Некорректный размер массива!\n", needableSize);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (!(arr[i][j].matches("-?\\d+(\\.\\d+)?"))) throw new MyArrayDataException("Данные в массиве не являются числом!\n", i, j);
                sum += Integer.valueOf(arr[i][j]);
            }
        }
        System.out.printf("Сумма всех элементов массива равна: %d\n", sum);
    }
}
