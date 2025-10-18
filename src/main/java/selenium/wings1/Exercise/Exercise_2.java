package selenium.wings1.Exercise;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise_2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        Thread.sleep(3000);

        addItems(driver, itemsNeeded);

    }

    public static void addItems(WebDriver driver, String[] itemsNeeded)

    {

        int j = 0;

        // Find all product name elements on the page (e.g., "Brocolli - 1 Kg")
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        // Loop through each product found on the page
        for (int i = 0; i < products.size(); i++) {
            // Example product text: "Brocolli - 1 Kg"
            // Split the product text at the hyphen to separate the name and quantity
            String[] name = products.get(i).getText().split("-");

            // Trim whitespace to get the actual vegetable name (e.g., "Brocolli")
            String formattedName = name[0].trim();

            // Convert the itemsNeeded array to a list for easy searching
            List itemsNeededList = Arrays.asList(itemsNeeded);

            // Check if the current product name is in the list of items to add
            if (itemsNeededList.contains(formattedName)) {
                // Increment the counter for items added
                j++;

                // Click the "Add to cart" button corresponding to the current product
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                // If all needed items have been added, exit the loop early
                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }

    }

}
