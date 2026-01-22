import java.util.Scanner;
import Marketing.Sales;

public class MainEarningDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the employee id and employee name: ");
        int id = sc.nextInt();
        String name = sc.next();

        System.out.print("Enter the basic salary: ");
        double basic = sc.nextDouble();

        Sales s = new Sales(id, name, basic);

        double totalEarning = s.earnings(); // DO NOT add travelling allowance

        System.out.println("The emp id of the employee is " + id);
        System.out.println("The total earning is " + totalEarning);
    }
}
