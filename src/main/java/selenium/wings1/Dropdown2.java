package selenium.wings1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdown2 {
    public static void main(String[] args) throws Throwable {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); // URL in the browser

        // //a[@value='MAA'] - Xpath for chennai

        // //a[@value='BLR']
        Thread.sleep(2000);
        //Add comment : This code is used to select a dropdown option in a flight booking website.
        driver.manage().window().maximize(); // Maximize the browser window
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        // Select the origin station dropdown
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@value='BLR']")).click();

        Thread.sleep(2000);

        // driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        Thread.sleep(2000);
        // Select the destination station dropdown
        //Explain line below: This line finds the dropdown for destination station and clicks it.
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        Thread.sleep(2000);
        
        //driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
    }
}
