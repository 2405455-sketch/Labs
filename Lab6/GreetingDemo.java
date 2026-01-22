interface Greeting {
    void sayHello();
}

public class GreetingDemo {
    public static void main(String[] args) {

        Greeting g = new Greeting() {
            public void sayHello() {
                System.out.println("Hello! Welcome to Java Programming.");
            }
        };

        g.sayHello();
    }
}

