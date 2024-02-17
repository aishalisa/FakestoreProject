package pl.testelka.fakestore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    @FindBy(css = "tr>td.product-name")
    WebElement productLocator;
    @FindBy(css = "td>a[data-product_sku]")
    WebElement deleteButton;
    @FindBy(xpath = ".//div[@class='woocommerce-notices-wrapper']/*[2]")
    WebElement cartEmptyMessage;
    @FindBy(className = "blockUI")
    WebElement spinningElement;
    @FindBy(css = "input[type='number']")
    WebElement numberBox;
    @FindBy(xpath = ".//button[@name='update_cart']")
    WebElement updateButton;
    @FindBy(xpath = ".//span[text()='2 Produkty']")
    WebElement cartItems;
    @FindBy(id = "coupon_code")
    WebElement couponField;
    @FindBy(xpath = ".//button[@name='apply_coupon']")
    WebElement couponApplyButton;
    @FindBy(css = "tbody>tr[class='cart-subtotal']+tr")
    WebElement couponAppliedSection;

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
        return wait.until(ExpectedConditions.visibilityOf(cartEmptyMessage)).isDisplayed();

    }

    public void reduceProductsNumberTo1() {
        numberBox.clear();
        numberBox.sendKeys("2");
        updateButton.click();
    }

    public String getNumberOfProducts() {
        return cartItems.getText();
    }

    public Boolean addCoupon() {
        couponField.sendKeys("kwotowy250");
        couponApplyButton.click();
        wait.until(ExpectedConditions.invisibilityOfAllElements(spinningElement));
        return wait.until(ExpectedConditions.visibilityOf(couponAppliedSection)).isDisplayed();

    }
}
