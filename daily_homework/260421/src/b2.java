package src;
public class b2 {
    public static void main(String[] args) {
        int n=100;
        sang(n);
    }
    
    static void sang(int n){
        boolean check[]= new boolean[n+1];
        for(int i=0;i<=n;i++)            check[i]=true;    
        for(int i=2;i*i<=n;i++)
            if(check[i])
                for(int j=i*i;j<=n;j+=i)
                    check[j]=false;
                  
        for(int i=2;i<=n;i++)
            if(check[i])    
                System.out.print(i+ " ");
        System.out.println();
    }
}

