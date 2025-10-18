package selenium.wings1.Exercise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandOn_2 {

    public static void main(String[] args) throws Throwable {

        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1:5500/index.html");
        driver.manage().window().maximize();

        driver.findElement(By.id("from")).sendKeys("d");

        List<WebElement> dropDownOptions = driver.findElements(By.xpath("//ul[@class='suggestions']/li"));
        for (WebElement option : dropDownOptions) {
            if (option.getText().equalsIgnoreCase("Delhi")) {
                option.click();
                break;
            }
        }
        Thread.sleep(3000);
        driver.findElement(By.id("to")).sendKeys("m");

        List<WebElement> dropDownOptions2 = driver.findElements(By.xpath("//ul[@class='suggestions']/li"));
        for (WebElement option1 : dropDownOptions2) {
            if (option1.getText().equalsIgnoreCase("Mumbai")) {
                option1.click();
                break;
            }
        }

        driver.findElement(By.id("captchaAnswer")).click();
        Thread.sleep(1000);
        String captcha = driver.findElement(By.id("captchaQuestion")).getText();
        System.out.println(captcha);
        String withoutSpaceCaptcha = captcha.replaceAll("\\s", "");
        System.out.println(withoutSpaceCaptcha);

        int colonIndex = withoutSpaceCaptcha.indexOf(":");
        int equalIndex = withoutSpaceCaptcha.indexOf("=");

        String expression = withoutSpaceCaptcha.substring(colonIndex + 1, equalIndex).trim();
        System.out.println(expression);

        char operator = ' ';
        int operatorIndex = -1;

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if ("+-*".indexOf(ch) != -1) {
                operator = ch;
                operatorIndex = i;
                break;
            }
        }

        String first = expression.substring(0, operatorIndex);
        String second = expression.substring(operatorIndex + 1);

        int a = Integer.parseInt(first);
        int b = Integer.parseInt(second);
        int result = 0;

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
            default:
                result = 0;
                break;
        }
        System.out.println(result);

        

        driver.findElement(By.id("captchaAnswer")).sendKeys(String.valueOf(result));
        driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();       


    }

}
