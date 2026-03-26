package Lab9;
//Q1
import java.util.Scanner;
import java.io.*;
public class StudentDetails {
    public static void main(String []args) throws IOException {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter Student Details\nName:");
        String n=sc.nextLine();
        System.out.print("Roll No:");
        int r=sc.nextInt();
        sc.nextLine();
        System.out.print("Subject:");
        String sn=sc.nextLine();
        System.out.print("Marks:");
        int m=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter File name:");
        String filename=sc.nextLine();

        FileWriter fw=new FileWriter(filename);
        fw.write("Name: "+ n +"\nRoll No: "+ r +"\nSubject: "+ sn +"\nMarks:"+ m);
        fw.close();

        FileReader fr;
        try{
            fr=new FileReader(filename);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not Found!");
            return;
        }
        int num;
        while( (num=fr.read())!=-1)
        {
            System.out.print((char)num);
        }

        fr.close();


    }
}