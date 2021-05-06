import java.util.Scanner;

public class b1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String c="";
        String inp="";
        do{
            inp+=c;
            c=sc.next();            
        }
        while(!c.equals("A"));
        System.out.println("cac ki tu da nhap: "+inp);
        sc.close();
    }
        
}
