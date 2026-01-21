import java.util.Scanner;

interface Employee{

    void getDetails();
}

interface manager1 extends Employee{
    void getDeptDetails();
}

class Head implements manager1{
    int Empid,Deptid;
    String Ename,Deptname;
    Head(){
        Empid=-1;
        Deptid=-1;
        Ename="PLACEHOLDER";
        Deptname="PLACEHOLDR";
    }
    Scanner sc=new Scanner(System.in);
    public void getDetails() {
        System.out.println("Enter Employee ID: ");
        Empid= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Employee Name: ");
        Ename= sc.nextLine();
    }

    public void getDeptDetails() {

        System.out.println("Enter Department ID: ");
        Deptid= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Department Name: ");
        Deptname= sc.nextLine();
    }

}

public class HeadDemo {
    public static void main(String[] args){
        Head h=new Head();
        h.getDetails();
        h.getDeptDetails();
        System.out.println("Employee ID: "+h.Empid);
        System.out.println("Employee Name: "+h.Ename);
        System.out.println("Department ID: "+h.Deptid);
        System.out.println("Department Name: "+h.Deptname);
    }
}