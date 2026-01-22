class Bank {
    int rate = 5;

    static class InterestCalculator {
        static double simpleInterest(double p, double t, double r) {
            return (p * t * r) / 100;
        }
    }
}

public class BankDemo {
    public static void main(String[] args) {
        double si = Bank.InterestCalculator.simpleInterest(10000, 2, 5);
        System.out.println("Simple Interest = " + si);

        // Bank.InterestCalculator cannot access non-static member 'rate' directly
    }
}
