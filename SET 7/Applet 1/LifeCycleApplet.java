import java.applet.Applet;
import java.awt.Graphics;

/*
<applet code="LifeCycleApplet.class" width="500" height="300">
</applet>
*/

public class LifeCycleApplet extends Applet {

    public void init() {
        System.out.println("init() method is called");
    }

    public void start() {
        System.out.println("start() method is called");
    }

    public void paint(Graphics g) {
        g.drawString("Applet Life Cycle", 150, 100);
        g.drawString("Check the console for life-cycle methods.", 80, 140);

        System.out.println("paint() method is called");
    }

    public void stop() {
        System.out.println("stop() method is called");
    }

    public void destroy() {
        System.out.println("destroy() method is called");
    }
}
