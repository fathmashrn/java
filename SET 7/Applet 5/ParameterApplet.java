import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/*
<applet code="ParameterApplet.class" width="500" height="300">
<param name="background" value="yellow">
<param name="foreground" value="blue">
<param name="message" value="Welcome to Java Applet">
</applet>
*/

public class ParameterApplet extends Applet {

    String message;
    String bg;
    String fg;

    public void init() {

        bg = getParameter("background");
        fg = getParameter("foreground");
        message = getParameter("message");

        if (bg.equalsIgnoreCase("yellow"))
            setBackground(Color.YELLOW);

        else if (bg.equalsIgnoreCase("red"))
            setBackground(Color.RED);

        else if (bg.equalsIgnoreCase("green"))
            setBackground(Color.GREEN);

        else if (bg.equalsIgnoreCase("blue"))
            setBackground(Color.BLUE);

        if (fg.equalsIgnoreCase("blue"))
            setForeground(Color.BLUE);

        else if (fg.equalsIgnoreCase("red"))
            setForeground(Color.RED);

        else if (fg.equalsIgnoreCase("black"))
            setForeground(Color.BLACK);

        else if (fg.equalsIgnoreCase("white"))
            setForeground(Color.WHITE);
    }

    public void paint(Graphics g) {

        g.drawString(message, 150, 130);
    }
}
