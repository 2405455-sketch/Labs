import java.util.Scanner;
// question 1
class Sheet {
    double length, width;
    final double RATE_2D = 40;

    void input2D() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length: ");
        length = sc.nextDouble();
        System.out.print("Enter width: ");
        width = sc.nextDouble();
    }

    double cost2D() {
        return length * width * RATE_2D;
    }
}

class Box extends Sheet {
    double height;
    final double RATE_3D = 60;

    void input3D() {
        input2D();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter height: ");
        height = sc.nextDouble();
    }

    double cost3D() {
        return length * width * height * RATE_3D;
    }
}

public class PlasticCost {
    public static void main(String[] args) {
        Box b = new Box();
        b.input3D();

        System.out.println("Cost of plastic sheet = Rs " + b.cost2D());
        System.out.println("Cost of plastic box = Rs " + b.cost3D());
    }
}
