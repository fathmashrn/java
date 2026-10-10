import java.sql.*;

public class ResultSetMetadataDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "your_password";

        try {
            Connection con =
                DriverManager.getConnection(url, user, password);

            Statement st = con.createStatement();

            ResultSet rs =
                st.executeQuery("SELECT * FROM student");

            ResultSetMetaData md = rs.getMetaData();

            int count = md.getColumnCount();

            System.out.println("Number of Columns: " + count);

            for (int i = 1; i <= count; i++) {
                System.out.println("\nColumn: " +
                                   md.getColumnName(i));

                System.out.println("Data Type: " +
                                   md.getColumnTypeName(i));

                System.out.println("Column Size: " +
                                   md.getColumnDisplaySize(i));

                System.out.println("Nullable: " +
                                   (md.isNullable(i) ==
                                    ResultSetMetaData.columnNullable
                                    ? "Yes" : "No"));
            }

            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
