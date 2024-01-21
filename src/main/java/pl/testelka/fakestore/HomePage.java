package pl.testelka.fakestore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    protected HomePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(css = "#menu-menu>li:nth-child(5)")
    WebElement buttonMyAccount;

    public void goToLoginPage() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonMyAccount)).click();
    }
}
