import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {

    JTextField num1, num2, result;
    JButton add, sub, mul, div;

    SimpleCalculator() {

        setTitle("Simple Calculator");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("First Number:"));
        num1 = new JTextField();
        add(num1);

        add(new JLabel("Second Number:"));
        num2 = new JTextField();
        add(num2);

        add(new JLabel("Result:"));
        result = new JTextField();
        result.setEditable(false);
        add(result);

        add = new JButton("Addition");
        sub = new JButton("Subtraction");
        mul = new JButton("Multiplication");
        div = new JButton("Division");

        add(add);
        add(sub);
        add(mul);
        add(div);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            double a = Double.parseDouble(num1.getText());
            double b = Double.parseDouble(num2.getText());
            double answer = 0;

            if (e.getSource() == add) {
                answer = a + b;
            }
            else if (e.getSource() == sub) {
                answer = a - b;
            }
            else if (e.getSource() == mul) {
                answer = a * b;
            }
            else if (e.getSource() == div) {

                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }

                answer = a / b;
            }

            result.setText(String.valueOf(answer));

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(this,
                    "Please enter valid numbers.");

        } catch (ArithmeticException ex) {

            JOptionPane.showMessageDialog(this,
                    ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
