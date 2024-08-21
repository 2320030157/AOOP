package project;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=== Text Editor Demo ===");
        TextEditor editor = new TextEditor();
        
        System.out.println("Initial text: " + editor.getText());
        
        editor.paste(0, "Hello World");
        System.out.println("After paste: " + editor.getText());
        
        editor.cut(0, 5);
        System.out.println("After cut: " + editor.getText());
        
        editor.undo();
        System.out.println("After undo: " + editor.getText());
        
        editor.redo();
        System.out.println("After redo: " + editor.getText());
        
        editor.paste(0, "Hi ");
        System.out.println("After paste again: " + editor.getText());
        

        System.out.println("\n=== HR Management System ===");
        HRManagementSystem hrSystem = new HRManagementSystem();
   
        Employee e1 = new Employee("1", "Alice", 50000);
        Employee e2 = new Employee("2", "Bob", 60000);
        hrSystem.addEmployee(e1);
        hrSystem.addEmployee(e2);

        System.out.println("Processing Payroll:");
        hrSystem.processPayroll();

  
        hrSystem.updateEmployeeSalary("1", 55000);
        System.out.println("Updated salary for Alice: $" + hrSystem.getEmployee("1").getSalary());
    }
}
