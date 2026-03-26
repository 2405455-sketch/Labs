import java.util.Scanner;

abstract class Student {
    int rollNo;
    long regNo;

    void getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Rollno: ");
        rollNo = sc.nextInt();
        System.out.print("Enter Registration no: ");
        regNo = sc.nextLong();
    }

    abstract void course();
}

class Kiitian extends Student {
    void course() {
        System.out.println("Course - B.Tech. (Computer Science & Engg)");
    }
}

public class AbstractStudentDemo {
    public static void main(String[] args) {

        Student s = new Kiitian();
        s.getInput();

        System.out.println("Rollno - " + s.rollNo);
        System.out.println("Registration no - " + s.regNo);
        s.course();
    }
}
