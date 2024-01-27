package pl.testelka.fakestore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YogaPilatesPage extends BasePage{
    protected YogaPilatesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = ".//a[contains(@class,'add_to_cart_button')]")
    List<WebElement> addProductButtons;
    public void chooseProductTwice() {
        for (int i = 0; i < 1; i++) {
            addProductButtons.get(2).click();
        }
    }
}
