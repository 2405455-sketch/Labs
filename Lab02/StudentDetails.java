import java.util.Scanner;

class Student {
    int roll;
    String name;
    double cgpa;
}

public class StudentDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Student[] s = new Student[n];
        double minCgpa;
        int minIndex = 0;

        for (int i = 0; i < n; i++) {
            s[i] = new Student();
            System.out.print("Enter roll: ");
            s[i].roll = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter name: ");
            s[i].name = sc.nextLine();
            System.out.print("Enter CGPA: ");
            s[i].cgpa = sc.nextDouble();
        }

        minCgpa = s[0].cgpa;
        for (int i = 1; i < n; i++) {
            if (s[i].cgpa < minCgpa) {
                minCgpa = s[i].cgpa;
                minIndex = i;
            }
        }

        System.out.println("\nStudent Details:");
        for (int i = 0; i < n; i++) {
            System.out.println(s[i].roll + " " + s[i].name + " " + s[i].cgpa);
        }

        System.out.println("\nStudent with lowest CGPA: " + s[minIndex].name);
        sc.close();
    }
}
