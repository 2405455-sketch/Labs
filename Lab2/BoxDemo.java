import java.util.Scanner;

class Box {
    double length, width, height;

    Box(double l, double w, double h) {
        length = l;
        width = w;
        height = h;
    }

    double volume() {
        return length * width * height;
    }
}

public class BoxDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length: ");
        double l = sc.nextDouble();
        System.out.print("Enter width: ");
        double w = sc.nextDouble();
        System.out.print("Enter height: ");
        double h = sc.nextDouble();

        Box b = new Box(l, w, h);
        System.out.println("Volume = " + b.volume());
        sc.close();
    }
}
