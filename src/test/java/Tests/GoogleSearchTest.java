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

public class GoogleSearchTest {
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
    public void testSearch() {
        // Navigate to Google.co.uk
        driver.get("https://www.google.co.uk");

        // Accept cookies (if the popup appears)
        try {
            WebElement acceptCookiesButton = driver.findElement(By.xpath("//div[text()='I agree']"));
            acceptCookiesButton.click();
        } catch (Exception e) {
            System.out.println("No cookies popup displayed.");
        }

        // Perform a search for "Selenium WebDriver"
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();

        // Wait for the results to load and verify the results
        WebElement resultsStats = driver.findElement(By.id("result-stats"));
        Assert.assertTrue(resultsStats.isDisplayed(), "Search results stats are not displayed.");

        // Verify that the search term appears in the page title
        Assert.assertTrue(driver.getTitle().contains("Selenium WebDriver"), "Page title does not contain 'Selenium WebDriver'");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
