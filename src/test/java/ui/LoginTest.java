package ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.TestDataReader;

public class LoginTest extends BaseTest {

    private TestDataReader testData = new TestDataReader();

    @Test (groups = "smoke")
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                testData.get("standard.username"),
                testData.get("standard.password"));

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/bank"),
                "User was not successfully logged in");
    }

    @Test (groups = "regression")
    public void invalidUsernameTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                testData.get("invalid.username"),
                testData.get("standard.password"));
        Assert.assertTrue(
                loginPage.isErrorMessageVisible(),
                "Expected login error message was not displayed");
    }

    @Test (groups = "regression")
    public void invalidPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                testData.get("standard.username"),
                testData.get("invalid.password"));
        Assert.assertTrue(
                loginPage.isErrorMessageVisible(),
                "Expected login error message was not displayed");
    }

    @Test (groups = "regression")
    public void invalidUsernameAndPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                testData.get("invalid.username"),
                testData.get("invalid.password"));

        Assert.assertTrue(
                loginPage.isErrorMessageVisible(),
                "Expected login error message was not displayed");
    }

    @Test (groups = "regression")
    public void loginButtonTest() {

        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(
                loginPage.isLoginButtonDisplayed(),
                "Login button is not displayed");

        Assert.assertTrue(
                loginPage.isLoginButtonEnabled(),
                "Login button is not enabled");
    }

    @Test (groups = "regression")
    public void passwordMaskingTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterPassword(
                testData.get("standard.password"));
        Assert.assertTrue(
                loginPage.isPasswordMasked(),
                "Password is not masked");
    }

    @Test (groups = "regression")
    public void emptyUsernameTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterPassword(
                testData.get("standard.password"));
        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.isErrorMessageVisible(),
                "Expected validation error message was not displayed");
    }

    @Test (groups = "regression")
    public void emptyPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(
                testData.get("standard.username"));
        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.isErrorMessageVisible(),
                "Expected validation error message was not displayed");
    }

    @Test (groups = "regression")
    public void emptyUsernameAndPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.isErrorMessageVisible(),
                "Expected validation error message was not displayed");
    }
}