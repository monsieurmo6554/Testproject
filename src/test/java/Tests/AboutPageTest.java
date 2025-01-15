package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AboutPageTest {
private WebDriver driver;

@BeforeMethod
public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
}
@Test
        public void AboutPageTest() {
    //Navigate to Homepage//
    driver.get("https://www.saucedemo.com/");

//Login with Valid credentials//
    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();


    //Navigate and Click Hamburger for Menu//
    driver.findElement(By.id("react-burger-menu-btn")).click();


    //From Menu, Navigate and Click About//
    driver.findElement(By.id("about_sidebar_link")).click();
}
    //Close Window//
    @AfterMethod
    public void tearDown() {
        if (driver!=null){
            driver.quit();
        }
    }
}

