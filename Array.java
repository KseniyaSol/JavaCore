package Homework12;

public class Array {

    private static final int SIZE = 10000000;
    private static final int HALF = SIZE / 2;

    private float[] arr = new float[SIZE];
    private float[] arr1 = new float[HALF];
    private float[] arr2 = new float[HALF];

    public float[] getArr() {
        return arr;
    }

    public int getHALF() {
        return HALF;
    }

    public float[] getArr1() {
        return arr1;
    }

    public float[] getArr2() {
        return arr2;
    }

    public Array() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
    }

    /**
     * Метод заполняет массив, вычисляя значения по формуле
     * @param arr Входной массив типа float
     */
    void math(float[] arr, int start){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + start / 5) * Math.cos(0.2f + start / 5) * Math.cos(0.4f + start / 2));
            start++;
        }
    }

    /**
     * Метод делит массив на 2 половины
     */
    void initializeHalfs(){
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);
    }

    /**
     * Метод соединяет 2 массива в 1
     */
    void construct(){
        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);
    }
}
