package project;

import project.Employee;
import project.HRManagementSystem;
import project.TextEditor;

class ProjectTest {

    private TextEditor editor;
    private HRManagementSystem hrSystem;

    @BeforeEach
    void setUp() {
        editor = new TextEditor();
        hrSystem = new HRManagementSystem();
    }

    @Test
    void testPaste() {
        editor.paste(0, "Hello World");
        assertEquals("Hello World", editor.getText());
    }

    @Test
    void testCut() {
        editor.paste(0, "Hello World");
        editor.cut(0, 5);
        assertEquals(" World", editor.getText());
    }

    @Test
    void testUndo() {
        editor.paste(0, "Hello World");
        editor.cut(0, 5);
        editor.undo();
        assertEquals("Hello World", editor.getText());
    }

    @Test
    void testRedo() {
        editor.paste(0, "Hello World");
        editor.cut(0, 5);
        editor.undo();
        editor.redo();
        assertEquals(" World", editor.getText());
    }

   
    @Test
    void testAddEmployee() {
        final Employee e1 = new Employee("1", "Alice", 50000);
        hrSystem.addEmployee(e1);
        assertEquals(e1, hrSystem.getEmployee("1"));
    }

    @Test
    void testUpdateEmployeeSalary() {
        final Employee e1 = new Employee("1", "Alice", 50000);
        hrSystem.addEmployee(e1);
        hrSystem.updateEmployeeSalary("1", 55000);
        assertEquals(55000, hrSystem.getEmployee("1").getSalary());
    }

    @Test
    void testProcessPayroll() {
        final Employee e1 = new Employee("1", "Alice", 50000);
        final Employee e2 = new Employee("2", "Bob", 60000);
        hrSystem.addEmployee(e1);
        hrSystem.addEmployee(e2);

        assertEquals(50000, hrSystem.getEmployee("1").getSalary());
        assertEquals(60000, hrSystem.getEmployee("2").getSalary());
    }
}
