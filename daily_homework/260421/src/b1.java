package src;
import java.util.Scanner;

public class b1{
    public static void main(String[] args) {
        
        System.out.println("nhap he so a,b,c: ");
        Scanner inp=new Scanner(System.in);
        double a,b,c;
        a=inp.nextDouble();
        b=inp.nextDouble();
        c=inp.nextDouble();
        if(a==0)    ptbacnhat(b,c);
        else        ptbachai(a,b,c);
        inp.close();        
    }
    static void ptbacnhat(double b, double c){
        if(b==0){
            if(c==0)    
                System.out.println("phuong trinh vo so nghiem");
            else        
                System.out.println("phuong trinh vo nghiem");
        }
        else            
            System.out.println("phuong trinh co nghiem duy nhat: x= "+ -c/b);
    }
    static void ptbachai(double a,double b, double c){
        double delta=b*b-4*a*c;
        if(delta<0)    
            System.out.println("phuong trinh vo nghiem");
        else
            if(delta==0)    
               System.out.println("phuong trinh co nghiem kep x= "+ -b/2/a);
            else{
                double candel=Math.sqrt(delta);
                double x1=(-b+candel)/2/a;
                double x2=(-b+candel)/2/a;
                System.out.println("phuong trinh co nghiem x1= "+x1+" va x2= "+x2);
            }
    }
}
