package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestEndToEndPurchase {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testEndToEndPurchase() throws InterruptedException {
        // Step 1: Navigate to Sauce Demo homepage
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000); // Wait for 2 seconds to see the page

        // Step 2: Log in with valid credentials
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000); // Wait for 2 seconds to see the login process

        // Step 3: Add the first product to the cart
        driver.findElement(By.cssSelector(".btn_inventory")).click();
        Thread.sleep(2000); // Wait for 2 seconds to see the item being added to the cart

        // Step 4: Navigate to the cart
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        Thread.sleep(2000); // Wait for 2 seconds to see the cart page

        // Step 5: Verify cart contents
        WebElement cartItem = driver.findElement(By.cssSelector(".cart_item"));
        Assert.assertTrue(cartItem.isDisplayed(), "Cart item is not displayed.");

        // Step 6: Proceed to checkout
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(2000); // Wait for 2 seconds to see the checkout page

        // Step 7: Fill in checkout information
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        Thread.sleep(2000); // Wait for 2 seconds to see the form being filled

        // Step 8: Continue to the next page
        driver.findElement(By.id("continue")).click();
        Thread.sleep(2000); // Wait for 2 seconds to see the overview page

        // Step 9: Verify checkout overview page
        WebElement overviewTitle = driver.findElement(By.className("title"));
        Assert.assertTrue(overviewTitle.getText().contains("Checkout: Overview"), "Checkout overview page did not load.");

        // Step 10: Finish the purchase
        driver.findElement(By.id("finish")).click();
        Thread.sleep(2000); // Wait for 2 seconds to see the order completion page

        // Step 11: Verify order completion
        WebElement orderConfirmation = driver.findElement(By.className("complete-header"));
        Assert.assertTrue(orderConfirmation.getText().contains("Thank you for your order!"), "Order was not completed successfully.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
