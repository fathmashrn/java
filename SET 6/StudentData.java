import java.io.*;
import java.util.Scanner;

class StudentData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter roll number: ");
            int roll = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks: ");
            double marks = sc.nextDouble();

            DataOutputStream dos =
                new DataOutputStream(
                    new FileOutputStream("student.dat"));

            dos.writeInt(roll);
            dos.writeUTF(name);
            dos.writeDouble(marks);

            dos.close();

            DataInputStream dis =
                new DataInputStream(
                    new FileInputStream("student.dat"));

            int r = dis.readInt();
            String n = dis.readUTF();
            double m = dis.readDouble();

            dis.close();

            System.out.println("\nStudent Details");
            System.out.println("Roll Number: " + r);
            System.out.println("Name: " + n);
            System.out.println("Marks: " + m);
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }

        sc.close();
    }
}
