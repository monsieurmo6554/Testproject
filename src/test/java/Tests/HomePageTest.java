package Tests;

 import org.junit.jupiter.api.Test;
           import org.openqa.selenium.By;
           import org.openqa.selenium.WebDriver;
           import org.openqa.selenium.WebElement;
           import org.openqa.selenium.chrome.ChromeDriver;

           import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest {

    @Test
    public void testHomePageElements() {
        // Set up the WebDriver (make sure to set the path to your WebDriver)
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8085"); // Adjust the URL as necessary

        // Check if the header is displayed
        WebElement header = driver.findElement(By.tagName("h1"));
        assertTrue(header.isDisplayed(), "Header is not displayed");

        // Check if the message is displayed
        WebElement message = driver.findElement(By.xpath("//h2[contains(text(), 'This is a Test Project created by MO')]"));
        assertTrue(message.isDisplayed(), "Message is not displayed");

        // Close the driver
        driver.quit();
    }
}
