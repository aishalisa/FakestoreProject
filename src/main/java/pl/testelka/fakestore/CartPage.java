package pl.testelka.fakestore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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
    @FindBy(css = "tr>td.product-name")
    WebElement productLocator;
    @FindBy(css = "td>a[data-product_sku]")
    WebElement deleteButton;
    @FindBy(className = "wc-block-components-notice-banner__content")
    List<WebElement> cartMessages;
    @FindBy(className = "blockUI")
    WebElement spinningElement;

    public String checkTotalSum() {
        return cartTotalSum.getText();
    }

    public CartPage goToCartPage() {
        for (int i = 0; i < 2; i++) {
            cartLocator.click();
        }
        wait.until(c -> cartHeader.isDisplayed());
        return this;
    }

    public Boolean checkProductVisible() {
        return wait.until(ExpectedConditions.visibilityOf(productLocator)).isDisplayed();
    }

    public Boolean deleteProductFromCart() {
        deleteButton.click();
        wait.until(ExpectedConditions.invisibilityOfAllElements(spinningElement));
        return wait.until(ExpectedConditions.visibilityOfAllElements(cartMessages)).get(1).isDisplayed();

    }
}
