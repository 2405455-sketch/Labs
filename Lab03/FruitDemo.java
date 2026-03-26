// Question 3, dynamic method allocatiom
class Fruit {
    void show() {
        System.out.println("This is a generic fruit");
    }
}

class Banana extends Fruit {
    void show() {
        System.out.println("This fruit is a banana");
    }
}

class Cherry extends Fruit {
    void show() {
        System.out.println("This fruit is a cherry");
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
