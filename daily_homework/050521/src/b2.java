import java.util.InputMismatchException;
import java.util.Scanner;

public class b2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int thang;     
        Exception e1=new Exception("khong co thang nay");
        try {
            System.out.println("nhap vao 1 thang bang so: ");
            thang=sc.nextInt();
            sc. close();
             
            if(thang>12||thang<1)
                throw e1;
            System.out.println("Ban da nhap dung");
        } catch (InputMismatchException e) {
            System.out.println("ban phai nhap 1 so nguyen");
        } catch (Exception e2) {           
            System.out.println(e2.getMessage());
        }         
       
    }
    
}
