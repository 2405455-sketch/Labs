package Lab7;

import java.util.Scanner;

class NegativeNumberException extends Exception {
    private int detail;

    NegativeNumberException(int n) {
        detail = n;
    }

    public String toString() {
        return "NegativeNumberException: " + detail;
    }
}

public class ProcessNumber {

    static void processInput(int num) throws NegativeNumberException {
        System.out.println("Processing number: " + num);

        if (num < 0)
            throw new NegativeNumberException(num);

        System.out.println("Double value: " + (num * 2));
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        try {
            processInput(num);
        }
        catch (NegativeNumberException e) {
            System.out.println("Caught " + e);
        }
    }
}
