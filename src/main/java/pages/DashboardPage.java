package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class DashboardPage extends BasePage {

    // Locators
    private By accountsLink =
            By.cssSelector("a[data-testid='sidebar-link-accounts']");

    private By welcomeMessage =
            By.cssSelector("[data-testid='dashboard-welcome-message']");

    private By totalBalance =
            By.cssSelector("[data-testid='stat-card-net-worth-value']");

    private By recentTransactions =
            By.cssSelector("tr[data-testid='recent-txn-row']");
    private By transferLink =
        By.cssSelector("a[data-testid='sidebar-link-transfer']");

    // Constructor
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    // Verifications
    public boolean isWelcomeMessageVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(welcomeMessage)
        ).isDisplayed();
    }

    public String getTotalBalance() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(totalBalance)
        ).getText();
    }

    public int getRecentTransactionCount() {
        return wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(recentTransactions)
        ).size();
    }
    
    public AccountsPage goToAccountsPage() {
        click(accountsLink);
        return new AccountsPage(driver);
    }
    public TransferPage goToTransferPage() {
    click(transferLink);
    return new TransferPage(driver);
    }
    

}