package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class AccountsPage extends BasePage {

    // Locators
    private By accountsTable =
            By.cssSelector("table[data-testid='accounts-table']");

    private By accountRows =
            By.cssSelector("tr[data-testid='account-row']");

    private By accountName =
            By.cssSelector("p[data-testid='account-row-name']");

    private By accountType =
            By.cssSelector("span[data-testid='account-row-type-badge']");

    private By accountNumber =
            By.cssSelector("p.font-mono");

    private By accountBalance =
            By.cssSelector("td[data-testid='account-row-balance']");

    // Constructor
    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    // Verifications / Data Retrieval

    public int getAccountCount() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(accountsTable)
        );

        List<WebElement> rows = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(accountRows)
        );

        return rows.size();
    }

    public String getAccountName(int index) {

        List<WebElement> rows = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(accountRows)
        );

        return rows.get(index)
                .findElement(accountName)
                .getText();
    }

    public String getAccountType(int index) {

        List<WebElement> rows = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(accountRows)
        );

        return rows.get(index)
                .findElement(accountType)
                .getText();
    }

    public String getMaskedAccountNumber(int index) {

        List<WebElement> rows = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(accountRows)
        );

        return rows.get(index)
                .findElement(accountNumber)
                .getText();
    }

    public String getAccountBalance(int index) {

        List<WebElement> rows = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(accountRows)
        );

        return rows.get(index)
                .findElement(accountBalance)
                .getText();
    }
}