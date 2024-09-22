package employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    private EmployeeService es;
    private List<Employee> eList;

    @BeforeEach
    public void setUp() {
        es = new EmployeeService();
        eList = Arrays.asList(
                new Employee("harsha", 30, 5000, "HR"),
                new Employee("vardhan", 40, 7000, "IT"),
                new Employee("reddy", 35, 6000, "HR"),
                new Employee("sai", 28, 5500, "IT"),
                new Employee("gundam", 25, 4500, "HR")
        );
    }

    @Test
    public void testFilterByDept() {
        List<Employee> hrEmployees = es.filterByDept(eList, "HR");
        assertEquals(3, hrEmployees.size());
        assertTrue(hrEmployees.stream().allMatch(e -> e.getDept().equals("HR")));
    }

    @Test
    public void testTotalSalaryByDept() {
        double totalIT = es.totalSalaryByDept(eList, "IT");
        assertEquals(12500, totalIT);
    }

    @Test
    public void testAvgSalaryByDept() {
        Map<String, Double> avgSalary = es.avgSalaryByDept(eList);
        assertEquals(5000, avgSalary.get("HR"), 0.01);
        assertEquals(6250, avgSalary.get("IT"), 0.01);
    }

    @Test
    public void testSortedBySalary() {
        List<String> sortedNames = es.sortedBySalary(eList);
        assertEquals(Arrays.asList("Bob", "Charlie", "David", "Alice", "Eve"), sortedNames);
    }
}
