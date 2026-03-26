import java.util.*;
public class StudentID {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Name:");
        String name=sc.nextLine();

        System.out.println("Enter Branch:");
        String branch=sc.nextLine();

        System.out.println("Enter Roll No:");
        int roll=sc.nextInt();

        System.out.println("Enter Section: CSE-");
        int section=sc.nextInt();
        System.out.println("Name:"+name+"\nRoll no:"+roll+"\nSection:"+section+"\nBranch:"+branch);
    }
}