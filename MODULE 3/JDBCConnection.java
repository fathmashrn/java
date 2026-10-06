import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Database connection successful!");

            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
    }
}
