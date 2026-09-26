package base;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverFactoryTest {

    @Test
    public void shouldCreateChromeDriver() {

        WebDriver driver = DriverFactory.createDriver("chrome");

        Assert.assertNotNull(
                driver,
                "Driver should not be null"
        );

        driver.quit();
    }
}