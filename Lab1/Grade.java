import java.util.Scanner;
public class Grade {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Marks:");
        double i=sc.nextDouble();

        if (i>100 || i<0)
            System.out.println("Invalid marks!");
        else if (i>90)
            System.out.println("Grade O");
        else if (i>80)
            System.out.println("Grade E");
        else if (i>70)
            System.out.println("Grade A");
        else if (i>60)
            System.out.println("Grade B");
        else if (i>50)
            System.out.println("Grade C");
        else if (i>40)
            System.out.println("Grade D");
        else
            System.out.println("Failed, Eligible for Retest.");
    }
}