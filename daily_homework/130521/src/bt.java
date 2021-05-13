import java.util.Scanner;

public class bt {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       
        System.out.println("nhap do dai mang: ");
        int n=sc.nextInt();
        int a[]=new int[n+5];
        System.out.println("nhap cac phan tu cua mang: ");
        for(int i=0;i<n;i++)    
            a[i]=sc.nextInt();

        int min=a[0];
        int diffMax=a[1]-a[0];
        int start=0, end=1;
        for(int i=1;i<n;i++){
            if(a[i]-min>diffMax){
                diffMax=a[i]-min;
                end=i;
            }
            if(a[i]<min)    min=a[i];
        }
        for(int i=0;i<end;i++)
            if(a[end]-diffMax==a[i]){
                start=i;
                break;
            }
        System.out.println("max: "+diffMax);
        System.out.println("vi tri: "+(start+1)+" "+(end+1));
        
        sc.close();
    }
    
}
