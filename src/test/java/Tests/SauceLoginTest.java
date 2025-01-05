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

public class SauceLoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() {
        // Navigate to the Sauce Demo homepage
        driver.get("https://www.saucedemo.com/");

        // Locate and enter username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        // Locate and enter password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        // Click login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Verify the page has successfully loaded (Check if product images are visible)
        WebElement productImage = driver.findElement(By.cssSelector(".inventory_item_img"));
        Assert.assertTrue(productImage.isDisplayed(), "Product page not loaded.");

        /*
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

         */
    }
}
