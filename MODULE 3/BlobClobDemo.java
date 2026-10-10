import java.sql.*;
import java.io.*;

public class BlobClobDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "your_password";

        File imageFile = new File("sample.jpg");
        File outputImage = new File("retrieved.jpg");

        try {
            Connection con =
                DriverManager.getConnection(url, user, password);

            String sql =
                "INSERT INTO documents (id, image_data, text_data) " +
                "VALUES (?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE " +
                "image_data = VALUES(image_data), " +
                "text_data = VALUES(text_data)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, 1);
            ps.setBinaryStream(2, new FileInputStream(imageFile));
            ps.setCharacterStream(
                3,
                new StringReader("This is a sample document stored in CLOB.")
            );

            ps.executeUpdate();

            System.out.println("Image and text stored successfully.");

            PreparedStatement ps2 = con.prepareStatement(
                "SELECT image_data, text_data FROM documents WHERE id = 1"
            );

            ResultSet rs = ps2.executeQuery();

            if (rs.next()) {
                try (InputStream in = rs.getBinaryStream("image_data");
                     OutputStream out = new FileOutputStream(outputImage)) {

                    byte[] buffer = new byte[4096];
                    int bytesRead;

                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }

                System.out.println("Image retrieved: retrieved.jpg");

                try (Reader reader = rs.getCharacterStream("text_data")) {
                    StringBuilder text = new StringBuilder();
                    char[] buffer = new char[1024];
                    int charsRead;

                    while ((charsRead = reader.read(buffer)) != -1) {
                        text.append(buffer, 0, charsRead);
                    }

                    System.out.println("Document: " + text);
                }
            }

            rs.close();
            ps2.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
