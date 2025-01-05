package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testAlerts() {
        // Navigate to the JavaScript Alerts page
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Test simple alert
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert simpleAlert = driver.switchTo().alert();
        Assert.assertEquals(simpleAlert.getText(), "I am a JS Alert");
        simpleAlert.accept();
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("You successfully clicked an alert"));

        // Test confirm alert
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert confirmAlert = driver.switchTo().alert();
        Assert.assertEquals(confirmAlert.getText(), "I am a JS Confirm");
        confirmAlert.dismiss();
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("You clicked: Cancel"));

        // Test prompt alert
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert promptAlert = driver.switchTo().alert();
        Assert.assertEquals(promptAlert.getText(), "I am a JS Prompt");
        promptAlert.sendKeys("Selenium");
        promptAlert.accept();
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("You entered: Selenium"));

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
