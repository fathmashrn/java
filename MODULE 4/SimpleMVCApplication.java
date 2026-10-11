class Student {
    // Model
    String name;
    int age;
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
class StudentView {
    // View
    void displayStudent(String name, int age) {
        System.out.println("Student Details");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
class StudentController {
    // Controller
    Student model;
    StudentView view;
    StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }
    void display() {
        view.displayStudent(model.name, model.age);
    }
}
public class SimpleMVCApplication {
    public static void main(String[] args) {
        Student model = new Student("Sherin", 21);
        StudentView view = new StudentView();
        StudentController controller =
                new StudentController(model, view);
        controller.display();
    }
}
