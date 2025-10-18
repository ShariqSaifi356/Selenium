package selenium.wings1.TutorialsPoint;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A_F_W {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("*********************");
        browserWindows(driver);
        alerts(driver);
        frames(driver);
        // driver.quit();
        System.out.println("\n" + "*********************");
    }

    public static void browserWindows(WebDriver driver) {

        driver.findElement(By.xpath("//button[normalize-space()='New Tab']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='New Window']")).click();

        Set<String> windows = driver.getWindowHandles();
        System.out.println("Windows ID's: " + windows);
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childTab = it.next();
        String childWindow = it.next();

        driver.switchTo().window(childTab);
        System.out.println("Title of Child Tab: " + driver.getTitle());
        System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='New Tab']")).getText());
        driver.close();

        driver.switchTo().window(childWindow);
        System.out.println("Title of Child Window: " + driver.getTitle());
        System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='New Window']")).getText());
        driver.close();

        driver.switchTo().window(parentWindow);
        System.out.println("xxxxxxxxxxxxxxxxxxxxx");
        driver.findElement(By.xpath("//button[normalize-space()='New Window Message']")).click();
        Set<String> childWindowWithText = driver.getWindowHandles();
        Iterator<String> it_2 = childWindowWithText.iterator();
        String parent_2 = it_2.next();
        String childWindowHavingText = it_2.next();
        driver.switchTo().window(childWindowHavingText);
        System.out.println(driver
                .findElement(By.xpath("//div[@class='row d-flex justify-content-center logindiv bg-white rounded']"))
                .getText());
        driver.close();

        driver.switchTo().window(parent_2);

    }

    public static void alerts(WebDriver driver) {

        driver.findElement(By.xpath("//a[normalize-space()='Alerts']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Alert']")).click();
        System.out.println("Normal Alert Text: " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//button[@onclick='myMessage()']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        System.out.println("On button click, alert will appear after 5 seconds: " + alert.getText());
        alert.accept();

        driver.findElement(By.xpath("//button[@onclick='myDesk()']")).click();
        System.out.println("On button click, confirm box will appear: " + alert.getText());
        alert.dismiss();
        System.out.println(driver.findElement(By.id("desk")).getText());

        driver.findElement(By.xpath("//button[@onclick='myPromp()']")).click();
        System.out.println("On button click, prompt box will appear: " + alert.getText());
        alert.sendKeys("Vinod");
        alert.accept();

    }

    public static void frames(WebDriver driver) {

        driver.findElement(By.xpath("//a[normalize-space()='Frames']")).click();
        driver.switchTo().frame(0);
        WebElement scrollTarget = driver.findElement(By.xpath("//h1[normalize-space()='New Tab']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", scrollTarget);
        System.out.println("Frames: " + driver.findElement(By.xpath("//h1[normalize-space()='New Tab']")).getText());
        driver.switchTo().defaultContent();
    }

}
