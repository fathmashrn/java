import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentMarkList extends JFrame implements ActionListener {

    JTextField nameField, regField;
    JTextField mark1Field, mark2Field, mark3Field;
    JTextArea resultArea;

    JButton calculate, clear, exit;

    StudentMarkList() {

        setTitle("Student Mark List");
        setSize(500, 500);
        setLayout(new GridLayout(8, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Student Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Register Number:"));
        regField = new JTextField();
        add(regField);

        add(new JLabel("Subject 1 Mark:"));
        mark1Field = new JTextField();
        add(mark1Field);

        add(new JLabel("Subject 2 Mark:"));
        mark2Field = new JTextField();
        add(mark2Field);

        add(new JLabel("Subject 3 Mark:"));
        mark3Field = new JTextField();
        add(mark3Field);

        calculate = new JButton("Calculate");
        clear = new JButton("Clear");
        exit = new JButton("Exit");

        add(calculate);
        add(clear);

        add(exit);
        add(new JLabel(""));

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        add(new JLabel("Result:"));
        add(resultArea);

        calculate.addActionListener(this);
        clear.addActionListener(this);
        exit.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == calculate) {

            try {
                double mark1 = Double.parseDouble(mark1Field.getText());
                double mark2 = Double.parseDouble(mark2Field.getText());
                double mark3 = Double.parseDouble(mark3Field.getText());

                if (mark1 < 0 || mark1 > 100 ||
                    mark2 < 0 || mark2 > 100 ||
                    mark3 < 0 || mark3 > 100) {

                    throw new IllegalArgumentException(
                            "Marks must be between 0 and 100.");
                }

                double total = mark1 + mark2 + mark3;
                double average = total / 3;

                String grade;

                if (average >= 90)
                    grade = "A+";
                else if (average >= 80)
                    grade = "A";
                else if (average >= 70)
                    grade = "B";
                else if (average >= 60)
                    grade = "C";
                else if (average >= 50)
                    grade = "D";
                else
                    grade = "F";

                resultArea.setText(
                        "Name: " + nameField.getText()
                        + "\nRegister Number: " + regField.getText()
                        + "\nTotal: " + total
                        + "\nAverage: " + String.format("%.2f", average)
                        + "\nGrade: " + grade
                );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(this,
                        "Please enter valid marks.");

            } catch (IllegalArgumentException ex) {

                JOptionPane.showMessageDialog(this,
                        ex.getMessage());
            }
        }

        else if (e.getSource() == clear) {

            nameField.setText("");
            regField.setText("");
            mark1Field.setText("");
            mark2Field.setText("");
            mark3Field.setText("");
            resultArea.setText("");
        }

        else if (e.getSource() == exit) {

            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new StudentMarkList();
    }
}
