import java.io.*;
import java.util.Scanner;

class FileWrite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter a string: ");
            String str = sc.nextLine();

            FileOutputStream fos =
                new FileOutputStream("output.txt", true);

            fos.write(str.getBytes());
            fos.write('\n');

            fos.close();

            System.out.println("Data written successfully.");
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }

        sc.close();
    }
}
