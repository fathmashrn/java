import java.applet.Applet;
import java.awt.Graphics;

/*
<applet code="StudentApplet.class" width="500" height="300">
<param name="name" value="Sherin">
<param name="regno" value="101">
<param name="course" value="BSc Computer Science">
<param name="semester" value="5">
</applet>
*/

public class StudentApplet extends Applet {

    String name;
    String regno;
    String course;
    String semester;

    public void init() {
        name = getParameter("name");
        regno = getParameter("regno");
        course = getParameter("course");
        semester = getParameter("semester");
    }

    public void paint(Graphics g) {

        g.drawString("STUDENT INFORMATION", 150, 50);

        g.drawString("Name       : " + name, 100, 100);
        g.drawString("Register No : " + regno, 100, 130);
        g.drawString("Course     : " + course, 100, 160);
        g.drawString("Semester   : " + semester, 100, 190);
    }
}
