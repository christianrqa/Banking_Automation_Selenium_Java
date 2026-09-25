package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class TransferConfirmationPage extends BasePage {

    private By successHeading =
            By.cssSelector("[data-testid='transfer-success-heading']");

    private By referenceNumber =
            By.cssSelector("[data-testid='transfer-ref-id']");

    private By fromAccount =
            By.cssSelector("[data-testid='confirm-from-account']");

    private By toAccount =
            By.cssSelector("[data-testid='confirm-to-account']");

    private By amount =
            By.cssSelector("[data-testid='confirm-amount']");

    private By transferDate =
            By.cssSelector("[data-testid='confirm-date']");

    private By backToDashboardButton =
            By.cssSelector("[data-testid='back-to-dashboard-btn']");

    private By anotherTransferButton =
            By.cssSelector("[data-testid='another-transfer-btn']");

    public TransferConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSuccessHeadingDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        successHeading
                )
        ).isDisplayed();
    }

    public String getReferenceNumber() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        referenceNumber
                )
        ).getText();
    }

    public String getFromAccount() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        fromAccount
                )
        ).getText();
    }

    public String getToAccount() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        toAccount
                )
        ).getText();
    }

    public String getAmount() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        amount
                )
        ).getText();
    }

    public String getTransferDate() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        transferDate
                )
        ).getText();
    }

    public boolean isBackToDashboardButtonDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        backToDashboardButton
                )
        ).isDisplayed();
    }

    public boolean isAnotherTransferButtonDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        anotherTransferButton
                )
        ).isDisplayed();
    }

    public void clickBackToDashboard() {
        click(backToDashboardButton);
    }

    public void clickAnotherTransfer() {
        click(anotherTransferButton);
    }
}