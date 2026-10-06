import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentRegistration {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "root";

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
          
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Connected to database successfully.");

            String createTable = "CREATE TABLE IF NOT EXISTS student (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "age INT, " +
                    "course VARCHAR(50))";

            PreparedStatement createStmt = con.prepareStatement(createTable);
            createStmt.executeUpdate();
            createStmt.close();

            System.out.println("\n--- Student Registration ---");

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            String insertSQL =
                    "INSERT INTO student (id, name, age, course) VALUES (?, ?, ?, ?)";

            PreparedStatement insertStmt = con.prepareStatement(insertSQL);

            insertStmt.setInt(1, id);
            insertStmt.setString(2, name);
            insertStmt.setInt(3, age);
            insertStmt.setString(4, course);

            int rows = insertStmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Student registered successfully.");
            }

            insertStmt.close();

            System.out.println("\n--- Search Student ---");

            System.out.print("Enter Student ID to search: ");
            int searchId = sc.nextInt();

            String searchSQL =
                    "SELECT * FROM student WHERE id = ?";

            PreparedStatement searchStmt = con.prepareStatement(searchSQL);

            searchStmt.setInt(1, searchId);

            ResultSet rs = searchStmt.executeQuery();

            if (rs.next()) {
                System.out.println("\nStudent Found!");
                System.out.println("ID     : " + rs.getInt("id"));
                System.out.println("Name   : " + rs.getString("name"));
                System.out.println("Age    : " + rs.getInt("age"));
                System.out.println("Course : " + rs.getString("course"));
            } else {
                System.out.println("Student not found.");
            }

            // Close resources
            rs.close();
            searchStmt.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
