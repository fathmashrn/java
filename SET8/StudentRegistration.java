import java.awt.*;
import java.awt.event.*;

public class StudentRegistration extends Frame implements ActionListener {

    TextField name, rollno;
    Choice course;
    Checkbox male, female, java, python;
    Button submit, clear;
    TextArea result;

    StudentRegistration() {
        setTitle("Student Registration Form");
        setSize(500, 500);
        setLayout(new BorderLayout());

        Panel p = new Panel(new GridLayout(6, 2, 10, 10));

        p.add(new Label("Name:"));
        name = new TextField();
        p.add(name);

        p.add(new Label("Roll No:"));
        rollno = new TextField();
        p.add(rollno);

        p.add(new Label("Course:"));
        course = new Choice();
        course.add("BSc Computer Science");
        course.add("BCA");
        course.add("BCom");
        p.add(course);

        p.add(new Label("Gender:"));
        Panel gender = new Panel();
        male = new Checkbox("Male");
        female = new Checkbox("Female");
        gender.add(male);
        gender.add(female);
        p.add(gender);

        p.add(new Label("Skills:"));
        Panel skills = new Panel();
        java = new Checkbox("Java");
        python = new Checkbox("Python");
        skills.add(java);
        skills.add(python);
        p.add(skills);

        submit = new Button("Submit");
        clear = new Button("Clear");
        p.add(submit);
        p.add(clear);

        add(p, BorderLayout.NORTH);

        result = new TextArea();
        add(result, BorderLayout.CENTER);

        submit.addActionListener(this);
        clear.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submit) {
            result.setText(
                "Student Details\n\n" +
                "Name: " + name.getText() + "\n" +
                "Roll No: " + rollno.getText() + "\n" +
                "Course: " + course.getSelectedItem() + "\n" +
                "Gender: " + (male.getState() ? "Male" : "Female") + "\n" +
                "Java: " + java.getState() + "\n" +
                "Python: " + python.getState()
            );
        }

        if (e.getSource() == clear) {
            name.setText("");
            rollno.setText("");
            result.setText("");
            java.setState(false);
            python.setState(false);
            male.setState(false);
            female.setState(false);
        }
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}
