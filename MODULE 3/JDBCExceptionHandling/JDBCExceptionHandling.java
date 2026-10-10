import java.sql.*;
import java.util.Scanner;

public class JDBCExceptionHandling {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "your_password";

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter employee ID: ");

            int id;

            try {
                id = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
                return;
            }

            System.out.print("Enter employee name: ");
            String name = sc.nextLine();

            System.out.print("Enter salary: ");

            double salary;

            try {
                salary = Double.parseDouble(sc.nextLine().trim());

                if (!Double.isFinite(salary) || salary < 0) {
                    System.out.println("Invalid salary.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid salary. Enter a number.");
                return;
            }

            try (Connection con =
                     DriverManager.getConnection(url, user, password)) {

                String sql =
                    "INSERT INTO employee (id, name, salary) " +
                    "VALUES (?, ?, ?)";

                try (PreparedStatement ps =
                         con.prepareStatement(sql)) {

                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setDouble(3, salary);

                    ps.executeUpdate();

                    System.out.println("Employee inserted successfully.");
                } catch (SQLIntegrityConstraintViolationException e) {
                    System.out.println(
                        "Duplicate employee ID or constraint violation."
                    );
                } catch (SQLException e) {
                    System.out.println(
                        "SQL Error: " + e.getMessage()
                    );
                }
            } catch (SQLException e) {
                System.out.println(
                    "Connection Error: " + e.getMessage()
                );
            }
        }
    }
}
