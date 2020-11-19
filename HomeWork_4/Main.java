package GeekBrains_Java_One.HomeWork_4;

public class Main {
    public static void main(String[] args) {

        // Задание 4 Вывести при помощи методов из пункта 3 ФИО и должность.
        Employee em01 = new Employee("Коннор", "Сара", "Борец со SkyNet", "89996005040", 100000, 50);
        System.out.println("Имя: " + em01.getFirstName() + ", Фамилия: " + em01.getLastName() + ", должность: " + em01.getPost());

        // Задание 5.1 Создать массив из 5 сотрудников
        Employee[] staff = new Employee[5];
        staff[0] = new Employee("Иванов", "Иван", "QA Engineer", "89993002010", 35000, 30);
        staff[1] = new Employee("Алексеев", "Алексей", "QA Team Lead", "899920030010", 45000, 46);
        staff[2] = new Employee("Смирнов", "Владимир", "Software Developer", "899910020030", 35000, 35);
        staff[3] = new Employee("Петров", "Сергей", "Dev Team Lead", "89994003020", 50000, 44);
        staff[4] = new Employee("Кузнецов", "Борис", "Project Manager", "89995004030", 45000, 44);

        // Задание 5.2 С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        for (Employee e : staff) {
            if (e.getAge() > 40) {
                e.printInfo();
            }
        }

        // Задание 6 Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
        for (Employee s : staff) {
            if (s.getAge() > 45) {
                s.setSalary(s.getSalary() + 5000);
                s.printInfo();
            }
        }

        // Задание 7 Подсчитать средние арифметические зарплаты и возраста
        int sumSalaries = 0, sumAges = 0;
        for (int i = 0; i < staff.length; i++) {
            sumSalaries += staff[i].getSalary();
            sumAges += staff[i].getAge();
        }

        System.out.println("============================");
        System.out.println("Средняя зарплата сотрудника: " + sumSalaries / staff.length);
        System.out.println("Средний возраст сотрудника: " + sumAges / staff.length);
    }
}
