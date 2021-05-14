import java.util.Scanner;

public class bt {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String inputString=sc.nextLine();
        splitWord(inputString);
        sc.close();
    }
    static void splitWord(String s)
    {   String[] word=s.split("[ .,!?]+");
        for (String string : word) {
            System.out.println(string);
        }
    }   
}
