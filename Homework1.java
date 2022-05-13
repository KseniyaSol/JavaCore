package Homework1;

public class Homework1 {

    public static void main(String[] args) {
        byte a = 127;
        short b = 32767;
        int c = 2147483647;
        long d = 9223372036854775807L;
        float i = 123.45f;
        double f = 1234567.8912;
        char g = 'g';
        boolean h = true;

        int e = 5, year100 = 2100, year4 = 2020, year400 = 2000;

        System.out.println("a * (b + (c / d)) = " + function(i, i, i, i));
        System.out.println("Сумма чисел a и b входит в диапазон от 10 до 20 включительно? Ответ: " + ifSum(e, e));
        positiveOrNegative(e);
        System.out.println("Если число положительное - false, если отрацательное - true. Ответ - " + positiveOrNegativeBool(e));
        sayHello("Mister Cat");
        leapYear(year100);
        leapYear(year4);
        leapYear(year400);
    }

    /**
     * Метод вычисляет значение функции a * (b + (c / d))
     * @param a Первое число типа float
     * @param b Второе число типа float
     * @param c Третье число типа float
     * @param d Четвертое число типа float
     * @return Возвращает результат типа float
     */
    public static float function (float a, float b, float c, float d)
    {
        float res;
        return res = a * (b + (c / d));
    }

    /**
     * Метод проверяет, входит ли сумма чисел a и b в диапазон от 10 до 20 включительно
     * @param a Первое число типа int
     * @param b Второе число типа int
     * @return Возвращает результат типа boolean
     */
    public static boolean ifSum (int a, int b)
    {
        if ((a + b) >= 10 && (a + b) <= 20) return true;
        else return false;
    }

    /**
     * Метод определяет число положительное или отрицательное и выводит ответ
     * @param a Целое число типа int
     */
    public static void positiveOrNegative (int a)
    {
        if (a >= 0) System.out.println("Число положительное");
        else System.out.println("Число отрицательное");
    }

    /**
     * Метод определяет число положительное или отрицательное и выводит true или false
     * @param b Целое число типа int
     */
    public static boolean positiveOrNegativeBool (int b)
    {
        if (b >= 0) return false;
        else return true;
    }

    /**
     * Метод приветствует по указанному имени
     * @param name Имя типа String
     */
    public static void sayHello (String name)
    {
        System.out.println("Привет, " + name + "!");
    }

    /**
     * Метод определяет, високосный год или нет
     * @param year Год типа int
     */
    public static void leapYear (int year)
    {
        if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) System.out.println("Год високосный");
        else System.out.println("Год не високосный");
    }
}
