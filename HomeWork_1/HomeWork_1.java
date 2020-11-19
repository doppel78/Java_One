package GeekBrains_Java_One.HomeWork_1;

public class HomeWork_1 {
    public  static  void  main ( String [] args ) {

        // Задание 1 Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
        //где a, b, c, d – аргументы этого метода, имеющие тип float.
        float a, b, c, d;
        a = 10;
        b = 3;
        c = 5;
        d = 2;
        System.out.print("a = " + a + "; b = " + b + "; c = " + c + "; d = " + d);
        System.out.println("; a * (b + (c / d)) = " + task1(a, b, c, d));


        // Задание 2 Написать метод, принимающий на вход два целых числа, и проверяющий что их сумма лежит в пределах
        // от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
        byte nmb1 = 5;
        byte nmb2 = 10;
        boolean result2 = task2(nmb1, nmb2);

        System.out.print("Сумма чисел " + nmb1  + " и " + nmb2 + " лежит в пределах от 10 до 20: ");
        System.out.println((result2)? "True": "False");

        // Задание 3 Написать метод, которому в качестве параметра передается целое число, метод должен проверить
        // положительное ли число передали, или отрицательное. Замечание: ноль считаем положительным числом.
        // Результат работы метода вывести в консоль
        task3(-6);

        // Задание 4 Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен
        // вернуть приветственное сообщение «Привет, переданное_имя!»; Вывести приветствие в консоль.
        task4("Александр");

        // Задание 5 Написать метод, который определяет является ли год високосным. Каждый 4-й год является високосным,
        // кроме каждого 100-го, при этом каждый 400-й – високосный. Для проверки работы вывести результаты работы метода в консоль
        task5(2020);
    }
    public static float task1(float a, float b, float c, float d){

        return a * (b + (c / d));
    }
    public static boolean task2(int number1, int number2) {

        int sum = number1 + number2;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }
    public static void task3(int number) {

        System.out.print("Число " + number);
        if (task(number) == false) {
            System.out.println(" - положительное");
        } else {
            System.out.println(" - отрицательное");
        }
    }
    public static boolean task(int number) {

        if (number < 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void task4(String name) {

        System.out.println("Привет, " + name + "!");

    }
    public static void task5(int year) {

        System.out.print("Год " + year);
        if ((year % 4) == 0 && ((year % 100 != 0) || (year % 400 == 0))) {
            System.out.print(" является високосным");
        } else {
            System.out.print(" не является високосным");
        }
    }
}
