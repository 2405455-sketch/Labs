import java.util.Scanner;

class studentinfo {
    int rollno;
    String name;

    studentinfo(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }
}

public class StudentEqualsDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter roll number of first student:");
        int r1 = sc.nextInt();
        System.out.println("Enter name of first student:");
        String n1 = sc.next();

        System.out.println("Enter roll number of second student:");
        int r2 = sc.nextInt();
        System.out.println("Enter name of second student:");
        String n2 = sc.next();

        studentinfo s1 = new studentinfo(r1, n1);
        studentinfo s2 = new studentinfo(r2, n2);

        if (s1.equals(s2))
            System.out.println("Both students are equal");
        else
            System.out.println("Students are not equal");
    }
}
