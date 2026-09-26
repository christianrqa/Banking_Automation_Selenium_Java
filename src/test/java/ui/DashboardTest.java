package ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTest extends BaseTest {

    @Test(groups = "regression")
    public void dashboardDisplayedAfterLoginTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "bank_sauce");

        DashboardPage dashboardPage = new DashboardPage(driver);

        Assert.assertTrue(
                dashboardPage.isWelcomeMessageVisible(),
                "Dashboard welcome message was not displayed"
        );
    }
    @Test
    public void totalBalanceDisplayedTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "bank_sauce");

        DashboardPage dashboardPage = new DashboardPage(driver);

        String totalBalance = dashboardPage.getTotalBalance();

        Assert.assertFalse(
            totalBalance.isEmpty(),
            "Total balance is not displayed"
    );
    }
    @Test
    public void recentTransactionsDisplayedTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "bank_sauce");

        DashboardPage dashboardPage = new DashboardPage(driver);

        int transactionCount = dashboardPage.getRecentTransactionCount();

        Assert.assertTrue(
            transactionCount > 0,
            "No recent transactions were displayed"
    );
    }
}