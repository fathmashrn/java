import java.sql.*;

public class DatabaseMetadataDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "your_password";

        try {
            Connection con =
                DriverManager.getConnection(url, user, password);

            DatabaseMetaData md = con.getMetaData();

            System.out.println("Database Name: " +
                               md.getDatabaseProductName());

            System.out.println("Database Version: " +
                               md.getDatabaseProductVersion());

            System.out.println("Driver Name: " +
                               md.getDriverName());

            System.out.println("Driver Version: " +
                               md.getDriverVersion());

            System.out.println("Supports Transactions: " +
                               md.supportsTransactions());

            System.out.println("Supports Stored Procedures: " +
                               md.supportsStoredProcedures());

            System.out.println("\nAvailable Tables:");

            ResultSet rs = md.getTables(
                con.getCatalog(),
                null,
                "%",
                new String[]{"TABLE"}
            );

            while (rs.next()) {
                System.out.println(rs.getString("TABLE_NAME"));
            }

            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
