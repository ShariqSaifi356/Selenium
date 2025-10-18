package selenium.wings1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {
    public static void main(String[] args) throws Throwable {
        
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        System.out.println("Page title is: " + driver.getTitle());
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("Youtube");
        Thread.sleep(2000);
       

    }
}
