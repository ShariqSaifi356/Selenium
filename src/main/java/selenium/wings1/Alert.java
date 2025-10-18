package selenium.wings1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {
    public static void main(String[] args) throws Exception {
        
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Rohan Kumar");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
        Thread.sleep(2000);
        System.out.println("Message 1: " + driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);        
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Rohan");
        Thread.sleep(2000);
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(2000);
        System.out.println("Message 2: " + driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
    }
    
}
