package Lab3;
//Question 2
import java.util.Scanner;

class Plate{
    int length,width;

    Plate(int l,int w){
        length =l;
        width =w;
        System.out.println("Plate Constructor Called");
        System.out.println("Length: " +length);
        System.out.println("Width: " +width);
    }
}
class Box extends Plate{
    int height;
    Box(int l,int w,int h){
        super(l,w);
        height=h;
        System.out.println("Box Constructor Called");
        System.out.println("Height: " +height);
    }
}
class WoodBox extends Box{
    int thickness;
    WoodBox(int l,int w,int h,int t){
        super(l,w,h);
        thickness=t;
        System.out.println("WoodBox Constructor Called");
        System.out.println("Thickness: "+thickness);
    }
}
public class BoxDemo {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter length: ");
        int l= sc.nextInt();
        System.out.print("Enter width: ");
        int w=sc.nextInt();

        System.out.print("Enter height: ");
        int h=sc.nextInt();

        System.out.print("Enter thickness: ");
        int t=sc.nextInt();
        WoodBox wb = new WoodBox(l,w,h,t);
    }
}