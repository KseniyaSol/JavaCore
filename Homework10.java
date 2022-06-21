package Homework10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Homework10 {

    public static void main(String[] args) {

        uniqueArray();
        System.out.println();
        phoneList();
    }

    /**
     * Метод отображает уникальные элементы массива, а также подсчитывает количество их повторений
     */
    public static void uniqueArray(){
        System.out.println("Выполняется задача на отображение уникальных элементов массива.\n");
        String[] arr = {"Красный", "Синий", "Зеленый", "Красный", "Желтый", "Фиолетовый", "Желтый", "Синий", "Оранжевый", "Голубой", "Красный", "Черный"};
        System.out.print("Исходный массив: ");
        Set<String> uniqueArr = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            uniqueArr.add(arr[i]);
        }
        System.out.println();
        System.out.print("Уникальный массив: ");
        System.out.print(uniqueArr);
        int counter = 0;
        HashMap<String, Integer> countArr = new HashMap<>();
        for (String str : arr){
            if (countArr.containsKey(str)){
                counter = countArr.get(str) + 1;
                countArr.put(str, counter);
            }
            else {
                counter = 1;
                countArr.put(str, counter);
            }
        }
        System.out.println();
        System.out.println("Количество повторений элементов:");
        for (Map.Entry<String, Integer> str : countArr.entrySet()){
            System.out.println(str.getKey() + " : " + str.getValue());
        }
    }

    /**
     * Метод позволяет создать телефонный справочник, добавлять в него записи, отображать справочник и осуществлять поиск по фамилии
     */
    public static void phoneList(){
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", 89041111111l);
        phoneBook.add("Петров", 89042222222l);
        phoneBook.add("Сидоров", 8904333333l);
        phoneBook.add("Иванов", 89044444444l);
        phoneBook.add("Фадеев", 89045555555l);
        System.out.println("Выполняется программа работы с телефонным справочником.");
        System.out.println();
        phoneBook.showBook();
        System.out.println();
        phoneBook.get("Петров");
        System.out.println();
        phoneBook.get("Иванов");
        System.out.println();
        phoneBook.get("Мухин");
    }
}
