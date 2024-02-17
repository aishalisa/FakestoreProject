package pl.testelka.fakestore;

import org.openqa.selenium.WebDriver;

public class Common extends BasePage{
    protected Common(WebDriver driver) {
        super(driver);
    }
    public void addWindsurfingProductToCart(){
        ShopPage shopPage = new ShopPage(driver);
        shopPage.goToShopPage().goToWindsurfingPage();
        WindsurfingPage windsurfingPage = new WindsurfingPage(driver);
        windsurfingPage.chooseProduct();

    }
}
