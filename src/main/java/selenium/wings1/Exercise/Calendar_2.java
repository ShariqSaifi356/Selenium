package selenium.wings1.Exercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Calendar_2 {

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        String fDate = "10";
        String fMonth = "September";
        String fYear = "2039";

        driver.findElement(By.xpath("//input[@id='datepicker']")).click();
        String month_year = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
        System.out.println(month_year);
        String month = month_year.split(" ")[0];
        System.out.println(month);
        String year = month_year.split(" ")[1];
        System.out.println(year);

        while (!(month.equals(fMonth) && year.equals(fYear))) {
            driver.findElement(By.xpath("//a[@title='Next']")).click();
            month_year = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
            month = month_year.split(" ")[0];
            year = month_year.split(" ")[1];
        }
        driver.findElement(By.xpath("//a[text()='" + fDate + "']")).click();

    }

}
