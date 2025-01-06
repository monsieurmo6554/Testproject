package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class testNavigateToAboutPage {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }
    @Test
    public void testNavigateToAboutPage() throws InterruptedException {
        // Step 1: Navigate to Sauce Demo homepage
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000); // Wait for 2 seconds to see the page

        // Step 2: Log in with valid credentials
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000); // Wait for 2 seconds to see the login process

        // Step 3: Open the hamburger menu
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000); // Wait for 2 seconds to see the menu

        // Step 4: Click on the About link
        driver.findElement(By.id("about_sidebar_link")).click();
        Thread.sleep(2000); // Wait for 2 seconds to see the About page

        // Step 5: Verify redirect to the About page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("saucelabs.com"), "Did not navigate to the About page correctly.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
}

    }
}


