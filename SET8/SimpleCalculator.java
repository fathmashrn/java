import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends Frame implements ActionListener {

    TextField n1, n2, result;
    Button add, sub, mul, div;

    SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new Label("First Number:"));
        n1 = new TextField();
        add(n1);

        add(new Label("Second Number:"));
        n2 = new TextField();
        add(n2);

        add(new Label("Result:"));
        result = new TextField();
        result.setEditable(false);
        add(result);

        add = new Button("Add");
        sub = new Button("Subtract");
        mul = new Button("Multiply");
        div = new Button("Divide");

        add(add);
        add(sub);
        add(mul);
        add(div);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            double a = Double.parseDouble(n1.getText());
            double b = Double.parseDouble(n2.getText());
            double r = 0;

            if (e.getSource() == add)
                r = a + b;

            else if (e.getSource() == sub)
                r = a - b;

            else if (e.getSource() == mul)
                r = a * b;

            else if (e.getSource() == div) {
                if (b == 0) {
                    result.setText("Cannot divide by zero");
                    return;
                }
                r = a / b;
            }

            result.setText(String.valueOf(r));

        } catch (NumberFormatException ex) {
            result.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
