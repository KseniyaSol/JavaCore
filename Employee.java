package Homework5;

public class Employee {

    String FIO;
    String jobTitle;
    String email;
    long phone;
    int salary;
    int age;

    Employee(String FIO, String jobTitle, String email, long phone, int salary, int age) {
        this.FIO = FIO;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    void showEmployeeInfo()
    {
        System.out.println("Данные сотрудника: ФИО - " + this.FIO + "   Должность - " + this.jobTitle + "   Email - " + this.email + "   Телефон - " + this.phone + "   Зарплата - "
        + this.salary + "   Возраст - " + this.age);
    }

    public int getAge() {
        return age;
    }
}
