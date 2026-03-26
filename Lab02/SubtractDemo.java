class Subtract {
    int subtract(int a, int b) {
        return a - b;
    }

    int subtract(int a, int b, int c) {
        return a - b - c;
    }

    double subtract(double a, double b) {
        return a - b;
    }
}

public class SubtractDemo {
    public static void main(String[] args) {
        Subtract s = new Subtract();

        System.out.println("Subtract 10 - 5 = " + s.subtract(10, 5));
        System.out.println("Subtract 20 - 5 - 3 = " + s.subtract(20, 5, 3));
        System.out.println("Subtract 10.5 - 2.5 = " + s.subtract(10.5, 2.5));
    }
}
