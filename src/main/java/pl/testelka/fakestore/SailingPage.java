package pl.testelka.fakestore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SailingPage extends BasePage {
    protected SailingPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(xpath = ".//a[contains(@class,'add_to_cart_button')]")
    WebElement addProductButton;

    public void addTreeItemsToTheCart() {
        for (int i = 0; i < 3; i++) {
          //  wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(addProductButton))).click();
           // wait.until(ExpectedConditions.elementToBeClickable(addProductButton)).click();
           addProductButton.click();
        }
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(addProductButton)));
    }
}

