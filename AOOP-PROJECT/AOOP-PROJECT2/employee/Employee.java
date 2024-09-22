package employee;

public class Employee {
    private String name;
    private int age;
    private double salary;
    private String dept;

    public Employee(String name, int age, double salary, String dept) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.dept = dept;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public String getDept() { return dept; }
}
