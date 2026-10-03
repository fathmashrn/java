import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
<applet code="MouseApplet.class" width="500" height="300">
</applet>
*/

public class MouseApplet extends Applet implements MouseListener {

    int x = 0;
    int y = 0;

    public void init() {
        addMouseListener(this);
    }

    public void paint(Graphics g) {
        g.drawString("Move the mouse inside the applet", 120, 70);

        if (x != 0 || y != 0) {
            g.drawString("Mouse clicked at:", 150, 130);
            g.drawString("X = " + x, 150, 160);
            g.drawString("Y = " + y, 150, 190);
        }
    }

    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        repaint();
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
