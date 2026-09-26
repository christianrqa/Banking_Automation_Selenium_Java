package ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import pages.TransferConfirmationPage;
import pages.TransferPage;

public class TransferTest extends BaseTest {

        @Test(groups = "regression")
        public void transferPageDisplayedTest() {

                LoginPage loginPage = new LoginPage(driver);
                loginPage.login("standard_user", "bank_sauce");

                DashboardPage dashboardPage = new DashboardPage(driver);
                TransferPage transferPage = dashboardPage.goToTransferPage();

                Assert.assertTrue(
                                transferPage.isFromAccountDropdownDisplayed(),
                                "From Account dropdown is not displayed");

                Assert.assertTrue(
                                transferPage.isToAccountDropdownDisplayed(),
                                "To Account dropdown is not displayed");

                Assert.assertTrue(
                                transferPage.isAmountInputDisplayed(),
                                "Amount input is not displayed");

                Assert.assertTrue(
                                transferPage.isMemoInputDisplayed(),
                                "Memo input is not displayed");

                Assert.assertTrue(
                                transferPage.isTodaySelected(),
                                "Today option is not selected by default");

                Assert.assertTrue(
                                transferPage.isReviewTransferButtonDisplayed(),
                                "Review Transfer button is not displayed");

                Assert.assertTrue(
                                transferPage.isReviewTransferButtonEnabled(),
                                "Review Transfer button is not enabled");
        }

        @Test(groups = "regression")
        public void selectTransferAccountsTest() {

                LoginPage loginPage = new LoginPage(driver);
                loginPage.login("standard_user", "bank_sauce");

                DashboardPage dashboardPage = new DashboardPage(driver);
                TransferPage transferPage = dashboardPage.goToTransferPage();

                transferPage.selectFromAccount("acc-savings-1");
                transferPage.selectToAccount("acc-checking-1");
        }

        @Test(groups = "regression")
        public void enterTransferDetailsTest() {

                LoginPage loginPage = new LoginPage(driver);
                loginPage.login("standard_user", "bank_sauce");

                DashboardPage dashboardPage = new DashboardPage(driver);
                TransferPage transferPage = dashboardPage.goToTransferPage();

                transferPage.selectFromAccount("acc-savings-1");
                transferPage.selectToAccount("acc-checking-1");

                transferPage.enterAmount("100.00");
                transferPage.enterMemo("QA Automation Test");

                Assert.assertTrue(
                                transferPage.isAmountInputDisplayed(),
                                "Amount input is not displayed");

                Assert.assertTrue(
                                transferPage.isMemoInputDisplayed(),
                                "Memo input is not displayed");
        }

        @Test(groups = "regression")
        public void scheduledTransferDateTest() {

                LoginPage loginPage = new LoginPage(driver);
                loginPage.login("standard_user", "bank_sauce");

                DashboardPage dashboardPage = new DashboardPage(driver);
                TransferPage transferPage = dashboardPage.goToTransferPage();

                Assert.assertTrue(
                                transferPage.isTodaySelected(),
                                "Today should be selected by default");

                transferPage.selectScheduled();

                Assert.assertTrue(
                                transferPage.isScheduledSelected(),
                                "Scheduled option was not selected");

                Assert.assertTrue(
                                transferPage.isScheduledDateDisplayed(),
                                "Scheduled date input was not displayed");

                transferPage.enterScheduledDate("2026-09-25");
        }

        @Test(groups = "regression")
        public void reviewTransferTest() {

                LoginPage loginPage = new LoginPage(driver);
                loginPage.login("standard_user", "bank_sauce");

                DashboardPage dashboardPage = new DashboardPage(driver);
                TransferPage transferPage = dashboardPage.goToTransferPage();

                String expectedDate = transferPage.getApplicationTodayDate();

                transferPage.selectFromAccount("acc-checking-1");
                transferPage.selectToAccount("acc-savings-1");

                transferPage.enterAmount("231.00");
                transferPage.enterMemo("QA Automation Test");

                transferPage.clickReviewTransfer();

                // Verify confirmation screen buttons
                Assert.assertTrue(
                                transferPage.isConfirmTransferButtonDisplayed(),
                                "Confirm Transfer button was not displayed");

                Assert.assertTrue(
                                transferPage.isCancelConfirmTransferButtonDisplayed(),
                                "Cancel button was not displayed");

                // Verify transfer details
                Assert.assertEquals(
                                transferPage.getConfirmFromAccount(),
                                "Everyday Checking",
                                "Incorrect From account");

                Assert.assertEquals(
                                transferPage.getConfirmToAccount(),
                                "High-Yield Savings",
                                "Incorrect To account");

                Assert.assertEquals(
                                transferPage.getConfirmAmount(),
                                "$231.00",
                                "Incorrect transfer amount");

                Assert.assertEquals(
                                transferPage.getConfirmDate(),
                                expectedDate,
                                "Incorrect transfer date");
        }

        @Test(groups = "regression")
        public void cancelTransferConfirmationTest() {

                LoginPage loginPage = new LoginPage(driver);
                loginPage.login("standard_user", "bank_sauce");

                DashboardPage dashboardPage = new DashboardPage(driver);
                TransferPage transferPage = dashboardPage.goToTransferPage();

                transferPage.selectFromAccount("acc-checking-1");
                transferPage.selectToAccount("acc-savings-1");

                transferPage.enterAmount("231.00");
                transferPage.enterMemo("QA Automation Test");

                transferPage.clickReviewTransfer();

                // Verify confirmation modal is displayed
                Assert.assertTrue(
                                transferPage.isConfirmTransferButtonDisplayed(),
                                "Confirmation modal was not displayed");

                // Cancel the transfer
                transferPage.clickCancelConfirmTransfer();

                // Verify we are back on the transfer form
                Assert.assertTrue(
                                transferPage.isReviewTransferButtonDisplayed(),
                                "Transfer form was not displayed after cancelling confirmation");
        }

        @Test(groups = "smoke")
        public void confirmTransferTest() {

                LoginPage loginPage = new LoginPage(driver);
                loginPage.login("standard_user", "bank_sauce");

                DashboardPage dashboardPage = new DashboardPage(driver);
                TransferPage transferPage = dashboardPage.goToTransferPage();

                String expectedDate = LocalDate.parse(
                                transferPage.getApplicationTodayDate()).format(
                                                DateTimeFormatter.ofPattern("MMM d, yyyy"));

                transferPage.selectFromAccount("acc-checking-1");
                transferPage.selectToAccount("acc-savings-1");

                transferPage.enterAmount("231.00");
                transferPage.enterMemo("QA Automation Test");

                transferPage.clickReviewTransfer();

                Assert.assertTrue(
                                transferPage.isConfirmTransferButtonDisplayed(),
                                "Confirm Transfer button was not displayed");

                transferPage.clickConfirmTransfer();

                TransferConfirmationPage confirmationPage = new TransferConfirmationPage(driver);

                Assert.assertTrue(
                                confirmationPage.isSuccessHeadingDisplayed(),
                                "Transfer Successful message was not displayed");

                Assert.assertTrue(
                                confirmationPage.getReferenceNumber().matches("TXN-\\d{8}-\\d+"),
                                "Invalid transfer reference number");

                Assert.assertEquals(
                                confirmationPage.getFromAccount(),
                                "Everyday Checking",
                                "Incorrect From account");

                Assert.assertEquals(
                                confirmationPage.getToAccount(),
                                "High-Yield Savings",
                                "Incorrect To account");

                Assert.assertEquals(
                                confirmationPage.getAmount(),
                                "$231.00",
                                "Incorrect transfer amount");

                Assert.assertEquals(
                                confirmationPage.getTransferDate(),
                                expectedDate,
                                "Incorrect transfer date");

                Assert.assertTrue(
                                confirmationPage.isBackToDashboardButtonDisplayed(),
                                "Back to Dashboard button was not displayed");

                Assert.assertTrue(
                                confirmationPage.isAnotherTransferButtonDisplayed(),
                                "Make Another Transfer button was not displayed");
        }
}
