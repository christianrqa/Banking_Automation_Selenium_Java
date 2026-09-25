package ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "bank_sauce");

        Assert.assertTrue(
            driver.getCurrentUrl().contains("/bank"),
            "User was not successfully logged in"
        );
    }

    @Test
    public void invalidUsernameTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("invalid_user", "bank_sauce");

        Assert.assertTrue(
            loginPage.isErrorMessageVisible(),
            "Expected login error message was not displayed"
        );
    }

    @Test
    public void invalidPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "wrong_password");

        Assert.assertTrue(
            loginPage.isErrorMessageVisible(),
            "Expected login error message was not displayed"
        );
    }

    @Test
    public void invalidUsernameAndPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("invalid_user", "wrong_password");

        Assert.assertTrue(
            loginPage.isErrorMessageVisible(),
            "Expected login error message was not displayed"
        );
    }

    @Test
    public void loginButtonTest() {

        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(
            loginPage.isLoginButtonDisplayed(),
            "Login button is not displayed"
        );

        Assert.assertTrue(
            loginPage.isLoginButtonEnabled(),
            "Login button is not enabled"
        );
    }

    @Test
    public void passwordMaskingTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterPassword("bank_sauce");

        Assert.assertTrue(
            loginPage.isPasswordMasked(),
            "Password is not masked"
        );
    }
    
    @Test
    public void emptyUsernameTest() {
    LoginPage loginPage = new LoginPage(driver);

    loginPage.enterPassword("bank_sauce");
    loginPage.clickLogin();

    Assert.assertTrue(
        loginPage.isErrorMessageVisible(),
        "Expected validation error message was not displayed"
    );
    }
    @Test
    public void emptyPasswordTest() {
    LoginPage loginPage = new LoginPage(driver);

    loginPage.enterUsername("standard_user");
    loginPage.clickLogin();

    Assert.assertTrue(
        loginPage.isErrorMessageVisible(),
        "Expected validation error message was not displayed"
    );
    }

    @Test
    public void emptyUsernameAndPasswordTest() {
    LoginPage loginPage = new LoginPage(driver);

    loginPage.clickLogin();

    Assert.assertTrue(
        loginPage.isErrorMessageVisible(),
        "Expected validation error message was not displayed"
    );
}
}