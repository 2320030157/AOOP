package employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Employee> eList = Arrays.asList(
                new Employee("harsha", 30, 5000, "HR"),
                new Employee("vardhan", 40, 7000, "IT"),
                new Employee("reddy", 35, 6000, "HR"),
                new Employee("sai", 28, 5500, "IT"),
                new Employee("gundam", 25, 4500, "HR")
        );

        EmployeeService es = new EmployeeService();
        
        // Filter employees by department
        List<Employee> hrEmployees = es.filterByDept(eList, "HR");
        System.out.println("HR Employees:");
        hrEmployees.forEach(e -> System.out.println(e.getName()));
        
        // Total salary by department
        double totalIT = es.totalSalaryByDept(eList, "IT");
        System.out.println("\nTotal Salary in IT: " + totalIT);
        
        // Average salary by department
        Map<String, Double> avgSalary = es.avgSalaryByDept(eList);
        System.out.println("\nAverage Salary by Department:");
        avgSalary.forEach((dept, salary) -> System.out.println(dept + ": " + salary));
        
        // Employees sorted by salary
        List<String> sortedNames = es.sortedBySalary(eList);
        System.out.println("\nEmployees sorted by salary:");
        sortedNames.forEach(System.out::println);
    }
}
