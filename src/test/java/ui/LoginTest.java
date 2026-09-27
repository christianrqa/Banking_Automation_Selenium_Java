package ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.LoginPage;
import utils.TestDataReader;

@Epic("Banking Application")
@Feature("Login")

public class LoginTest extends BaseTest {

    private TestDataReader testData = new TestDataReader();

    @Test(groups = "smoke")
    @Severity(SeverityLevel.BLOCKER)
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                testData.get("standard.username"),
                testData.get("standard.password"));

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/bank"),
                "User was not successfully logged in");
    }

    @Test(groups = "regression")
    @Severity(SeverityLevel.NORMAL)
    public void invalidUsernameTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                testData.get("invalid.username"),
                testData.get("standard.password"));
        Assert.assertTrue(
                loginPage.isErrorMessageVisible(),
                "Expected login error message was not displayed");
    }

    @Test(groups = "regression")
    @Severity(SeverityLevel.NORMAL)
    public void invalidPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                testData.get("standard.username"),
                testData.get("invalid.password"));
        Assert.assertTrue(
                loginPage.isErrorMessageVisible(),
                "Expected login error message was not displayed");
    }

    @Test(groups = "regression")
    @Severity(SeverityLevel.NORMAL)
    public void invalidUsernameAndPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                testData.get("invalid.username"),
                testData.get("invalid.password"));

        Assert.assertTrue(
                loginPage.isErrorMessageVisible(),
                "Expected login error message was not displayed");
    }

    @Test(groups = "regression")
    @Severity(SeverityLevel.NORMAL)
    public void loginButtonTest() {

        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(
                loginPage.isLoginButtonDisplayed(),
                "Login button is not displayed");

        Assert.assertTrue(
                loginPage.isLoginButtonEnabled(),
                "Login button is not enabled");
    }

    @Test(groups = "regression")
    @Severity(SeverityLevel.NORMAL)
    public void passwordMaskingTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterPassword(
                testData.get("standard.password"));
        Assert.assertTrue(
                loginPage.isPasswordMasked(),
                "Password is not masked");
    }

    @Test(groups = "regression")
    @Severity(SeverityLevel.NORMAL)
    public void emptyUsernameTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterPassword(
                testData.get("standard.password"));
        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.isErrorMessageVisible(),
                "Expected validation error message was not displayed");
    }

    @Test(groups = "regression")
    @Severity(SeverityLevel.NORMAL)
    public void emptyPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(
                testData.get("standard.username"));
        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.isErrorMessageVisible(),
                "Expected validation error message was not displayed");
    }

    @Test(groups = "regression")
    @Severity(SeverityLevel.NORMAL)
    public void emptyUsernameAndPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.isErrorMessageVisible(),
                "Expected validation error message was not displayed");
    }
}