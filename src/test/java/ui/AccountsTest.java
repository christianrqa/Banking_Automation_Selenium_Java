package ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import pages.AccountsPage;
import pages.DashboardPage;
import pages.LoginPage;

@Epic("Banking Application")
@Feature("Accounts")

public class AccountsTest extends BaseTest {

    @Test(groups = "regression")
    public void accountsDisplayedTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "bank_sauce");

        DashboardPage dashboardPage = new DashboardPage(driver);

        AccountsPage accountsPage = dashboardPage.goToAccountsPage();

        int accountCount = accountsPage.getAccountCount();

        Assert.assertTrue(
                accountCount > 0,
                "No accounts were displayed"
        );
    }
    @Test(groups = "regression")
    public void accountNameDisplayedTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "bank_sauce");

        DashboardPage dashboardPage = new DashboardPage(driver);
        AccountsPage accountsPage = dashboardPage.goToAccountsPage();

        String accountName = accountsPage.getAccountName(0);

        Assert.assertFalse(
            accountName.isEmpty(),
            "Account name is not displayed"
    );
    }
    @Test(groups = "regression")
    public void accountTypeDisplayedTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "bank_sauce");

        DashboardPage dashboardPage = new DashboardPage(driver);
        AccountsPage accountsPage = dashboardPage.goToAccountsPage();

        String accountType = accountsPage.getAccountType(0);

        Assert.assertFalse(
            accountType.isEmpty(),
            "Account type is not displayed"
        );
    }
    @Test(groups = "regression")
    public void maskedAccountNumberDisplayedTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "bank_sauce");

        DashboardPage dashboardPage = new DashboardPage(driver);
        AccountsPage accountsPage = dashboardPage.goToAccountsPage();

        String accountNumber = accountsPage.getMaskedAccountNumber(0);

        Assert.assertFalse(
            accountNumber.isEmpty(),
            "Account number is not displayed"
    );
    }
    @Test (groups = "regression")
    public void accountBalanceDisplayedTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "bank_sauce");

        DashboardPage dashboardPage = new DashboardPage(driver);
        AccountsPage accountsPage = dashboardPage.goToAccountsPage();

        String accountBalance = accountsPage.getAccountBalance(0);

        Assert.assertFalse(
            accountBalance.isEmpty(),
            "Account balance is not displayed"
    );
    }
}
