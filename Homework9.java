package Homework9;

public class Homework9 {

    public static void main(String[] args) {

        try{
            Array array = new Array();
            array.getSizeOfArray();
            array.initializeArray();
            array.calculateSumOfArray(array.arr);
        }
        catch (MyArraySizeException e){
            System.out.printf("%sПрограмма может работать только с массивом размером %d на %d.", e.getMessage(), e.sizeOfArray, e.sizeOfArray);
        }
        catch (MyArrayDataException e){
            System.out.printf("%sНа позиции [%d][%d] находится не число.\n", e.getMessage(), e.indexX, e.indexY);
        }

    }
}
