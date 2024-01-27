package pl.testelka.fakestore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoNotice extends BasePage {
    protected DemoNotice(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "woocommerce-store-notice__dismiss-link")
    WebElement demoNotice;

    void closeDemoNotice() {
        demoNotice.click();
    }
}
