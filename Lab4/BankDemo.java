import java.util.Scanner;

class Account {
    static int nextAccNo = 1001;

    int accountNumber;
    String name;
    String accountType;
    double balance;
    int day, month, year;

    Account(String name, String accountType, double balance,
            int d, int m, int y) {
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
        this.accountNumber = nextAccNo++;
        day = d;
        month = m;
        year = y;
    }

    void checkBalance() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Type: " + accountType);
        System.out.println("Balance: " + balance);
        System.out.println("Last Deposit Date: " + day + "/" + month + "/" + year);
    }

    void deposit(double amount, int d, int m, int y) {
        balance += amount;
        day = d;
        month = m;
        year = y;
        System.out.println("Amount deposited: " + amount);
        System.out.println("Current Balance: " + balance);
    }

    void withdraw(double amount) {
        System.out.println("Withdrawal from Account");
    }
}

class StandardAccount extends Account {

    StandardAccount(String name, double balance, int d, int m, int y) {
        super(name, "Standard", balance, d, m, y);
    }

    void withdraw(double amount) {
        if (amount <= 100000) {
            balance -= amount;
            System.out.println("Standard withdrawal without penalty");
        } else if (amount <= 500000) {
            double penalty = amount * 0.0005;
            balance -= (amount + penalty);
            System.out.println("Standard withdrawal with penalty: " + penalty);
        } else {
            System.out.println("Standard withdrawal limit exceeded");
            return;
        }
        System.out.println("Remaining Balance: " + balance);
    }
}

class PremiumAccount extends Account {

    PremiumAccount(String name, double balance, int d, int m, int y) {
        super(name, "Premium", balance, d, m, y);
    }

    void withdraw(double amount) {
        if (amount <= 1000000) {
            balance -= amount;
            System.out.println("Premium withdrawal successful");
        } else {
            System.out.println("Premium daily limit exceeded");
            return;
        }
        System.out.println("Remaining Balance: " + balance);
    }
}

public class BankDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter account type (S/P): ");
        char type = sc.next().charAt(0);

        System.out.print("Enter initial balance: ");
        double bal = sc.nextDouble();

        System.out.print("Enter last deposit date (dd mm yyyy): ");
        int d = sc.nextInt();
        int m = sc.nextInt();
        int y = sc.nextInt();

        /* 🔧 ONLY THIS PART WAS WRONG BEFORE — NOW FIXED */
        Account acc;

        if (type == 'S' || type == 's') {
            acc = new StandardAccount(name, bal, d, m, y);
        } else {
            acc = new PremiumAccount(name, bal, d, m, y);
        }
        /* 🔧 FIX ENDS HERE */

        acc.checkBalance();

        System.out.print("Enter deposit amount: ");
        acc.deposit(sc.nextDouble(), d, m, y);

        System.out.print("Enter withdrawal amount: ");
        acc.withdraw(sc.nextDouble());
    }
}
