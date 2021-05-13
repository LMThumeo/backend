import java.io.FileNotFoundException;
import java.util.Scanner;

public class PredictLuckyWordGame {
    public static void main(String[] args) throws FileNotFoundException {
        PredictLuckyWordGame luckyWordGame=new PredictLuckyWordGame();
        luckyWordGame.printRuleOfGame();
        luckyWordGame.runGame();
    }  
    void printRuleOfGame(){
        System.out.println("Gioi thieu luat choi:");
        System.out.println("He thong se dua ra ngau nhien 4 tu. Ban hay nhap 1 tu trong do ma ban cho la dung");
        System.out.println("Neu cau tra loi cua ban giong voi dap an cua he thong, ban se duoc cong diem");
        System.out.println("Moi lan choi b co 2 van, moi van ban se co 2 co hoi tra loi");
        System.out.println("Neu ban tra loi dung o lan dau, ban nhan duoc 2 diem, lan thu 2 duoc 1 diem, tra loi sai ban khong duoc diem ");
        System.out.println("Sau khi choi het 2 van, ban se nhan duoc tong diem");
        System.out.println("Sau do, ban co the chon choi tiep hoac dung lai.");
        System.out.println("--------------------------------------------------------------------------------");
    }  
    void runGame() throws FileNotFoundException{
        String choice;
        do {
            System.out.println("-----------------------------------------------------------------------------");
            ProcessingInGame  game=new ProcessingInGame();
            game.runGame();
            Scanner sc = new Scanner(System.in);
            System.out.println("Ban co muon choi tiep khong? (y/n)");
            choice = sc.next();
        } while (choice.equals("y"));
        System.out.println("==========Tro choi ket thuc=============");
    }
}
