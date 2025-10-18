package selenium.wings1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggestive_DropDown_3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Thread.sleep(2000);

        driver.findElement(By.id("autosuggest")).sendKeys("ia");
        Thread.sleep(2000);

        List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
        System.out.println(options.size());

        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            }
        }

    }
}
