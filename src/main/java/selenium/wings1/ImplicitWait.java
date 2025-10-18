package selenium.wings1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//div[@class='form-group']/input[@id='username']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//div[@class='form-group']/input[@id='password']")).sendKeys("learning");
        driver.findElement(By.id("signInBtn")).click();

    }
}
