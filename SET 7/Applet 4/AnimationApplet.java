import java.applet.Applet;
import java.awt.Graphics;

 /*
<applet code="AnimationApplet.class" width="500" height="300">
</applet>
*/

public class AnimationApplet extends Applet implements Runnable {

    int x = 0;
    Thread t;
    boolean running = false;

    public void init() {
        x = 0;
    }

    public void start() {
        if (t == null) {
            running = true;
            t = new Thread(this);
            t.start();
        }
    }

    public void run() {

        while (running) {

            x = x + 5;

            if (x > getWidth()) {
                x = 0;
            }

            repaint();

            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public void paint(Graphics g) {
        g.drawString("Simple Animation", 180, 50);

        g.fillOval(x, 130, 40, 40);
    }

    public void stop() {
        running = false;
        t = null;
    }
}
