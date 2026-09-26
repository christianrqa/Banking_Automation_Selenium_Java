package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class TransferPage extends BasePage {

        // =========================================================
        // Locators
        // =========================================================

        private By fromAccountDropdown = By.cssSelector("[data-testid='transfer-from-select']");

        private By toAccountDropdown = By.cssSelector("[data-testid='transfer-to-select']");

        private By amountInput = By.cssSelector("[data-testid='transfer-amount-input']");

        private By memoInput = By.name("transfer_memo_field");

        private By todayRadio = By.cssSelector("[data-testid='date-type-today']");

        private By scheduledRadio = By.cssSelector("[data-testid='date-type-scheduled']");
        private By scheduledDateInput = By.cssSelector("[data-testid='transfer-scheduled-date-input']");

        private By reviewTransferButton = By.cssSelector("[data-testid='review-transfer-btn']");

        private By cancelTransferButton = By.cssSelector("[data-testid='cancel-transfer-btn']");
        private By confirmTransferButton = By.cssSelector("[data-testid='confirm-transfer-btn']");

        private By cancelConfirmTransferButton = By.cssSelector("[data-testid='cancel-confirm-transfer-btn']");
        private By confirmFromAccount = By.xpath("//div[span[normalize-space()='From']]/span[2]");

        private By confirmToAccount = By.xpath("//div[span[normalize-space()='To']]/span[2]");

        private By confirmAmount = By.xpath("//div[span[normalize-space()='Amount']]/span[2]");

        private By confirmDate = By.xpath("//div[span[normalize-space()='Date']]/span[2]");

        // =========================================================
        // Constructor
        // =========================================================

        public TransferPage(WebDriver driver) {
                super(driver);
        }

        // =========================================================
        // Account Selection
        // =========================================================

        public void selectFromAccount(String accountId) {

                click(fromAccountDropdown);

                By accountOption = By.cssSelector(
                                "[data-testid='transfer-from-option']" +
                                                "[data-account-id='" + accountId + "']");

                click(accountOption);
        }

        public void selectToAccount(String accountId) {

                click(toAccountDropdown);

                By accountOption = By.cssSelector(
                                "[data-testid='transfer-to-option']" +
                                                "[data-account-id='" + accountId + "']");

                click(accountOption);
        }

        // =========================================================
        // Transfer Details
        // =========================================================

        public void enterAmount(String amount) {
                type(amountInput, amount);
        }

        public void enterMemo(String memo) {
                type(memoInput, memo);
        }

        // =========================================================
        // Transfer Date
        // =========================================================

        public void selectToday() {
                click(todayRadio);
        }

        public void selectScheduled() {
                click(scheduledRadio);
        }

        public void enterScheduledDate(String date) {
                click(scheduledDateInput);
                type(scheduledDateInput, date);
        }

        public String getApplicationTodayDate() {

                selectScheduled();

                String applicationDate = wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                scheduledDateInput))
                                .getAttribute("min");

                selectToday();

                return applicationDate;
        }

        // =========================================================
        // Actions
        // =========================================================

        public void clickReviewTransfer() {
                click(reviewTransferButton);
        }

        public void clickCancel() {
                click(cancelTransferButton);
        }

        // =========================================================
        // Verifications
        // =========================================================

        public boolean isFromAccountDropdownDisplayed() {
                return wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                fromAccountDropdown))
                                .isDisplayed();
        }

        public boolean isToAccountDropdownDisplayed() {
                return wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                toAccountDropdown))
                                .isDisplayed();
        }

        public boolean isAmountInputDisplayed() {
                return wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                amountInput))
                                .isDisplayed();
        }

        public boolean isMemoInputDisplayed() {
                return wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                memoInput))
                                .isDisplayed();
        }

        public boolean isTodaySelected() {
                return wait.until(
                                ExpectedConditions.visibilityOfElementLocated(todayRadio))
                                .findElement(By.cssSelector("input"))
                                .isSelected();
        }

        public boolean isScheduledSelected() {
                return wait.until(
                                ExpectedConditions.visibilityOfElementLocated(scheduledRadio))
                                .findElement(By.cssSelector("input"))
                                .isSelected();
        }

        public boolean isScheduledDateDisplayed() {
                return wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                scheduledDateInput))
                                .isDisplayed();
        }

        public boolean isReviewTransferButtonDisplayed() {
                return wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                reviewTransferButton))
                                .isDisplayed();
        }

        public boolean isReviewTransferButtonEnabled() {
                return driver.findElement(reviewTransferButton).isEnabled();
        }

        public void clickConfirmTransfer() {
                click(confirmTransferButton);
        }

        public void clickCancelConfirmTransfer() {
                click(cancelConfirmTransferButton);
        }

        public boolean isConfirmTransferButtonDisplayed() {
                return wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                confirmTransferButton))
                                .isDisplayed();
        }

        public boolean isCancelConfirmTransferButtonDisplayed() {
                return wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                cancelConfirmTransferButton))
                                .isDisplayed();
        }

        public String getConfirmFromAccount() {
                return wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                confirmFromAccount))
                                .getText();
        }

        public String getConfirmToAccount() {
                return wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                confirmToAccount))
                                .getText();
        }

        public String getConfirmAmount() {
                return wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                confirmAmount))
                                .getText();
        }

        public String getConfirmDate() {
                return wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                confirmDate))
                                .getText();
        }

}