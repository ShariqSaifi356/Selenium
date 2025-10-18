package selenium.wings1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnableDisable {

    public static void main(String[] args) throws Throwable {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        String status1 = driver.findElement(By.xpath("//div[@class='picker-second']")).getDomAttribute("style");
        System.out.println("Opacity:"+status1);
        Thread.sleep(2000);
        driver.findElement((By.xpath("//div[@class='picker-second']"))).click();
        Thread.sleep(2000);

        String status2 = driver.findElement(By.xpath("//div[@class='picker-second']")).getDomAttribute("style");
        System.out.println("Opacity:"+status2);

        if (status2.contains("display: block; opacity: 1;")){
            System.out.println("Button is enable");
        }
        else{
            System.out.println("Button is disable");
        }
        
    }
    
}
