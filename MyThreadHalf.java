package Homework12;

public class MyThreadHalf extends Thread{

    private float[] arr;
    Array array;
    private int start;

    public MyThreadHalf(float[] arr, Array array, int start) {
        this.arr = arr;
        this.array = array;
        this.start = start;
    }

    @Override
    public void run() {
        array.math(arr, start);
    }
}
