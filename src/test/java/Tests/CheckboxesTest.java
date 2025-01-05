package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckboxesTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Initialize WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testCheckboxes() {
        // Navigate to the checkboxes page
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // Wait until checkboxes are visible
        WebElement checkbox1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='checkboxes']/input[1]")));
        WebElement checkbox2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='checkboxes']/input[2]")));

        // Verify initial states
        Assert.assertFalse(checkbox1.isSelected(), "Checkbox 1 should initially be unchecked.");
        Assert.assertTrue(checkbox2.isSelected(), "Checkbox 2 should initially be checked.");

        // Toggle the checkboxes
        checkbox1.click();
        checkbox2.click();

        // Verify states after toggling
        Assert.assertTrue(checkbox1.isSelected(), "Checkbox 1 should now be checked.");
        Assert.assertFalse(checkbox2.isSelected(), "Checkbox 2 should now be unchecked.");
    }



    }

