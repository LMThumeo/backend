import java.io.FileNotFoundException;
import java.util.*;

public class cau3 {
    public static void main(String[] args) throws FileNotFoundException {        
        Scanner sc=new Scanner(System.in);

        System.out.println("nhap chuoi thu nhat: ");
        Map<String, Integer> m=new HashMap<>();
        String s=sc.nextLine();
        StringTokenizer sTokenizer=new StringTokenizer(s);
        while(sTokenizer.hasMoreTokens()){
            String sTemp=sTokenizer.nextToken();
            if(m.containsKey(sTemp))
                m.replace(sTemp, m.get(sTemp)+1);
            else m.put(sTemp,1);
        }
        System.out.println("nhap chuoi thu 2: ");
        Set<String> set=new HashSet<>();
        s=sc.nextLine();
        sTokenizer=new StringTokenizer(s);
        while(sTokenizer.hasMoreTokens())
            set.add(sTokenizer.nextToken());

        for (String i : set) {
            if(m.containsKey(i))
                System.out.println(i+": "+m.get(i));
        }
        sc.close();
    }
    
}
