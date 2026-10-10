import java.sql.*;

public class ResultSetNavigation {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "your_password";

        try {
            Connection con =
                DriverManager.getConnection(url, user, password);

            Statement st = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
            );

            ResultSet rs =
                st.executeQuery("SELECT * FROM student ORDER BY id");

            if (rs.next()) {
                System.out.println("Next: " + rs.getString("name"));
            }

            if (rs.next()) {
                System.out.println("Next: " + rs.getString("name"));
            }

            if (rs.previous()) {
                System.out.println("Previous: " + rs.getString("name"));
            }

            if (rs.first()) {
                System.out.println("First: " + rs.getString("name"));
            }

            if (rs.last()) {
                System.out.println("Last: " + rs.getString("name"));
            }

            if (rs.absolute(2)) {
                System.out.println("Absolute(2): " +
                                   rs.getString("name"));
            }

            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
