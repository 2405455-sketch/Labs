// Question 4
import java.util.Scanner;

class Account{
    int acc_no;
    double balance;

    void input(Scanner sc){
        // scanner object passed as parameter
        System.out.print("Enter account number: ");
        acc_no=sc.nextInt();
        System.out.print("Enter account balance: ");
        balance=sc.nextDouble();
    }

    void disp(){
        System.out.println("Account Number: " +acc_no);
        System.out.println("Balance: " +balance);
    }
}

class Person extends Account{
    String name;
    long aadhar_no;

    void input(Scanner sc){
        System.out.print("Enter person name: ");
        name=sc.next();
        System.out.print("Enter Aadhaar number: ");
        aadhar_no=sc.nextLong();
        super.input(sc);
    }

    void disp(){
        System.out.println("Name: " +name);
        System.out.println("Aadhaar Number: " +aadhar_no);
        System.out.println("Account Number: " +acc_no);
        System.out.println("Balance: " +balance);
    }
}

public class AccDemo{

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Person[] p =new Person[3];

        for(int i=0;i<3;i++){
            System.out.println("Enter details for person " +(i+1));
            p[i]=new Person();
            p[i].input(sc);
        }

        System.out.println("\nDisplaying details of all persons:");
        for(int i=0;i<3;i++){
            p[i].disp();
        }
    }
}
