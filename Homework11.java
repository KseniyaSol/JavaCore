package Homework11;

public class Homework11 {

    public static void main(String[] args) {

        ReplaceElements();
        System.out.println();
        Fruits();
    }

    /**
     * Метод позволяет поменять местами два элемента массива ссылочного типа, а также изменить тип массива на ArrayList
     */
    public static void ReplaceElements(){
        System.out.println("ВЫПОЛНЯЕТСЯ ПРОГРАММА РАБОТЫ С МАССИВАМИ");
        String[] str = {"Один", "Два", "Три", "Четыре", "Пять"};
        Array<String> array1 = new Array<String>(str);
        array1.replaceElements(1, 3);
        System.out.println();
        Pen pen1 = new Pen("Красный", 12.5);
        Pen pen2 = new Pen("Синий", 7.35);
        Pen pen3 = new Pen("Зеленый", 2.78);
        Pen pen4 = new Pen("Желтый", 17.1);
        Pen[] pens = new Pen[]{pen1, pen2, pen3, pen4};
        Array<Pen> array2 = new Array<Pen>(pens);
        array2.replaceElements(0, 3);
        System.out.println();
        Integer[] arr = {1, 2, 3, 4, 5};
        Array<Integer> array3 = new Array<Integer>(arr);
        array3.replaceElements(1, 3);
        System.out.println();
        array3.replaceElements(1, 6);
        System.out.println();
        array1.replaceToArrayList();
    }

    /**
     * Метод позволяет работать с коробками для фруктов (добавлять, пересыпать, сравнивать, узнавать вес)
     */
    public static void Fruits(){
        System.out.println("ВЫПОЛНЯЕТСЯ ПРОГРАММА РАБОТЫ С ФРУКТАМИ");
        System.out.println();
        Box<Apple> box1 = new Box<Apple>("Коробка с яблоками 1");
        box1.add(new Apple(), 3);
        System.out.println(box1);
        Box<Orange> box2 = new Box<Orange>("Коробка с апельсинами");
        box2.add(new Orange(), 2);
        System.out.println(box2);
        System.out.println(box1.getName() + " - " + "Вес коробки составляет " + box1.getWeight() + " кг");
        System.out.println(box2.getName() + " - " + "Вес коробки составляет " + box2.getWeight() + " кг");
        System.out.println("Равны ли по весу " + box1.getName() + " и " + box2.getName() + " - " + box1.compare(box2));
        box2.add(new Orange(), 3);
        System.out.println(box2);
        System.out.println(box2.getName() + " - " + "Вес коробки составляет " + box2.getWeight() + " кг");
        System.out.println("Равны ли по весу " + box1.getName() + " и " + box2.getName() + " - " + box1.compare(box2));
        Box<Apple> box3 = new Box<Apple>("Коробка с яблоками 2");
        box3.add(new Apple(), 4);
        System.out.println(box3);
        box1.moveToOtherBox(box3);
        System.out.println(box1);
        System.out.println(box3);
    }
}
