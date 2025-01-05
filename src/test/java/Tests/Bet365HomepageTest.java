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

public class Bet365HomepageTest {
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
        // Navigate to Bet365 homepage
        driver.get("https://www.bet365.com");


         // Verify if key elements are displayed, for example, the logo or a navigation element
        WebElement logo = driver.findElement(By.cssSelector("img[src*='bet365']"));
        Assert.assertTrue(logo.isDisplayed(), "Bet365 logo is not visible.");

        //Minimize page after running test
        driver.manage().window().minimize();





    }

    }

