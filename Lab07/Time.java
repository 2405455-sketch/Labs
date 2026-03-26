package Lab7;

import java.util.Scanner;

class HrsException extends Exception {
    private String detail;

    HrsException(String msg) {
        detail = msg;
    }

    public String toString() {
        return "InvalidHourException:" + detail;
    }
}

class MinException extends Exception {
    private String detail;

    MinException(String msg) {
        detail = msg;
    }

    public String toString() {
        return "InvalidMinuteException:" + detail;
    }
}

class SecException extends Exception {
    private String detail;

    SecException(String msg) {
        detail = msg;
    }

    public String toString() {
        return "InvalidSecondException:" + detail;
    }
}

public class Time {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Hours: ");
        int h = sc.nextInt();

        System.out.print("Enter Minutes: ");
        int m = sc.nextInt();

        System.out.print("Enter Seconds: ");
        int s = sc.nextInt();

        if (h < 0 || h > 24) {
            try {
                throw new HrsException("hour is not greater than 24");
            } catch (HrsException e) {
                System.out.println("Exception occurred:  " + e);
            }
        }

        if (m < 0 || m > 60) {
            try {
                throw new MinException("hour is not greater than 60");
            } catch (MinException e) {
                System.out.println("Exception occurred:  " + e);
            }
        }

        if (s < 0 || s > 60) {
            try {
                throw new SecException("hour is not greater than 60");
            } catch (SecException e) {
                System.out.println("Exception occurred:  " + e);
            }
        }
    }
}