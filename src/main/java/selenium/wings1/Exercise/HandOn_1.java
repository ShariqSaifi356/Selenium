package selenium.wings1.Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandOn_1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:5500/index.html");
        driver.findElement(By.id("username")).sendKeys("Rahul");
        driver.findElement(By.id("username")).click();

        String captchaQuestion = driver.findElement(By.id("captchaQuestion")).getText();
        System.out.println("Captcha Text: " + captchaQuestion);

        int colonIndex = captchaQuestion.indexOf(":");
        String sub = captchaQuestion.substring(colonIndex + 1).trim();
        int equalsIndex = sub.indexOf("=");
        String mathPart = sub.substring(0, equalsIndex).trim();

        String[] tokens = mathPart.split(" ");
        int result = 0;

        if (tokens.length == 3) {
            int firstNumber = Integer.parseInt(tokens[0]);
            String operator = tokens[1];
            int secondNumber = Integer.parseInt(tokens[2]);

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "%":
                    result = firstNumber % secondNumber;
                    break;
                case "^":
                    result = (int) Math.pow(firstNumber, secondNumber);
                    break;
                default:
                    result = 0;
            }

        }
        driver.findElement(By.id("captchaAnswerInputId")).sendKeys(String.valueOf(result));
        driver.findElement(By.id("submitBtnId")).click();

    }

}
