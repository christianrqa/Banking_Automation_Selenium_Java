package utils;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDataReaderTest {

    @Test
    public void verifyLoginTestData() {

        TestDataReader testData = new TestDataReader();

        System.out.println(
                "Standard username: "
                + testData.get("standard.username")
        );

        System.out.println(
                "Standard password: "
                + testData.get("standard.password")
        );

        System.out.println(
                "Invalid username: "
                + testData.get("invalid.username")
        );

        System.out.println(
                "Invalid password: "
                + testData.get("invalid.password")
        );

        Assert.assertEquals(
                testData.get("standard.username"),
                "standard_user"
        );

        Assert.assertEquals(
                testData.get("standard.password"),
                "bank_sauce"
        );

        Assert.assertEquals(
                testData.get("invalid.username"),
                "invalid_user"
        );

        Assert.assertEquals(
                testData.get("invalid.password"),
                "wrong_password"
        );
    }
}