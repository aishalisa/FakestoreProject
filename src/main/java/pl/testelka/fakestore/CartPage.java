package pl.testelka.fakestore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage {
    protected CartPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(xpath = ".//tr[@class='order-total']//bdi")
    WebElement cartTotalSum;
    @FindBy(xpath = ".//a[@class='cart-contents']")
    WebElement cartLocator;
    @FindBy(css = "h1.entry-title")
    WebElement cartHeader;
    @FindBy(className = "woocommerce-cart-form__cart-item cart_item")
    WebElement productLocator;

    public String checkTotalSum() {
        return cartTotalSum.getText();
    }

    public void goToCartPage() {
        cartLocator.click();
        wait.until(c -> cartHeader.isDisplayed());
    }

    public Boolean checkProductVisible() {
        return productLocator.isDisplayed();
    }
}
