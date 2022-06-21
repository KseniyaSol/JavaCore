package Homework10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    HashMap<String, ArrayList<Long>> phoneBook = new HashMap<>();

    public void add(String sur, Long phone){
        if (phoneBook.containsKey(sur)) {
            ArrayList<Long> lst = phoneBook.get(sur);
            lst.add(phone);
        }
        else {
            ArrayList<Long> lst = new ArrayList<>();
            lst.add(phone);
            phoneBook.put(sur, lst);
        }
    }

    public void showBook(){
        for (Map.Entry<String, ArrayList<Long>> str : phoneBook.entrySet()){
            System.out.println(str.getKey() + " : " + str.getValue());
        }
    }

    public void get(String surn){
        boolean finded = false;
        System.out.println("Выполняется поиск по фамилии " + surn);
        for (Map.Entry<String, ArrayList<Long>> str : phoneBook.entrySet()){
            if (str.getKey().equals(surn)) {
                System.out.println("Найдена запись - " + str.getKey() + " : " + str.getValue());
                finded = true;
                break;
            }
        }
        if (!finded) System.out.println("Человека с такой фамилией нет в телефонной книге.");
    }
}
