import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class b3 {
    public static void main(String[] args) throws FileNotFoundException {
        List<que_ans> l=reader();
        Scanner sc=new Scanner(System.in);
        
        //tron
        List<Integer> a=new ArrayList<>(l.size());
        for(int i=0;i<l.size();i++)
            a.add(i);
        Collections.shuffle(a);

        //
        System.out.println("sau moi cau hoi, hay nhap dap an va nhan enter");
        int score=0;
        for(int i=0;i<5;i++){
            int j=a.get(i);
            l.get(j).display();
            String ans=sc.next();
            while(!ans.equalsIgnoreCase("a")&&
                 !ans.equalsIgnoreCase("b")&&
                 !ans.equalsIgnoreCase("c")&&
                 !ans.equalsIgnoreCase("d")   ) {
                    System.out.println("ban hay nhap lai dap an!");
                    ans=sc.next();                
                 }        
               
            if(ans.equalsIgnoreCase(l.get(j).getAns()))  
            {    System.out.println("---Chuc mung!!! Dap an dung roi---"); 
                
                 score+=2;
            }
            else System.out.println(">v< Khong biet con luoi tra Google >v<");
        }
        System.out.println("-----------------------------------------------------------------------------");
        if(score<=5)    
            System.out.println(score+" ==> Mo sach mo vo ra hoc lai di");
        else 
            if(score<8) 
                System.out.println(score+" ==> Hoc tiep di, chua gioi dau");
            else System.out.println(score+" ==> Doi do, chua chac lan sau de the dau!");      
        sc.close();
    }
    static List<que_ans> reader() throws FileNotFoundException{
        List<que_ans> l=new ArrayList<>();
        File file=new File("F:\\backend\\lessonFriday\\230421\\b3inp.txt");
        Scanner sc=new Scanner(file);
        while(sc.hasNextLine()){
            String ques=sc.nextLine();
            System.out.println(ques);
            String a=sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            String d=sc.nextLine();
            String ans=sc.nextLine();
            l.add(new que_ans(ques, a, b, c, d, ans));
        }
        sc.close();
        return l;    
    }
    
}
