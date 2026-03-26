import java.util.Scanner;

class Rectangle {
    double length, breadth;

    void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length: ");
        length = sc.nextDouble();
        System.out.print("Enter breadth: ");
        breadth = sc.nextDouble();
    }

    void calculate() {
        System.out.println("Area = " + (length * breadth));
        System.out.println("Perimeter = " + (2 * (length + breadth)));
    }

    void display() {
        calculate();
    }
}

public class RectangleDemo {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.read();
        r.display();
    }
}
