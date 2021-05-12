
import java.util.Scanner;

public class b1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        
        if( (a+b<=c)||(a+c<=b) || (b+c<=a))
            System.out.println("day khong la tam giac");
        else{
            System.out.println("day la mot tam giac.");
            System.out.println("dien tich: "+ dienTich(a, b, c));
            System.out.println("chu vi: "+chuVi(a, b, c));
        }
        sc.close();
    }
    static int chuVi(int a, int b, int c){
        return a+b+c;
    }
    static double dienTich(int a, int b, int c){
        double p=chuVi(a, b, c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }    
    
}
