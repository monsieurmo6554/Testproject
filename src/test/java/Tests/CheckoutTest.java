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

public class CheckoutTest {
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
}
