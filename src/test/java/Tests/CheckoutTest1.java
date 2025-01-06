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

public class CheckoutTest1 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testCheckout() {
        // Navigate to Sauce Demo homepage
        driver.get("https://www.saucedemo.com/");

        // Log in with valid credentials
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Add the first product to the cart
        driver.findElement(By.cssSelector(".btn_inventory")).click();

        // Navigate to the cart
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();

        // Proceed to checkout
        driver.findElement(By.id("checkout")).click();

        // Verify the checkout page loaded
        WebElement checkoutPageTitle = driver.findElement(By.className("title"));
        Assert.assertTrue(checkoutPageTitle.getText().contains("Checkout: Your Information"), "Checkout page did not load.");
    }

    @Test
    public void testFirstNameField() {
        // Navigate to Sauce Demo homepage and log in
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Navigate to checkout page
        driver.findElement(By.cssSelector(".btn_inventory")).click();
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();

        // Verify first name field is present
        WebElement firstNameField = driver.findElement(By.id("first-name"));
        Assert.assertTrue(firstNameField.isDisplayed(), "First name field is not displayed.");
        firstNameField.sendKeys("John");
    }

    @Test
    public void testLastNameField() {
        // Navigate to Sauce Demo homepage and log in
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Navigate to checkout page
        driver.findElement(By.cssSelector(".btn_inventory")).click();
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();

        // Verify last name field is present
        WebElement lastNameField = driver.findElement(By.id("last-name"));
        Assert.assertTrue(lastNameField.isDisplayed(), "Last name field is not displayed.");
        lastNameField.sendKeys("Doe");
    }

    @Test
    public void testPostalCodeField() {
        // Navigate to Sauce Demo homepage and log in
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Navigate to checkout page
        driver.findElement(By.cssSelector(".btn_inventory")).click();
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();

        // Verify postal code field is present
        WebElement postalCodeField = driver.findElement(By.id("postal-code"));
        Assert.assertTrue(postalCodeField.isDisplayed(), "Postal code field is not displayed.");
        postalCodeField.sendKeys("12345");
    }

    @Test
    public void testContinueButton() {
        // Navigate to Sauce Demo homepage and log in
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Navigate to checkout page
        driver.findElement(By.cssSelector(".btn_inventory")).click();
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();

        // Fill in required fields
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");

        // Click the continue button
        WebElement continueButton = driver.findElement(By.id("continue"));
        Assert.assertTrue(continueButton.isDisplayed(), "Continue button is not displayed.");
        continueButton.click();

        // Verify navigation to the next page
        WebElement summaryTitle = driver.findElement(By.className("title"));
        Assert.assertTrue(summaryTitle.getText().contains("Checkout: Overview"), "Did not navigate to checkout overview page.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
