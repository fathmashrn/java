import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentCRUD {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "root";

        try {
    
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Connected to database.");

            Statement stmt = con.createStatement();

            String createTable = "CREATE TABLE IF NOT EXISTS student (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "age INT, " +
                    "course VARCHAR(50))";

            stmt.executeUpdate(createTable);
            System.out.println("Student table created.");

            String insert = "INSERT INTO student VALUES " +
                    "(1, 'Arun', 20, 'BCA'), " +
                    "(2, 'Anu', 21, 'BSc Computer Science'), " +
                    "(3, 'Rahul', 20, 'BCA')";

            try {
                stmt.executeUpdate(insert);
                System.out.println("Records inserted successfully.");
            } catch (SQLException e) {
                System.out.println("Records may already exist.");
            }

            System.out.println("\nStudent Records:");

            String select = "SELECT * FROM student";
            ResultSet rs = stmt.executeQuery(select);

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age") +
                        ", Course: " + rs.getString("course")
                );
            }

            String update = "UPDATE student SET age = 22 WHERE id = 2";

            stmt.executeUpdate(update);
            System.out.println("\nRecord updated successfully.");

            String delete = "DELETE FROM student WHERE id = 3";

            stmt.executeUpdate(delete);
            System.out.println("Record deleted successfully.");

            System.out.println("\nRecords after UPDATE and DELETE:");

            rs = stmt.executeQuery("SELECT * FROM student");

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age") +
                        ", Course: " + rs.getString("course")
                );
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("SQL Error.");
            e.printStackTrace();
        }
    }
}
