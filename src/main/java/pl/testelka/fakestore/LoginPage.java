package pl.testelka.fakestore;

import helpers.CredentialsReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    protected LoginPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(id = "username")
    WebElement emailField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(name = "login")
    WebElement loginButton;
    @FindBy(css = "h1.entry-title")
    WebElement title;

    public String enterCredentials() {
        CredentialsReader credentials = new CredentialsReader();
        String userEmail = credentials.getUserEmail();
        emailField.sendKeys(userEmail);
        String userPassword = credentials.getUserPassword();
        passwordField.sendKeys(userPassword);
        loginButton.click();
        return title.getText();
    }
}
