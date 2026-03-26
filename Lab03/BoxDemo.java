// Question 2
import java.util.Scanner;

class Plate{
    int length,width;

    Plate(int l,int w){
        length =l;
        width =w;
        System.out.println("Creating Plate object");
        System.out.println("Plate Length = " +length);
        System.out.println("Plate Width = " +width);
    }
}

class Box extends Plate{
    int height;

    Box(int l,int w,int h){
        super(l,w);
        height=h;
        System.out.println("Creating Box object");
        System.out.println("Box Height = " +height);
    }
}

class WoodBox extends Box{
    int thick;

    WoodBox(int l,int w,int h,int t){
        super(l,w,h);
        thick=t;
        System.out.println("Creating WoodBox object");
        System.out.println("Wood thickness = " +thick);
    }
}

public class BoxDemo {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter plate length: ");
        int l= sc.nextInt();

        System.out.print("Enter plate width: ");
        int w=sc.nextInt();

        System.out.print("Enter box height: ");
        int h=sc.nextInt();

        System.out.print("Enter wood thickness: ");
        int t=sc.nextInt();

        WoodBox wb = new WoodBox(l,w,h,t);
    }
}
