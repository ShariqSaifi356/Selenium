package selenium.wings1.TestAutomationCentral;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Forms {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationcentral.com/demo/checkboxes.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        System.out.println("*********************");
        checkbox(driver);
        radiobutton(driver);
        Thread.sleep(1000 * 7);
        driver.quit();
    }

    public static void checkbox(WebDriver driver) {
        String checkBox1 = driver.findElement(By.xpath("//h3[normalize-space()='Simple Checkboxes']")).getText();
        System.out.println("Text from Web Page : " + checkBox1);
        driver.findElement(By.xpath("//div[@class='mb-6']//label[1]//input[1]")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class='mb-6']//label[2]//input[1]")).isSelected());
        driver.findElement(By.xpath("(//input[@class='form-checkbox text-green-600'])[1]")).click();
        System.out.println(driver
                .findElement(By.xpath("//p[normalize-space()='This is a more detailed description for option 1.']"))
                .getText());
    }

    public static void radiobutton(WebDriver driver){
        driver.findElement(By.xpath("//a[normalize-space()='Radio Buttons (Single Selection)']")).click();
        System.out.println(driver.findElement(By.xpath("//h2[normalize-space()='Radio Buttons']")).getText());
        
    }
}
