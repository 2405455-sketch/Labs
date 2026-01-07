// Question 1
import java.util.Scanner;

class Plastic2D
{
    double l,b,area,cost;

    Plastic2D(double len, double bre)
    {
        l=len;
        b=bre;
        area=l*b;
        cost=area*40;
    }
}

class Plastic3D extends Plastic2D
{
    double vol,h;
    Plastic3D(double len, double bre,double hei){
        super(len,bre);

        h=hei;
        vol=area*h;
        cost=area*60;
    }
}

public class Plastic {

    public static void main(String[] args)
    {
        System.out.println("Enter number of dimensions (2 or 3):");
        Scanner sc=new Scanner(System.in);
        int dim=sc.nextInt();

        System.out.println("Enter length:");
        double l = sc.nextDouble();
        System.out.println("Enter breadth:");
        double b = sc.nextDouble();
        Plastic2D o1=new Plastic2D(l,b);

        double cost;

        if (dim==3) {

            System.out.println("Enter height:");
            double h = sc.nextDouble();
            Plastic3D o2=new Plastic3D(l,b,h);
            cost=o2.cost;
        }
        else
        {
            cost=o1.cost;
        }

        System.out.println("Total cost: " + cost);
    }
}
