import java.util.ArrayList;
class Student {
    int id;
    String name;
    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
// Model
class StudentModel {
    ArrayList<Student> students = new ArrayList<>();
    void addStudent(int id, String name) {
        students.add(new Student(id, name));
        System.out.println("Student added successfully");
    }
    void displayStudents() {
        for (Student s : students) {
            System.out.println("ID: " + s.id +
                               ", Name: " + s.name);
        }
    }
    void updateStudent(int id, String name) {
        for (Student s : students) {
            if (s.id == id) {
                s.name = name;
                System.out.println("Student updated successfully");
                return;
            }
        }
        System.out.println("Student not found");
    }
    void deleteStudent(int id) {
        for (Student s : students) {
            if (s.id == id) {
                students.remove(s);
                System.out.println("Student deleted successfully");
                return;
            }
        }
        System.out.println("Student not found");
    }
}
// View
class StudentView {
    void showMessage(String message) {
        System.out.println(message);
    }
}
// Controller
class StudentController {
    StudentModel model;
    StudentView view;
    StudentController(StudentModel model, StudentView view) {
        this.model = model;
        this.view = view;
    }
    void performOperations() {
        model.addStudent(1, "Anu");
        model.addStudent(2, "Riya");
        view.showMessage("\nStudent List:");
        model.displayStudents();
        model.updateStudent(1, "Meera");
        view.showMessage("\nAfter Update:");
        model.displayStudents();
        model.deleteStudent(2);
        view.showMessage("\nAfter Delete:");
        model.displayStudents();
    }
}
// Main Class
public class MVCCRUDApplication {
    public static void main(String[] args) {
        StudentModel model = new StudentModel();
        StudentView view = new StudentView();
        StudentController controller =
                new StudentController(model, view);
        controller.performOperations();
    }
}
