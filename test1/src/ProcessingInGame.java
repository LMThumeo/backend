import java.io.*;
import java.util.*;

public class ProcessingInGame {
    private String displayedWord[] = new String[4];
    private List<String> inputList = new ArrayList<>();
    private String correctAnswer;
    private String answer;
    private int totalPoint;
    public ProcessingInGame(){
    }
    public void runGame() throws FileNotFoundException {
        readData();
        processARound();
        printPoint();
    }
    private void readData() throws FileNotFoundException{
        File file = new File("ListOfWord.txt");
        Scanner sc = new Scanner(file);        
        while( sc.hasNextLine() ) {
            inputList.add(sc.nextLine());
        }
    }
    private void randomStringsAndAnswer(){
        //random 4 Strings form listInput in order that player can choose
        Random random = new Random();
        int sizeInputList = inputList.size();
        Set <String> pickedStrings = new HashSet<>();
        while (pickedStrings.size()<4) {
            pickedStrings.add(inputList.get(random.nextInt(sizeInputList)));
        }
        pickedStrings.toArray(displayedWord);
        //random a correct answer form 4 String 
        correctAnswer = displayedWord[random.nextInt(4)];
    }
    private void displayWords(){
        for (int i = 0; i < 4; i++){
            System.out.print(displayedWord[i]+" ");
        }
        System.out.println();
    }
    private void processAnswer(){
        Scanner sc = new Scanner(System.in);
        int turn = 2;//the number of turns player can give their answer
        int pointInTurn = 2;
        do {
            answer = sc.next();
            if(answer.equals(correctAnswer)) {
                totalPoint += pointInTurn;
                System.out.println("Cau tra loi dung!!!");
                turn = 0;
            }                
            else {
                turn --;
                pointInTurn /=2; //Suppose after each wrong choice, the number of points the player received is reduced by half of the previous turn
                if (turn>0) {
                    System.out.println("Sai roi. Ban con " + turn + " luot tra loi.");
                }                
                else {
                    System.out.println("Sai roi. ban da het luot o van nay.");
                }                
            }
        } while (turn>0);
        System.out.println("Cau tra loi dung la: " + correctAnswer);
    }
    private void processARound() {
        totalPoint = 0;
        for (int i = 1; i < 3; i++){
            System.out.println("Van " + i + ":");
            randomStringsAndAnswer();
            displayWords();
            processAnswer();
        }
    }
    private void printPoint() {
        System.out.println("----------------------------------------");
        System.out.println("So diem cua ban la: " + totalPoint);
    }
}
