package Homework14;

public class Homework14 {

    public static void main(String[] args) throws RuntimeException {

        int[] arr = {1, 2, 3, 7, 4, 99, -4, 0};
        int[] result = getArrayAfterFour(arr);
        System.out.println("Выполняется метод поиска чисел, идущих в массиве после 4");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        System.out.println();
        int[] arr1 = {4, 1, 4, 1, 1, 1, 4};
        System.out.println("Выполняется метод проверки наличия в массиве только 1 и 4");
        System.out.println(isArrayHasOneAndFour(arr1));
    }

    /**
     * Метод возвращает массив чисел, идущих в массиве после последней четверки
     * @param arr Входной массив типа int
     * @return Возвращает массив типа int
     * @throws RuntimeException
     */
    public static int[] getArrayAfterFour(int[] arr) throws RuntimeException {
        if (arr == null) throw new RuntimeException("Массив пуст!");
        int indexOfLastFour = 0;
        boolean finded = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                indexOfLastFour = i;
                finded = true;
            }
        }
        if (!finded) throw new RuntimeException("В массиве должна быть хотя бы одна четверка!");
        if (indexOfLastFour == arr.length - 1) throw new RuntimeException("В массиве должны быть числа после последней четверки!");
        int[] resultArray = new int[arr.length - indexOfLastFour - 1];
        for (int i = indexOfLastFour + 1; i < arr.length; i++) {
            resultArray[i - indexOfLastFour - 1] = arr[i];
        }
        return resultArray;
    }

    /**
     * Метод проверяет наличие в массиве 1 и 4
     * @param arr Входной массив типа int
     * @return Возвращает true, если массив состоит только из 1 и 4 и false, если там только числа одного вида или отличные от них
     */
    public static boolean isArrayHasOneAndFour(int[] arr){
        if (arr == null) throw new RuntimeException("Массив пуст!");
        boolean findedFour = false;
        boolean findedOne = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) findedOne = true;
            if (arr[i] == 4) findedFour = true;
            if ((arr[i] != 1) && (arr[i] != 4)) return false;
        }
        if (findedOne && findedFour) return true;
        else return false;
    }
}
