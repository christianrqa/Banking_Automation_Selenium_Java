package utils;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigReaderTest {

    @Test
    public void configFileShouldLoad() {

        ConfigReader config = new ConfigReader();

        Assert.assertEquals(
                config.get("base.url"),
                "https://qaplayground.com/bank/login"
        );

        Assert.assertEquals(
                config.get("browser"),
                "chrome"
        );
    }
}