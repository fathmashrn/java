import java.io.*;

class FileCopy {
    public static void main(String[] args) {

        try {
            BufferedInputStream bis =
                new BufferedInputStream(
                    new FileInputStream("source.txt"));

            BufferedOutputStream bos =
                new BufferedOutputStream(
                    new FileOutputStream("destination.txt"));

            int ch;

            while ((ch = bis.read()) != -1) {
                bos.write(ch);
            }

            bis.close();
            bos.close();

            System.out.println("File copied successfully.");
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
