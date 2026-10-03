import java.awt.*;
import java.awt.event.*;

public class MouseKeyboardEvents extends Frame {

    Label label;

    MouseKeyboardEvents() {
        setTitle("Mouse and Keyboard Events");
        setSize(500, 300);
        setLayout(new FlowLayout());

        label = new Label("Move mouse or press a key");
        add(label);

        addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseMoved(MouseEvent e) {
                label.setText(
                    "Mouse Position: X = " +
                    e.getX() + " Y = " + e.getY()
                );
            }
        });

        addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                label.setText(
                    "Mouse Clicked at X = " +
                    e.getX() + " Y = " + e.getY()
                );
            }
        });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                label.setText(
                    "Key Pressed: " + e.getKeyChar()
                );
            }
        });

        setFocusable(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new MouseKeyboardEvents();
    }
}
