import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class LibraryBookManagement extends JFrame implements ActionListener {

    JTextField idField, titleField, authorField;
    JComboBox<String> categoryBox;

    JButton addButton, deleteButton, clearButton;

    JTable table;
    DefaultTableModel model;

    LibraryBookManagement() {

        setTitle("Library Book Management");
        setSize(700, 500);
        setLayout(new BorderLayout(10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        inputPanel.add(new JLabel("Book ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Book Title:"));
        titleField = new JTextField();
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Author:"));
        authorField = new JTextField();
        inputPanel.add(authorField);

        inputPanel.add(new JLabel("Category:"));

        String[] categories = {
            "Programming",
            "Database",
            "Networking",
            "Science",
            "Other"
        };

        categoryBox = new JComboBox<>(categories);
        inputPanel.add(categoryBox);

        add(inputPanel, BorderLayout.NORTH);

        // Table
        String[] columns = {
            "Book ID", "Title", "Author", "Category"
        };

        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();

        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {

            String id = idField.getText();
            String title = titleField.getText();
            String author = authorField.getText();
            String category = (String) categoryBox.getSelectedItem();

            if (id.isEmpty() || title.isEmpty() || author.isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Please enter all book details.");

                return;
            }

            model.addRow(new Object[]{
                id, title, author, category
            });

            clearFields();

            JOptionPane.showMessageDialog(this,
                    "Book added successfully.");
        }

        else if (e.getSource() == deleteButton) {

            int selectedRow = table.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(this,
                        "Please select a row to delete.");

            } else {

                model.removeRow(selectedRow);

                JOptionPane.showMessageDialog(this,
                        "Book deleted successfully.");
            }
        }

        else if (e.getSource() == clearButton) {

            clearFields();
        }
    }

    void clearFields() {

        idField.setText("");
        titleField.setText("");
        authorField.setText("");
        categoryBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        new LibraryBookManagement();
    }
}
