import java.io.*;
import java.util.Scanner;

class EmployeeRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            DataOutputStream dos =
                new DataOutputStream(
                    new FileOutputStream("employee.dat", true));

            dos.writeInt(id);
            dos.writeUTF(name);
            dos.writeDouble(salary);

            dos.close();

            System.out.println("\nEmployee details stored.");

            DataInputStream dis =
                new DataInputStream(
                    new FileInputStream("employee.dat"));

            System.out.println("\nStored Employee Details:");

            while (true) {
                try {
                    int empId = dis.readInt();
                    String empName = dis.readUTF();
                    double empSalary = dis.readDouble();

                    System.out.println("-------------------");
                    System.out.println("ID: " + empId);
                    System.out.println("Name: " + empName);
                    System.out.println("Salary: " + empSalary);
                }
                catch (EOFException e) {
                    break;
                }
            }

            dis.close();
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }

        sc.close();
    }
}
