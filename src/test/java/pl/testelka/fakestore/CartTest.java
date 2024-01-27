package pl.testelka.fakestore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest{
    @Test
    public void checkProductWasAddedToTheCart(){
        ShopPage shopPage = new ShopPage(driver);
        shopPage.goToShopPage().goToWindsurfingPage();
        WindsurfingPage windsurfingPage = new WindsurfingPage(driver);
        windsurfingPage.chooseProduct();
        CartPage cartPage = new CartPage(driver);
        cartPage.goToCartPage();
        Boolean isProductInTheCart = cartPage.checkProductVisible();
    }
    @Test
    public void checkTotalSumOfTheCart(){
        ShopPage shopPage = new ShopPage(driver);
        shopPage.goToShopPage().goToWindsurfingPage();
        WindsurfingPage windsurfingPage = new WindsurfingPage(driver);
        windsurfingPage.chooseProduct();
        shopPage.goToShopPage().goToYogaPilatesPage();
        YogaPilatesPage yogaPilatesPage = new YogaPilatesPage(driver);
        yogaPilatesPage.chooseProductTwice();
        CartPage cartPage = new CartPage(driver);
        cartPage.goToCartPage();
        String totalSum = cartPage.checkTotalSum();
        Assertions.assertEquals("6 500,00 zł", totalSum, "The Total Sum is wrong.");
    }
}
