package Homework12;

public class Homework12 {

    public static void main(String[] args) throws InterruptedException {

        Array array = new Array();
        System.out.print("Время выполнения без потоков: ");
        arrayWithoutThreads(array);
        System.out.println();
        Array array1 = new Array();
        System.out.print("Время выполнения с потоками: ");
        arrayWithThreads(array1);
    }

    /**
     * Метод вычисляет новые значения массива без использования потоков
     * @param array Входной класс типа Array
     */
    public static void arrayWithoutThreads(Array array){
        long a = System.currentTimeMillis();
        array.math(array.getArr(), 0);
        System.out.println(System.currentTimeMillis() - a);
    }

    /**
     * Метод вычисляет новые значения массива деля его на 2 и выполняя действия в потоках
     * @param array Входной класс типа Array
     * @throws InterruptedException
     */
    public static void arrayWithThreads(Array array) throws InterruptedException {
        long a = System.currentTimeMillis();
        array.initializeHalfs();
        MyThreadHalf t1 = new MyThreadHalf(array.getArr1(), array, 0);
        MyThreadHalf t2 = new MyThreadHalf(array.getArr2(), array, array.getHALF());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        array.construct();
        System.out.println(System.currentTimeMillis() - a);
    }
}
