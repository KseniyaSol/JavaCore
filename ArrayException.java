package Homework9;

public class ArrayException extends Exception{

    int sizeOfArray;
    int indexX;
    int indexY;

    public int getSizeOfArray() {
        return sizeOfArray;
    }

    public ArrayException(String message, int sizeOfArray) {
        super(message);
        this.sizeOfArray = sizeOfArray;
    }

    public ArrayException(String message, int indexX, int indexY) {
        super(message);
        this.indexX = indexX;
        this.indexY = indexY;
    }
}

class MyArraySizeException extends ArrayException{

    public MyArraySizeException(String message, int sizeOfArray) {
        super(message, sizeOfArray);
    }
}

class MyArrayDataException extends ArrayException{

    public MyArrayDataException(String message, int indexX, int indexY) {
        super(message, indexX, indexY);
    }
}
