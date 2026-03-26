interface motor{
    int CAPACITY=15;
    void run();
    void consume();
}

class WashingMachine implements motor{
    public void run(){
        System.out.println("Motor is running");
    }
    public void consume(){
        System.out.println("Power consuming");
    }
}

public class WashingMachineDemo {
    public static void main(String[] args){
        motor m=new WashingMachine();
        m.run();
        m.consume();
        System.out.println("Capacity in Kg:"+ m.CAPACITY);
    }
}