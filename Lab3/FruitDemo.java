package Lab3;
//Question 3
class Fruit {
    void show() {
        System.out.println("This is a fruit");
    }
}
class Banana extends Fruit {
    void show() {
        System.out.println("This is a banana");
    }
}
class Cherry extends Fruit {
    void show() {
        System.out.println("This is a cherry");
    }
}
public class FruitDemo {
    public static void main(String[] args) {
        Fruit f = new Fruit();
        Banana b = new Banana();
        Cherry c = new Cherry();
        f.show();
        b.show();
        c.show();
    }
}