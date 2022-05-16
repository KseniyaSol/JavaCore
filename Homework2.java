package Homework2;

import java.util.Random;

public class Homework2 {

    static Random random = new Random();

    public static void main(String[] args) {

        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int[] arr1 = new int[8];
        int[] arr2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] arr3 = new int[5][5];
        int[] arr4 = new int[random.nextInt(100) + 1];
        int[] arr5 = new int[random.nextInt(10) + 1];
        int[] arr6 = new int[random.nextInt(20) + 1];

        changeArray(arr);
        fillArray(arr1);
        findSix(arr2);
        squareArray(arr3);
        arraySort(arr4);
        System.out.println("Результат поиска суммы в массиве: " + checkSum(arr5));
        System.out.println();
        moveArray(arr6, 3);
        moveArray(arr6, -2);
    }

    /**
     * Метод заменяет значения элементов в массиве с 0 на 1 и с 1 на 0
     * @param arr Одномерный массив типа int
     */
    public static void changeArray (int[] arr)
    {
        System.out.println("Результат выполнения первого задания:");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) arr[i] = 0;
            else arr[i] = 1;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();
    }

    /**
     * Метод заполняет массив значениями, начиная с 0 и увеличивая на 3
     * @param arr Одномерный массив типа int
     */
    public static void fillArray (int[] arr)
    {
        System.out.println("Результат выполнения второго задания:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();
    }

    /**
     * Метод находит в массиве числа меньше 6 и умножает их на 2
     * @param arr Одномерный массив типа int
     */
    public static void findSix (int[] arr)
    {
        System.out.println("Результат выполнения третьего задания:");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();
    }

    /**
     * Метод заполняет диагональные элементы квадратного массива единицами
     * @param arr Двумерный массив типа int
     */
    public static void squareArray (int[][] arr)
    {
        System.out.println("Результат выполнения четвертого задания:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][i] = 1;
                arr[i][arr[i].length - 1 - i] = 1;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Метод находит минимальный и максимальный элементы в массиве
     * @param arr Одномерный массив типа int
     */
    public static void arraySort (int[] arr)
    {
        int min = 0, max = 0;
        System.out.println("Результат выполнения пятого задания:");
        for (int i = 0; i < arr.length; i++) arr[i] = random.nextInt(100);
        min = arr[0];
        max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Максимальный элемент массива: " + max + ". Минимальный элемент массива: " + min);
        System.out.println();
    }

    /**
     * Метод проверяет, есть ли в массиве место, в котором сумма левой и правой части массива равны
     * @param arr Одномерный массив типа int
     * @return Возвращает true, если такое место есть
     */
    public static boolean checkSum (int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        boolean find = false;
        int leftSum = arr[0], rightSum = arr[arr.length - 1], leftI = 0, rightI = arr.length - 1;
        do
        {
            if (leftI == rightI) break;
            if (leftSum == rightSum) {
                find = true;
                break;
            }
            if (leftSum < rightSum) {
                leftI++;
                leftSum = leftSum + arr[leftI];
            }
            else {
                rightI--;
                rightSum = rightSum + arr[rightI];
            }
        }while (find == false);
        return find;
    }

    /**
     * Метод сдвигает элементы массива на n позиций
     * @param arr Одномерный массив типа int
     * @param n Параметр длины сдвига типа int
     */
    public static void moveArray (int[] arr, int n){
        int temp = 0, mark;
        System.out.println("Результат выполнения седьмого задания:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(20);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        if (n > 0) mark = 1;
        else mark = 2;
        switch (mark)
        {
            case 1:
            {
                for (int i = n; i > 0; i--) {
                    temp = arr[arr.length - 1];
                    for (int j = arr.length - 1; j > 0; j--) {
                        arr[j] = arr[j - 1];
                    }
                    arr[0] = temp;
                }
                break;
            }
            case 2:
            {
                for (int i = -n; i > 0; i--) {
                    temp = arr[0];
                    for (int j = 0; j < arr.length - 1; j++) {
                        arr[j] = arr[j + 1];
                    }
                    arr[arr.length - 1] = temp;
                }
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();
    }
}
