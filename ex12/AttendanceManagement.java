
import java.util.Scanner;

public class AttendanceManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] names = new String[n];
        char[] attendance = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            names[i] = sc.nextLine();

            System.out.print("Mark attendance (P/A): ");
            attendance[i] = Character.toUpperCase(sc.next().charAt(0));
            sc.nextLine();

            while (attendance[i] != 'P' && attendance[i] != 'A') {
                System.out.print("Invalid input! Enter P or A: ");
                attendance[i] = Character.toUpperCase(sc.next().charAt(0));
                sc.nextLine();
            }
        }

        System.out.println("\n===== ATTENDANCE REPORT =====");
        System.out.printf("%-20s %-15s%n", "Student Name", "Attendance");
        System.out.println("-----------------------------------");

        for (int i = 0; i < n; i++) {
            String status = (attendance[i] == 'P') ? "Present" : "Absent";
            System.out.printf("%-20s %-15s%n", names[i], status);
        }

        int present = 0;

        for (int i = 0; i < n; i++) {
            if (attendance[i] == 'P') {
                present++;
            }
        }

        int absent = n - present;

        System.out.println("-----------------------------------");
        System.out.println("Total Students : " + n);
        System.out.println("Present        : " + present);
        System.out.println("Absent         : " + absent);

        double percentage = (present * 100.0) / n;
        System.out.printf("Attendance Percentage: %.2f%%%n", percentage);

        sc.close();
    }
}