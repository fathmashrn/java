import java.io.*;

class FileRead {
    public static void main(String[] args) {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("input.txt");

            int ch;

            while ((ch = fis.read()) != -1) {
                System.out.print((char) ch);
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
        finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            }
            catch (IOException e) {
                System.out.println("Error closing file");
            }
        }
    }
}
