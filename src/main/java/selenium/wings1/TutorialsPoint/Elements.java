package selenium.wings1.TutorialsPoint;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Elements {
    public static void main(String[] args) throws Throwable {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("*********************");
        textBox(driver);
        checkBox(driver);
        radioButton(driver);
        webTables(driver);
        buttonsAndColors(driver);
        links(driver);
        brokenLinks(driver);
        // uploadAndDownload(driver);
        dynamicProperties(driver);
        driver.quit();
        System.out.println("\n" + "*********************");
    }

    public static void textBox(WebDriver driver) throws Throwable {

        driver.findElement(By.id("fullname")).sendKeys("Rohan Kumar");
        driver.findElement(By.id("email")).sendKeys("rohan.kumar123@gmail.com");
        driver.findElement(By.id("address")).sendKeys("Jamnapaar me rehta hu me");
        driver.findElement(By.id("password")).sendKeys("ssd6ehbwue7");
        driver.findElement(By.xpath("//div[contains(@class, 'text-right')]/input[@value='Submit']")).click();
        // Wait for the button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@id='accordionExample']//button[@data-bs-target='#collapseOne']"))).click();

    }

    public static void checkBox(WebDriver driver) {

        driver.findElement(By.xpath("//a[normalize-space()='Check Box']")).click();
        // driver.findElement(By.id("c_bs_1")).click();
        if (driver.findElement(By.id("c_bs_1")).isSelected()) {
            System.out.println("Check Box is enabled");
            Assert.assertTrue(true);
        } else {
            driver.findElement(By.xpath(
                    "//body/main/div[@class='container']/div[@class='row d-flex justify-content-center logindiv bg-white rounded']/div[@class='col-md-8 col-lg-8 col-xl-8']/div[@class='tree_main']/ul[@id='bs_main']/li[@id='bs_1']/span[1]"))
                    .click();
            if (driver.findElement(By.id("c_bf_1")).isSelected()) {
                System.out.println("Check Box is enabled");
                Assert.assertTrue(true);
            } else {
                driver.findElement(By.xpath("//*[@id='bf_1']/span[1]")).click();
                driver.findElement(By.xpath("//*[@id='c_io_3']")).click();
            }
        }
        // Note: This Check box section need to be tested again.
        // Scenario: Assume that if Main level check box is checked then other check
        // boxes like sub and last are checked or not.
    }

    public static void radioButton(WebDriver driver) throws Throwable {

        driver.findElement(By.xpath("//a[normalize-space()='Radio Button']")).click();
        driver.findElement(By.xpath("//div[@class='form-check form-check-inline']/input[@value='igottwo']")).click();
        driver.findElement(By.xpath("//div[@class='form-check form-check-inline']/input[@value='igotthree']")).click();

        // Wait for the text to be updated
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("check"),
        // "You have checked Yes"));

        // String str1 = driver.findElement(By.id("check")).getText();
        // System.out.println(str1);
        // Assert.assertEquals(str1, "You have checked Yes");

        driver.findElement(By.xpath("//div[@class='form-check form-check-inline']/input[@value='igotthree']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("check1"), "You have checked Impressive"));
        String str2 = driver.findElement(By.id("check1")).getText();
        System.out.println(str2);
        Assert.assertEquals(str2, "You have checked Impressive");

        // Disabele Radio button

        if (driver.findElement(By.xpath("//div[@class='form-check form-check-inline']/input[@value='option3']"))
                .isEnabled()) {
            System.out.println("Third radio button is enabled");
            Assert.assertTrue(true);
        } else {
            System.out.println("Radio button is Disabled");
            Assert.assertFalse(false);
        }
    }

    public static void webTables(WebDriver driver) throws Throwable {

        String age = "50";
        String salary = "30000";

        driver.findElement(By.xpath("//a[normalize-space()='Web Tables']")).click();
        driver.findElement(By.xpath("//button[@data-bs-target='#staticBackdropLive']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Rohan");
        driver.findElement(By.id("lastname")).sendKeys("Kumar");
        driver.findElement(By.id("email")).sendKeys("rohanrk112@gmail.com");
        driver.findElement(By.id("age")).sendKeys(age);

        driver.findElement(By.id("salary")).sendKeys(salary);
        if (age.length() < 4) {
            String ageErrorMessage = driver.findElement(By.id("age-error")).getText();
            System.out.println("Age Error Message: " + ageErrorMessage);
            driver.findElement(By.id("age")).clear();
            driver.findElement(By.id("age")).sendKeys("5000");
        }

        driver.findElement(By.id("deparment")).sendKeys("IT");
        if (salary.length() < 20) {
            String salaryErrorMessage = driver.findElement(By.id("salary-error")).getText();
            System.out.println("Salary Error Message: " + salaryErrorMessage);
            driver.findElement(By.id("salary")).clear();
            driver.findElement(By.id("salary")).sendKeys("10000000000000000000");
        }
        driver.findElement(By.xpath("//div[@id='staticBackdropLive']//button[@aria-label='Close']")).click();
        // driver.findElement(By.xpath("//*[@id='RegisterForm']/div[2]/input")).click();
        // Syntax: Path to locate SVG element
        // *[local-name()='svg' and @data-icon='home']/*[local-name()='path']
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));

        // Click the edit SVG icon for the third row (adjust index if needed)
        WebElement editIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//tbody/tr[3]/td[7]/a[1]//*[name()='svg']")));
        editIcon.click();

        // Wait for the age input in the edit modal to be interactable
        WebElement ageInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@id='staticEdit']//input[@id='age']")));
        ageInput.clear();
        ageInput.sendKeys("50");

        // Click the submit button in the modal
        driver.findElement(By.xpath("//div[@id='staticEdit']//input[@value='Submit']")).click();
        /*
         * This code waits for the delete icon in the second row to be clickable,
         * scrolls it into view if needed, and then clicks it to delete the row. This
         * approach helps avoid errors where the element is not visible or clickable due
         * to being off-screen.
         */
        WebElement deleteIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//tbody/tr[2]/td[7]/a[2]//*[name()='svg']")));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                deleteIcon);
        deleteIcon.click();

    }

    public static void buttonsAndColors(WebDriver driver) throws Throwable {
        // Normal click
        driver.findElement(By.xpath("//button[normalize-space()='Elements']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Buttons']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Click Me']")).click();
        String message = driver.findElement(By.xpath("//div[@id='welcomeDiv']")).getText();
        System.out.println("Normal Click Message: " + message);
        Assert.assertEquals(message, "You have done a dynamic click");

        // Rignt Click
        Actions actions = new Actions(driver);
        WebElement rightClick = driver.findElement(By.xpath("//button[normalize-space()='Right Click Me']"));
        actions.contextClick(rightClick).build().perform();

        // Double Click
        WebElement doubleClick = driver.findElement(By.xpath("//button[normalize-space()='Double Click Me']"));
        actions.doubleClick(doubleClick).build().perform();
        String message_2 = driver.findElement(By.xpath("//p[@id='doublec']")).getText();
        System.out.println("Double Click Message: " + message_2);
        Assert.assertEquals(message_2, "You have Double clicked");

        // Colors
        WebElement element = driver.findElement(By.xpath("//button[normalize-space()='Click Me']"));
        String colorRGB = element.getCssValue("color");
        System.out.println("Color Code in RGB: " + colorRGB);
        // Converting RGBA to HEX
        String hex = Color.fromString(colorRGB).asHex();
        System.out.println("Color Code in Hex: " + hex);

    }

    public static void links(WebDriver driver) {

        driver.findElement(By.xpath("//a[normalize-space()='Links']")).click();
        driver.findElement(By.xpath("//div[@class='col-md-8 col-lg-8 col-xl-8']//a[normalize-space()='Home']")).click();
        Set<String> window = driver.getWindowHandles();
        System.out.println("Windows: " + window);
        Iterator<String> it = window.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        System.out.println(driver
                .findElement(By.xpath(
                        "//div[@class='flex-group justify-between flex-wrap']//div//h2[contains(@class,'fs-800')]"))
                .getText());
        driver.close();
        driver.switchTo().window(parentWindow);
        driver.findElement(By.xpath("//a[@id='created']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class='create']")).getText());

    }

    public static void brokenLinks(WebDriver driver) {
        driver.findElement(By.xpath("//a[normalize-space()='Broken Links - Images']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Click Here for Broken Link']")).click();
        System.out.println(driver
                .findElement(By.xpath("//h5[normalize-space()='This page returned a 500 status code.']")).getText());
        System.out.println(driver.getTitle());
        // System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath("//a[normalize-space()='Go Back']")).click();

    }

    public static void uploadAndDownload(WebDriver driver) {

        driver.findElement(By.xpath("//a[normalize-space()='Upload and Download']")).click();
        driver.findElement(By.id("downloadButton")).click();
        driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\asus\\Downloads\\Upload.txt");

    }

    public static void dynamicProperties(WebDriver driver) {

        driver.findElement(By.xpath("//a[normalize-space()='Dynamic Properties']")).click();
        driver.findElement(By.id("colorChange")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Boolean fiveSecondsWait = wait.until(ExpectedConditions
                .textToBePresentInElement(driver.findElement(By.id("visibleAfter")), "Visible After 5 Seconds"));
        System.out.println("Element Visible After 5 Seconds:" + fiveSecondsWait);

    }

}
