package employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeService {

    public List<Employee> filterByDept(List<Employee> eList, String dept) {
        return eList.stream().filter(e -> e.getDept().equals(dept)).collect(Collectors.toList());
    }

    public double totalSalaryByDept(List<Employee> eList, String dept) {
        return eList.stream().filter(e -> e.getDept().equals(dept))
                .mapToDouble(Employee::getSalary).sum();
    }

    public Map<String, Double> avgSalaryByDept(List<Employee> eList) {
        return eList.stream().collect(Collectors.groupingBy(Employee::getDept, 
                Collectors.averagingDouble(Employee::getSalary)));
    }

    public List<String> sortedBySalary(List<Employee> eList) {
        return eList.stream().sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                .map(Employee::getName).collect(Collectors.toList());
    }
}
