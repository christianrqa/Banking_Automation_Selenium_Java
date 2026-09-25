package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class LoginPage extends BasePage {

    // Locators
    private By usernameInput = By.id("login-username");
    private By passwordInput = By.id("login-password");
    private By loginButton = By.cssSelector("[data-testid='login-submit-btn']");
    private By errorMessage = By.cssSelector("[data-testid='login-error-message']");

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public void enterUsername(String username) {
        type(usernameInput, username);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // Verifications

public boolean isLoginButtonDisplayed() {
    return driver.findElement(loginButton).isDisplayed();
}

public boolean isLoginButtonEnabled() {
    return driver.findElement(loginButton).isEnabled();
}

public boolean isPasswordMasked() {
    String inputType = driver.findElement(passwordInput)
            .getAttribute("type");

    return "password".equals(inputType);
}

public boolean isErrorMessageVisible() {
    return wait.until(
        ExpectedConditions.visibilityOfElementLocated(errorMessage)
    ).isDisplayed();
}

public String getErrorMessage() {
    return wait.until(
        ExpectedConditions.visibilityOfElementLocated(errorMessage)
    ).getText();
}
}