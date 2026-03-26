class Count {
    static int objects = 0;

    Count() {
        objects++;
    }
}

public class ObjectCount {
    public static void main(String[] args) {
        Count c1 = new Count();
        Count c2 = new Count();
        Count c3 = new Count();

        System.out.println("Number of objects created = " + Count.objects);
    }
}
