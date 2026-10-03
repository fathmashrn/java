import java.awt.*;
import java.awt.event.*;

public class StudentPerformance extends Frame implements ActionListener {

    TextField name, rollno, mark1, mark2, mark3, result;
    Button calculate, clear;

    StudentPerformance() {
        setTitle("Student Performance Management");
        setSize(500, 450);
        setLayout(new GridLayout(8, 2, 10, 10));

        add(new Label("Student Name:"));
        name = new TextField();
        add(name);

        add(new Label("Roll No:"));
        rollno = new TextField();
        add(rollno);

        add(new Label("Mark 1:"));
        mark1 = new TextField();
        add(mark1);

        add(new Label("Mark 2:"));
        mark2 = new TextField();
        add(mark2);

        add(new Label("Mark 3:"));
        mark3 = new TextField();
        add(mark3);

        calculate = new Button("Calculate");
        clear = new Button("Clear");

        add(calculate);
        add(clear);

        add(new Label("Result:"));
        result = new TextField();
        result.setEditable(false);
        add(result);

        calculate.addActionListener(this);
        clear.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == calculate) {

            try {
                double m1 = Double.parseDouble(mark1.getText());
                double m2 = Double.parseDouble(mark2.getText());
                double m3 = Double.parseDouble(mark3.getText());

                double total = m1 + m2 + m3;
                double average = total / 3;

                result.setText(
                    "Total = " + total +
                    ", Average = " + average
                );

            } catch (NumberFormatException ex) {
                result.setText("Invalid Marks");
            }
        }

        if (e.getSource() == clear) {
            name.setText("");
            rollno.setText("");
            mark1.setText("");
            mark2.setText("");
            mark3.setText("");
            result.setText("");
        }
    }

    public static void main(String[] args) {
        new StudentPerformance();
    }
}
