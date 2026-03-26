import java.util.Scanner;

interface Salary {
    void earnings();
    void deductions();
    void bonus();
}

class Manager implements Salary{
    double bs,er,ded,bo,DA,HRA;
    Manager(double bs){
        this.bs=bs;
        DA=bs*0.8;
        HRA=bs*0.15;
    }
    public void earnings(){
        er=bs+DA+HRA;
        System.out.println("Earnings:"+er);
    }

    public void deductions(){
        ded=bs*0.12;
        System.out.println("Deductions:"+ded);
    }
    public void bonus() {

    }
}

class Substaff extends Manager{
    double bo;
    Substaff(double bs){
        super(bs);
        bo=bs*0.5;
    }
    public void bonus(){
        System.out.println("Bonus:"+bo);
    }

}

public class ManagerDemo {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Basic Salary:");
        double bs=sc.nextDouble();
        Substaff s=new Substaff(bs);
        s.earnings();
        s.deductions();
        s.bonus();
    }
}