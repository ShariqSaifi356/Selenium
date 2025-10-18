package selenium.wings1.Exercise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Ecercise_1 {
    public static void main(String[] args) throws Throwable {

        ChromeOptions options = new ChromeOptions();
        // Setting the Chrome browser in incognito mode.
        // Incognito mode is a private browsing mode that does not save the browsing.
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        // Setting the implicit wait time.
        // Implicit wait is a global wait that tells the WebDriver to wait for a
        // certain.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        // Autosuggestive Dropdown.
        // Passing the input = ind in the autosuggestive dropdown.
        driver.findElement(By.id("autosuggest")).sendKeys("uni");
        Thread.sleep(2000);
        // Storing the all value of dropdown into a list.
        List<WebElement> lstOptions = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
        System.out.println(lstOptions.size());
        // Traversing the WebElement.
        for (WebElement option : lstOptions) {
            // The equalsIgnoreCase() method compares two strings, ignoring lower case and
            // upper case differences.
            // This method returns true if the strings are equal, and false if not.
            if (option.getText().equalsIgnoreCase("United Arab Emirates")) {
                option.click();
                break;
            }
        }

        // Checking Radio Button is Selected or not.
        Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isSelected());
        System.out.println("Checking Radio Button is Selected or not: "
                + driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isSelected());

        // Static DropDown.
        WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select staticDropDownOptions = new Select(staticDropDown);
        staticDropDownOptions.selectByIndex(2);

        // Another DropDown

        driver.findElement(By.id("divpaxinfo")).click();
        WebElement adultPassengers = driver.findElement(By.id("hrefIncAdt"));
        for (int i = 1; i < 5; i++) {
            adultPassengers.click();
        }

        WebElement childPassengers = driver.findElement(By.id("hrefIncChd"));
        for (int i = 1; i < 5; i++) {
            childPassengers.click();
        }

        driver.findElement(By.id("hrefIncInf")).click();
        driver.findElement(By.id("btnclosepaxoption")).click();

        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult, 4 Child, 1 Infant");
        System.out.println("Selected Passengers: " + driver.findElement(By.id("divpaxinfo")).getText());

        // Selecting a Check Box.

        Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());

        // Hovering on the check box text.
        Actions action = new Actions(driver);
        WebElement hover = driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount"));
        action.moveToElement(hover).build().perform();

        System.out.println(
                driver.findElement(By.xpath("//div[@id='ctl00_mainContent_SeniorCitizenDiv']/a/span")).getText());

        // Another DropDown.

        // Click to open the origin station dropdown
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        // Select the desired option
        driver.findElement(By.xpath("//a[@value='DED']")).click();

        /*
         * There is no need of clicking the below element because the options are
         * automatically visible for the second dropdown(i.e. To)
         */
        // driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1")).click();
        /*
         * div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']
         * 
         * Selects any <div> with the given id, anywhere in the document.
         * The space and double slash:
         * //div[@id='...'] //a[@value='MAA']
         * 
         * The space (or ) after the first bracket means:
         * "From the <div> found above, select any descendant <a> element with value='MAA' at any level inside that <div>."
         * a[@value='MAA']
         * 
         * Selects any <a> tag with the attribute value='MAA'.
         */
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
                .click();

    }
}