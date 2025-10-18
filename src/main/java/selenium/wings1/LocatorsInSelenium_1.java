package selenium.wings1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsInSelenium_1 {
    public static void main(String[] args) throws Throwable {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();
        // By ID
        Thread.sleep(1000);
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        // By Name
        Thread.sleep(1000);
        driver.findElement(By.name("inputPassword")).sendKeys("hello1234");
        Thread.sleep(1000);
        driver.findElement(By.id("chkboxOne")).click();

        // By ClassName
        driver.findElement(By.className("signInBtn")).click();

        // By CSS Selector
        Thread.sleep(2000);
        String error = driver.findElement(By.cssSelector("p.error")).getText();
        System.out.println("Error Message: " + error);

        // By LinkText it is used for anchor text
        driver.findElement(By.linkText("Forgot your password?")).click();

        // By Xpath
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
        // By Css Selector
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");

        // By Xpath : Clearing the field
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

        // Writing same above thing using Css Selectors
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");

        // By Xpath Parent tag to child tag
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");

        // By Css Selector
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        // By Css Selectors Parent to child tag
        String pass = driver.findElement(By.cssSelector("form p")).getText();
        System.out.println("This String contains password: " + pass);

        // By unique Xpath
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

        Thread.sleep(2000);

        // By Css Selector using ID
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");

        // By Css Selector : Here we are using *.
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

        driver.findElement(By.xpath("//div[@class='checkbox-container']/span[2]/input")).click();

        // Xpath with contains method
        driver.findElement(By.xpath("//button[contains(@class,'signInBtn')]")).click();

        Thread.sleep(1000);

        String success = driver.findElement(By.xpath("//div[@class='login-container']/p")).getText();
        System.out.println(success);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='login-container']/button[@class='logout-btn' or @text='Log Out']")).click();

        Thread.sleep(3000);
        driver.quit();

    }
}
