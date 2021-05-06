import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class b1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num;
        System.out.println("nhap so co 4 chu so: ");
        num=sc.nextInt();
        Map<String, String> m=new HashMap<>();
        m.put("0","khong");
        m.put("1","mot");
        m.put("2","hai");
        m.put("3","ba");
        m.put("4","bon");
        m.put("5","nam");
        m.put("6","sau");
        m.put("7","bay");
        m.put("8","tam");
        m.put("9","chin");
        String numStr=Integer.toString(num);
        for(int i=0;i<numStr.length();i++)
            System.out.print(m.get(Character.toString(numStr.charAt(i)))+" ");
        sc.close();
    }
}
