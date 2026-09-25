package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import io.qameta.allure.testng.AllureTestNg;

@Listeners(AllureTestNg.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qaplayground.com/bank/login");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}