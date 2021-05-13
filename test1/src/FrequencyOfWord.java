import java.util.*;

public class FrequencyOfWord {
    private static String givenString;
    private static String givenWords;
    public static void main(String[] args) {     
        inputString();
        Map <String, Integer> frequencyWordMap = findFrequencyOfGivenWord(givenString,givenWords); 
        printMap(frequencyWordMap)    ;  
    }

    private static void inputString() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap chuoi thu nhat: ");
        givenString = sc.nextLine();
        System.out.println("nhap chuoi thu 2: ");
        givenWords = sc.nextLine();
        sc.close();
    }
    private static Map <String, Integer> findFrequencyOfGivenWord(String giveString, String givenWords){
        Map<String, Integer> frequencyStringMap = new HashMap<>();
        StringTokenizer sTokenizer = new StringTokenizer(giveString);
        while(sTokenizer.hasMoreTokens()) {
            String sTemp = sTokenizer.nextToken();
            if (frequencyStringMap.containsKey(sTemp)) {
                frequencyStringMap.replace(sTemp, frequencyStringMap.get(sTemp) + 1);
            }            
            else {
                frequencyStringMap.put(sTemp, 1);
            }
        }
        
        Set<String> wordSet = new HashSet<>();
        sTokenizer = new StringTokenizer(givenWords);
        while(sTokenizer.hasMoreTokens())
            wordSet.add(sTokenizer.nextToken());

        Map<String, Integer> frequencyWordMap = new HashMap<>();
        for (String i : wordSet) {
            if(frequencyStringMap.containsKey(i)) {
                frequencyWordMap.put(i, frequencyStringMap.get(i));
            }               
        }
        
        return frequencyWordMap;
    }
    private static void printMap(Map <String, Integer> map){
        System.out.println(map);
    }    
}
