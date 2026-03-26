package Lab7;

import java.util.*;
public class outOfBound {
    public static void main (String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Array Size(Less than 4):");
        int size=sc.nextInt();
        int[] a=new int[4];
        System.out.print("Enter Elements: ");
        try{

            for(int i=0;i<size;i++){
                a[i]=sc.nextInt();
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Exception in thread \"main\" "+e.toString());
        }
    }
}