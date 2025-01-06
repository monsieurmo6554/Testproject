package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AmazonHomepageTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testHomepage() {
        // Navigate to Amazon.co.uk homepage
        driver.get("https://www.amazon.co.uk");


        // Just wait for the homepage to load and display it for demonstration
        // You can add a simple assertion or validation like checking if the page title is correct
        String pageTitle = driver.getTitle();
        System.out.println("Page title is: " + pageTitle);

        // You can assert the title to check if you're on the correct page
        Assert.assertTrue(pageTitle.contains("Amazon"), "Homepage not loaded correctly.");

    }
}
