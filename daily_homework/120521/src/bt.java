import java.util.Scanner;

public class bt {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        if(isInOder(s)) 
            System.out.println("Chuoi duoc sap xep");
        else 
            System.out.println("Chuoi khong duoc sap xep");
        sc.close();
    }
    static boolean isInOder(String s){
        for(int i=0;i<s.length()-1;i++)
            if(s.charAt(i)>s.charAt(i+1))
                return false;
        return true;
    }
    
}
