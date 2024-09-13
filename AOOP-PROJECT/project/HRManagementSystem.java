package project;

import java.util.HashMap;
import java.util.Map;

public class HRManagementSystem {
    private final Map<String, Employee> employees;

    public HRManagementSystem() {
        employees = new HashMap<>();
    }

    public void addEmployee(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    public Employee getEmployee(String id) {
        return employees.get(id);
    }

    public void updateEmployeeSalary(String id, double newSalary) {
        Employee employee = employees.get(id);
        if (employee != null) {
            employee.setSalary(newSalary);
        }
    }

    public void processPayroll() {
        for (Employee employee : employees.values()) {
            System.out.println("Processing payroll for: " + employee.getName() + " with salary: $" + employee.getSalary());
        }
    }
}
