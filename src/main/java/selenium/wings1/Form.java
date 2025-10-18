package selenium.wings1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Form {
    public static void main(String[] args) throws Throwable {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='form-group']/input[@id='username']")).sendKeys("Rahul");
        driver.findElement(By.xpath("//div[@class='form-group']/input[@id='password']")).sendKeys("Rahullearning");
        driver.findElement(By.xpath("//input[@id='terms']")).click();
        driver.findElement(By.id("signInBtn")).click();
        Thread.sleep(4000);
        // System.out.println("Message:" +
        // driver.findElement(By.xpath("normalize-space(//div[@class='alert alert-danger
        // col-md-12'])")).getText());
        driver.findElement(By.xpath("//div[@class='form-group']/input[@id='username']")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='form-group']/input[@id='username']")).sendKeys("rahulshettyacademy");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='form-group']/input[@id='password']")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='form-group']/input[@id='password']")).sendKeys("learning");
        driver.findElement(By.xpath("//div[@class='form-check-inline']//input[@value='user']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("okayBtn")).click();
        Thread.sleep(2000);
        //Static Drop Down.
        WebElement staticDropDown = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select dropDown =  new Select(staticDropDown);
        //dropDown.selectByIndex(1);
        //dropDown.selectByContainsVisibleText("Teacher");
        dropDown.selectByValue("consult");
        Thread.sleep(2000);
        driver.findElement(By.id("signInBtn")).click();
    }
}
