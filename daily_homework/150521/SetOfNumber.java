import java.util.*;

public class SetOfNumber {
    public static void main(String[] args) {
      List<Integer> numberList=inputNumberToList();
      Set<Integer> numberSet=convertListToSet(numberList);
      printSet(numberSet);       
    }
    static List<Integer> inputNumberToList(){
        Scanner sc=new Scanner(System.in);
        System.out.println("nhap do dai mang: ");
        int lengthArray = sc.nextInt();

        List<Integer> numberList=new ArrayList<>();
        for(int i=0;i<lengthArray;i++) {
            numberList.add(sc.nextInt());
        }
        return numberList;
    }
    static Set<Integer> convertListToSet(List<Integer> numberList){        
        Set <Integer> numberSet = new HashSet<>(numberList);
        return numberSet;
    }
    static void printSet(Set<Integer> set){
        System.out.println(set);
    }
    
}