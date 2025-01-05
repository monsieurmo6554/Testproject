package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCartTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testAddToCart() {
        // Navigate to Sauce Demo homepage
        driver.get("https://www.saucedemo.com/");

        // Wait for the login page to display (wait until the user-name input is visible)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));

        // Log in with valid credentials
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Wait for the page to sign in (wait until the products page is visible)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_list")));

        // Locate the first product and add it to the cart
        WebElement addToCartButton = driver.findElement(By.cssSelector(".btn_inventory"));
        addToCartButton.click();

        // Verify the cart count has increased
        WebElement cartIcon = driver.findElement(By.cssSelector(".shopping_cart_badge"));
        Assert.assertEquals(cartIcon.getText(), "1", "Product was not added to the cart.");

        /*
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser after each test
        }

         */
    }
}
