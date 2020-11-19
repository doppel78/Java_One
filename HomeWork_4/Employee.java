package GeekBrains_Java_One.HomeWork_4;

public class Employee {
    // Задание 1 Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
    private final int ID;
    private static int id;
    private String LastName;
    private String FirstName;
    private String Post;
    private String Telephone;
    private static int Salary;
    private int Age;

    // Задание 2 Конструктор класса должен заполнять эти поля при создании объекта;
    public Employee(String LastName, String FirstName, String Post, String Telephone, int Salary, int Age) {
        this.ID = id++;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.Post = Post;
        this.Telephone = Telephone;
        this.Salary = Salary;
        this.Age = Age;
    }

    // Задание 3 Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPost() {
        return Post;
    }

    public String getTelephone() {
        return Telephone;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public int getAge() {
        return Age;
    }

    public void printInfo() {
        System.out.printf("=========================%nID:%s%nФамилия:%s%nИмя:%s%nДолжность:%s%nТелефон:%s%nЗарплата:%s%nВозраст:%d%n",
                ID, LastName, FirstName, Post, Telephone, Salary, Age);
    }
}
