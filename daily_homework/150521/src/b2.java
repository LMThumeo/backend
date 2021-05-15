import java.util.*;

public class b2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        addSet(sc);
        sc.close();
    }
    static void addSet(Scanner sc){
        System.out.println("nhap do dai mang: ");
        int lengthArray=sc.nextInt();

        System.out.println("nhap cac phan tu cua mang");
        Set <Integer> diffNum=new HashSet<>();
        for(int i=0;i<lengthArray;i++){
            diffNum.add(sc.nextInt());
        }

        System.out.println(diffNum);
    }
    
}
