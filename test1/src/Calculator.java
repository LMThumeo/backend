import java.util.*;

public class Calculator {
    private static double firstNumber;
    private static double secondNumber;
    private static double result;
    private static String operator;
    public static void main(String[] args) {       
        inputNumberAndOperator();
        calculateWithGivenInput();
        printResult();
    }
    private static void inputNumberAndOperator() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao 2 so: ");
        firstNumber = checkNumber(sc);
        System.out.println("Nhap vao so thu 2: ");
        secondNumber = checkNumber(sc);
        System.out.println("Nhap vao phep tinh: ");
        checkOperator(sc);
        sc.close();        
    }
    private static double checkNumber(Scanner sc) {       
        double number = 0;
        boolean valid = false;
        while(!valid){
            String numStr = sc.nextLine();
            try {
                number = Double.parseDouble(numStr);  
                valid = true;   
                System.out.println("Nhap so thanh cong!");       
            } catch (Exception e) {
               System.out.println("Ban nhap sai roi. Hay nhap lai so!!!");
            }
        }       
        return number;      
    }
    private static void checkOperator(Scanner sc) {       
        boolean valid = false;
        String operatorList[]={"+","-","*","/"};
        Set<String> operatorSet=new HashSet<>(Arrays.asList(operatorList));
        do {
            operator = sc.next();
            if (operatorSet.contains(operator)) {
                valid = true;
                System.out.println("Nhap phep tinh thanh cong!");
            }             
            else {
                System.out.println("Hay nhap lai phep tinh: ");
            }            
        } while (!valid);       
    }
    private static void calculateWithGivenInput() {
        switch (operator) {
            case "+":
                result = firstNumber+secondNumber;
                break;             
            case "-":
                result = firstNumber-secondNumber;
                break;  
            case "*":
                result = firstNumber*secondNumber;
                break;           
            default:
                result = firstNumber/secondNumber;
                break;
        }
    }
    private static void printResult() {        
        System.out.println("Ket qua: "+ result);
    }
}
