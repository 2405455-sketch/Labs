package Lab9;
//Q2
import java.util.Scanner;
import java.io.*;

public class CopyPaste {
    public static void main(String []args) throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.print("Source File:");
        String src=sc.nextLine();

        System.out.print("Destination File:");
        String dst=sc.nextLine();

        FileWriter fw=new FileWriter(dst);
        FileReader fr;
        try{
            fr=new FileReader(src);
        }
        catch(FileNotFoundException e){
            System.out.println("File not Found!");
            return;
        }
        int num;
        while( (num=fr.read())!=-1)
            fw.write((char)num);

        fw.close();
        fr.close();
    }
}