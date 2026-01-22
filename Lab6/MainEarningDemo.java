import java.util.Scanner;
import Marketing.Sales;

public class MainEarningDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee id and name: ");
        int id = sc.nextInt();
        String name = sc.next();

        System.out.print("Enter the basic salary: ");
        double basic = sc.nextDouble();

        Sales s = new Sales(id, name, basic);
        double total = s.earnings() + s.allowance();

        System.out.println("The emp id of the employee is " + id);
        System.out.println("The total earning is " + total);
    }
}
