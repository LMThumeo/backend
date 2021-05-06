import java.util.Scanner;

public class b2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap n: ");
        int n=sc.nextInt();
        System.out.println("cac so hoan hao be hon n: ");
        for(int i=1;i<=n;i++)
            if(soHoanHao(i))    System.out.print(i+" ");
        sc.close();
    }
    static boolean soHoanHao(int n){
        int sum=0;
        for(int i=2;i<=Math.sqrt(n);i++)
            if(n % i==0){
                sum+=i;
                if(i*i!=n)  sum+=n/i;
            }
        return sum+1==n;              
    }
}
