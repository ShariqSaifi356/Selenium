package selenium.wings1.Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class captcha {

    public static void main(String[] args) {

        // String question = "captcha:5+3=?";

        String captcha = "captcha : 5 * 3 = ?";
        String question = captcha.replaceAll("\\s", "");
        System.out.println(question);

        // Step 1: Extract only the math expression
        //"captcha:5+3=?"
        int colonIndex = question.indexOf(":"); // finds ":"
        int equalIndex = question.indexOf("="); // finds "="
        String expression = question.substring(colonIndex + 1, equalIndex).trim(); // "5*3"

        // Step 2: Identify the operator and split the numbers
        char operator = ' ';
        int operatorIndex = -1;

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if ("+-*/%^".indexOf(ch) != -1) {
                operator = ch;
                operatorIndex = i;
                break;
            }
        }

        String first = expression.substring(0, operatorIndex); // "5"
        String second = expression.substring(operatorIndex + 1); // "3"

        int a = Integer.parseInt(first);
        int b = Integer.parseInt(second);
        int result = 0;

        // Step 3: Do the calculation
        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = (b != 0) ? a / b : 0;
                break;
            case '%':
                result = (b != 0) ? a % b : 0;
                break;
            case '^':
                result = (int) Math.pow(a, b);
                break;
        }

        // Step 4: Print or use the result
        System.out.println("Captcha Answer: " + result);

        
    }   

}
