package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AmazonSearchTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Navigate to Amazon.co.uk
        driver.get("https://www.amazon.co.uk");

        // Inject a valid session cookie (replace 'session-id' and value with actual session cookie details)
        Cookie sessionCookie = new Cookie("session-id", "your-session-id-value");
        driver.manage().addCookie(sessionCookie);

        // Reload the page with the cookie set
        driver.navigate().refresh();
    }

    @Test
    public void testSearch() {
        // Perform a search
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("laptop");

        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

        // Verify search results
        WebElement searchResults = driver.findElement(By.cssSelector("span.a-color-state"));
        Assert.assertTrue(searchResults.getText().contains("laptop"), "Search results do not contain 'laptop'");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
