import java.util.Random;

public class b1 {
    public static void main(String[] args) {
        float a[]=new float[10];
        Random r=new Random();
        System.out.println("cac phan tu cua mang la: ");
        float s=0;
        for(int i=0;i<10;i++)
        {    a[i]=r.nextInt();
            System.out.print(a[i]+ " ");
            s+=a[i];
        }
        System.out.println();
        System.out.println("tong la: " + s);
    }
    
}
