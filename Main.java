import java.io.*;
import java.util.*;
class doc
{
    Scanner sc = new Scanner(System.in);
    String f,f_1;

    void open()
    {
        try{

            System.out.println("enter the file name: ");
            f= sc.next();

            File f2 = new File(f+"_personal.txt");
            File f_2 = new File(f+"_balance.txt");
            if(f2.createNewFile())
            {
                if(f_2.createNewFile())
                {
                    System.out.println("File Create Successful");
                }

            }
            else
            {
                System.out.println("File Already Create");
            }
            if(f2.exists())
            {
                FileWriter f1=new FileWriter(f+"_personal.txt");
                FileWriter f_1=new FileWriter(f+"_balance.txt");
                System.out.println("enter name: ");
                String n1= sc.next();
                System.out.println("enter DOB: ");
                String g= sc.next();
                System.out.println("enter pan num: ");
                String s= sc.next();
                System.out.println("enter phone num: ");
                String p= sc.next();
                System.out.println("enter pincode: ");
                int b= sc.nextInt();
                System.out.println("enter initial amt: ");
                int n2= sc.nextInt();


                f1.write("name\t"+n1+"\nDOB\t"+g+"\npan number\t"+s+"\nphone number\t"+p+"\npincode\t"+b);
                f_1.write("\ninitial amount\t"+n2);
                f_1.close();
                f1.close();

            }
            else
            {
                System.out.println("File not Found");
            }


        }catch (IOException e){
            System.out.println(e);
        }
    }
    void read()
    {
        try{
            System.out.println("enter file name: ");
            f= sc.next();
            f=f+"_balance.txt";
            File f1=new File(f);
            Scanner read=new Scanner(f1);
            while (read.hasNextLine()){
                String r1=read.nextLine();
                System.out.println(r1);
            }

        }catch (IOException e){
            System.out.println(e);
        }
    }
    void del()
    {
        System.out.println("enter the file name: ");
        f= sc.next();

        File f2 = new File(f+"_personal.txt");
        File f_2 = new File(f+"_balance.txt");
        if(f2.delete() && f_2.delete())
        {
            System.out.println("File Del "+f2.getName()+f_2.getName());
        }
        else
        {
            System.out.println("File Not Found");
        }

    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        doc d1 = new doc();


        while (true){
            System.out.println("1.open account\n2.view balance\n3.delete account\n0.exit\n");
            System.out.println("enter the option: ");
            int op = sc.nextInt();
            if(op==0)
            {
                break;
            }
            else
            {
                switch (op){

                    case 1:
                        d1.open();
                        break;
                    case 2:
                        d1.read();
                        break;
                    case 3:
                        d1.del();
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
            }

        }
    }
}
