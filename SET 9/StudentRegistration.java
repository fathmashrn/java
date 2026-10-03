import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistration extends JFrame implements ActionListener {

    JLabel nameLabel, regLabel, genderLabel, courseLabel, hobbyLabel;
    JTextField nameField, regField;
    JRadioButton male, female;
    ButtonGroup genderGroup;
    JComboBox<String> courseBox;
    JCheckBox reading, sports, music;
    JButton submit, clear;

    StudentRegistration() {
        setTitle("Student Registration Form");
        setSize(450, 400);
        setLayout(new GridLayout(7, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nameLabel = new JLabel("Student Name:");
        regLabel = new JLabel("Register Number:");
        genderLabel = new JLabel("Gender:");
        courseLabel = new JLabel("Course:");
        hobbyLabel = new JLabel("Hobbies:");

        nameField = new JTextField();
        regField = new JTextField();

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JPanel genderPanel = new JPanel();
        genderPanel.add(male);
        genderPanel.add(female);

        String[] courses = {"BSc Computer Science", "BCA", "BCom", "BA"};
        courseBox = new JComboBox<>(courses);

        reading = new JCheckBox("Reading");
        sports = new JCheckBox("Sports");
        music = new JCheckBox("Music");

        JPanel hobbyPanel = new JPanel();
        hobbyPanel.add(reading);
        hobbyPanel.add(sports);
        hobbyPanel.add(music);

        submit = new JButton("Submit");
        clear = new JButton("Clear");

        submit.addActionListener(this);
        clear.addActionListener(this);

        add(nameLabel);
        add(nameField);

        add(regLabel);
        add(regField);

        add(genderLabel);
        add(genderPanel);

        add(courseLabel);
        add(courseBox);

        add(hobbyLabel);
        add(hobbyPanel);

        add(submit);
        add(clear);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submit) {

            String gender = "";

            if (male.isSelected())
                gender = "Male";
            else if (female.isSelected())
                gender = "Female";

            String hobbies = "";

            if (reading.isSelected())
                hobbies += "Reading ";

            if (sports.isSelected())
                hobbies += "Sports ";

            if (music.isSelected())
                hobbies += "Music ";

            JOptionPane.showMessageDialog(this,
                    "Student Name: " + nameField.getText()
                    + "\nRegister Number: " + regField.getText()
                    + "\nGender: " + gender
                    + "\nCourse: " + courseBox.getSelectedItem()
                    + "\nHobbies: " + hobbies);
        }

        if (e.getSource() == clear) {
            nameField.setText("");
            regField.setText("");
            genderGroup.clearSelection();
            courseBox.setSelectedIndex(0);
            reading.setSelected(false);
            sports.setSelected(false);
            music.setSelected(false);
        }
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}
