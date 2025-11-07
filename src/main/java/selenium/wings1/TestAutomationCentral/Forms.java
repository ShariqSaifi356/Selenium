package selenium.wings1.TestAutomationCentral;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Forms {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationcentral.com/demo/checkboxes.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        System.out.println("*********************");
        checkbox(driver);
        System.out.println("*********************");
        radiobutton(driver);
        System.out.println("*********************");
        simpleDropDown(driver);
        System.out.println("*********************");
        multiSelectDropDown(driver);
        System.out.println("*********************");
        groupedDropDown(driver);
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

    public static void radiobutton(WebDriver driver) {
        driver.findElement(By.xpath("//a[normalize-space()='Radio Buttons (Single Selection)']")).click();
        System.out.println(driver.findElement(By.xpath("//h2[normalize-space()='Radio Buttons']")).getText());
        driver.findElement(By.xpath("//div[@class='mb-6']//label[1]//input[1]")).click();
        if (driver.findElement(By.xpath("//div[@class='mb-6']//label[1]//input[1]")).isEnabled()) {
            System.out.println("The Radio button is Enabled.");
            Assert.assertTrue(true);
        } else {
            System.out.println("The Radio button is Enabled.");
            Assert.assertTrue(false);
        }

    }

    public static void simpleDropDown(WebDriver driver) {
        driver.findElement(By.xpath("//a[normalize-space()='Dropdowns']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Simple Dropdown']")).click();
        WebElement element = driver
                .findElement(By.xpath("//div[@id='simple-dropdown']//select[@class='form-select block w-full mt-1']"));
        Select dropdown = new Select(element);
        dropdown.selectByValue("option2");
        WebElement selectedOption = dropdown.getFirstSelectedOption();
        String actualSelectedText = selectedOption.getText();

        String expectedSelectedText = "Option 2";

        if (actualSelectedText.equals(expectedSelectedText)) {
            System.out.println("Verification Successful: '" + actualSelectedText + "' is selected.");
        } else {
            System.out.println("Verification FAILED. Expected '" + expectedSelectedText + "', but found '"
                    + actualSelectedText + "'.");
        }
    }

    public static void multiSelectDropDown(WebDriver driver) {
        driver.findElement(By.xpath("//button[normalize-space()='Multi-Select']")).click();
        WebElement element = driver.findElement(By.xpath("//select[@class='form-multiselect block w-full mt-1']"));
        Select multiSelectDropDown = new Select(element);
        if (multiSelectDropDown.isMultiple()) {
            multiSelectDropDown.selectByValue("option1");
            multiSelectDropDown.selectByValue("option2");
            multiSelectDropDown.selectByValue("option3");
        }
        // multiSelectDropDown.deselectAll();

        List<WebElement> selectedOptions = multiSelectDropDown.getAllSelectedOptions();
        String expectedSelectedText = "Option 2";
        for (int i = 0; i < selectedOptions.size(); i++) {
            WebElement currentOption = selectedOptions.get(i);
            String actualSelectedText = currentOption.getText();
            if (actualSelectedText.equals(expectedSelectedText)) {
                multiSelectDropDown.deselectByValue("option2");
                break;
            }
        }
    }

    public static void groupedDropDown(WebDriver driver){
        driver.findElement(By.xpath("//button[normalize-space()='Grouped Dropdown']")).click();
        WebElement element = driver.findElement(By.xpath("//div[@id='grouped-dropdown']//select[@class='form-select block w-full mt-1']"));
        Select dropdown = new Select(element);
        dropdown.selectByValue("option3");


    }

}
