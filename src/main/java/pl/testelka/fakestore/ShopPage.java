package pl.testelka.fakestore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShopPage extends BasePage {
    DemoNotice demoNotice;

    protected ShopPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        demoNotice = new DemoNotice(driver);
    }

    @FindBy(xpath = ".//ul[@id='menu-menu']/li[2]")
    WebElement buttonShop;
    @FindBy(css = "li.product-category")
    List<WebElement> products;

    void goToWindsurfingPage() {
        demoNotice.closeDemoNotice();
        products.get(0).click();
    }

    void goToYogaPilatesPage() {
        products.get(2).click();
    }

    public ShopPage goToShopPage() {
        buttonShop.click();
        return this;
    }
}
