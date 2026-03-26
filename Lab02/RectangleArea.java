class Rectangle1 {
    double length, breadth;

    Rectangle1() {
        length = 0;
        breadth = 0;
    }

    Rectangle1(double l, double b) {
        length = l;
        breadth = b;
    }

    double area() {
        return length * breadth;
    }
}

public class RectangleArea {
    public static void main(String[] args) {
        Rectangle1 r1 = new Rectangle1();
        Rectangle1 r2 = new Rectangle1(5, 4);

        System.out.println("Area (default constructor) = " + r1.area());
        System.out.println("Area (parameterized constructor) = " + r2.area());
    }
}
