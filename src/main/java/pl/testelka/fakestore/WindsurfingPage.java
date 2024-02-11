package pl.testelka.fakestore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WindsurfingPage extends BasePage {

    protected WindsurfingPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = ".//a[contains(@class,'add_to_cart_button')]")
    List<WebElement> addProductButtons;

    public void chooseProduct() {
         addProductButtons.get(1).click();
    }
}
