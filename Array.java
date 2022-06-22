package Homework11;

import java.util.ArrayList;
import java.util.Arrays;

public class Array <T>{

    public T[] arr;

    public Array(T[] arr) {
        this.arr = arr;
    }

    public void replaceElements(int numOfFirstElement, int numOfSecondElement){
        try {
            T temp;
            System.out.println("Массив до изменения:");
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
            temp = arr[numOfFirstElement];
            arr[numOfFirstElement] = arr[numOfSecondElement];
            arr[numOfSecondElement] = temp;
            System.out.println();
            System.out.println("Массив после изменения:");
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println();
            System.out.println("Заданы некорректные индексы массива " + numOfFirstElement + " и " + numOfSecondElement + ". В массиве существуют индексы [0-" + (arr.length - 1) + "].");
        }
        catch (Exception e){
            System.out.println();
            System.out.println("Произошла неизвестная ошибка.");
        }
    }

    public void replaceToArrayList(){
        ArrayList<T> arrayList = new ArrayList<T>(Arrays.asList(arr));
        System.out.println("Вывод нового массива типа ArrayList:");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
