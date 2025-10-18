package selenium.wings1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
// This class demonstrates how to interact with a dropdown for passenger selection on a web page 
public class DropDown_1 {
    public static void main(String[] args) throws Throwable {
        // Set up the ChromeDriver to control the Chrome browser
        WebDriver driver = new ChromeDriver();
        // Navigate to the specified URL
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        // Maximize the browser window to ensure all elements are visible
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
        Thread.sleep(2000);
        System.out.println("Before clicking on + button: " + driver.findElement(By.id("divpaxinfo")).getText());
        // Click the button to increase the number of adults
        // This loop clicks the button to increase the number of adults five times
        for (int i = 1; i <= 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
            Thread.sleep(1000);
        }
        System.out.println("After clicking on + button: " + driver.findElement(By.id("divpaxinfo")).getText());
        
        // Click the button to increase the number of children
        // This loop clicks the button to increase the number of children two times
        for (int i = 1; i <= 2; i++) {
            driver.findElement(By.id("hrefIncChd")).click();
            Thread.sleep(1000);
        }
        System.out.println("After clicking on + button for children: " + driver.findElement(By.id("divpaxinfo")).getText());
        // Click the button to increase the number of infants
        // This clicks the button to increase the number of infants once
        driver.findElement(By.id("hrefIncInf")).click();
        Thread.sleep(1000);
        System.out.println("After clicking on + button for infants: " + driver.findElement(By.id("divpaxinfo")).getText());
        driver.findElement(By.id("btnclosepaxoption")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "6 Adult, 2 Child, 1 Infant");
    }
    
}
