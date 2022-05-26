package Homework5;

public class Homework5 {

    public static void main(String[] args) {

        Employee[] office = new Employee[5];
        office[0] = new Employee("Ivanov Ivan Ivanovich", "Director", "ivanov@mail.ru", 89999999999l, 250000, 47);
        office[1] = new Employee("Petrov Petr Petrovich", "Designer", "petrov@mail.ru", 87777777777l, 180000, 33);
        office[2] = new Employee("Sidorov Sidr Sidorovich", "Programmer", "sidorov@mail.ru", 86666666666l, 237000, 40);
        office[3] = new Employee("Marieva Mariya Marievna", "Accountant", "marieva@mail.ru", 85555555555l, 160000, 52);
        office[4] = new Employee("Tamarova Tamara Tamarovna", "Assistant", "tamarova@mail.ru", 84444444444l, 104000, 24);

        for (int i = 0; i < office.length; i++) {
            if (office[i].getAge() > 40) office[i].showEmployeeInfo();
        }
    }
}
