package pages;

import base.BasePage;
import base.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage() {

        PageFactory.initElements(
                DriverFactory.getDriver(),
                this);
    }

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = ".title")
    private WebElement dashboardTitle;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;

    public void login(String username, String password) {

        writeText(usernameInput, username);
        writeText(passwordInput, password);
        click(loginButton);
    }

    public String getDashboardTitle() {

        return getText(dashboardTitle);
    }

    public String getErrorMessage() {

        return getText(errorMessage);
    }
}