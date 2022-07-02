package Homework14;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Homework14Test {

    private int[] arr1;
    private int[] arr2;
    private int[] arr3;
    private int[] arr4;
    private int[] arr5;
    private int[] arr6;
    private int[] arr7;
    private int[] arr8;
    private int[] arr9;

    @Before
    public void setup(){
        arr1 = null;
        arr2 = new int[]{1, 2, 3};
        arr3 = new int[]{1, 2, 3, 4};
        arr4 = new int[]{1, 2, 3, 4, 5, 6, 4};
        arr5 = new int[]{1, 2, 3, 4, 5, 6, 4, 4444, -44, 0, 2};
        arr6 = new int[]{1, 1, 1, 1, 1};
        arr7 = new int[]{4, 4, 4, 4, 4};
        arr8 = new int[]{1, 4, 4, 1, 3};
        arr9 = new int[]{1, 4, 4, 1, 1};
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    /**
     * Тест проверяет обработку пустоты массива (универсален в рамках текущей программы)
     */
    @Test
    public void isArrayEmpty(){
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Массив пуст!");
        Homework14.getArrayAfterFour(arr1);
        Homework14.isArrayHasOneAndFour(arr1);
    }

    /**
     * Тест проверяет обработку отсутствия 4 в массиве
     */
    @Test
    public void isArrayHasntFour(){
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("В массиве должна быть хотя бы одна четверка!");
        Homework14.getArrayAfterFour(arr2);
    }

    /**
     * Тест проверяет обработку стоящей в конце массива 4
     */
    @Test
    public void isFourIsEnd(){
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("В массиве должны быть числа после последней четверки!");
        Homework14.getArrayAfterFour(arr3);
        Homework14.getArrayAfterFour(arr4);
    }

    /**
     * Тест проверяет корректность вычислений для массива с последней четверкой
     */
    @Test
    public void isResultArrayCorrect(){
        int[] expexted = {4444, -44, 0, 2};
        int[] actual = Homework14.getArrayAfterFour(arr5);
        Assert.assertArrayEquals(expexted, actual);
    }

    /**
     * Тест проверяет обработку наличия в массиве только единиц
     */
    @Test
    public void isArrayHasOnlyOnes(){
        Assert.assertFalse(Homework14.isArrayHasOneAndFour(arr6));
    }

    /**
     * Тест проверяет обработку наличия в массиве только четверок
     */
    @Test
    public void isArrayHasOnlyFours(){
        Assert.assertFalse(Homework14.isArrayHasOneAndFour(arr7));
    }

    /**
     * Тест проверяет обработку наличия в массиве не только единиц и четверок
     */
    @Test
    public void isArrayHasNotOnlyOnesAndFours(){
        Assert.assertFalse(Homework14.isArrayHasOneAndFour(arr8));
    }

    /**
     * Тест проверяет корректность вычислений для массива из 1 и 4
     */
    @Test
    public void isResultArrayOneAndFourCorrect(){
        Assert.assertTrue(Homework14.isArrayHasOneAndFour(arr9));
    }
}
