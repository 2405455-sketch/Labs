package Lab7;

import java.util.Scanner;

public class divideBy0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers to divide: ");


        int n1 = sc.nextInt();
        int n2 = sc.nextInt();


        try {

            System.out.println("Result: "+(n1/n2));

        } catch (ArithmeticException e) {
            System.out.println("Exception in thread \"main\" " + e.toString());
        }
    }
}