package pl.testelka.fakestore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CartTests extends BaseTest {
    @Test
    public void checkProductWasAddedToTheCart() {
        ShopPage shopPage = new ShopPage(driver);
        shopPage.goToShopPage().goToWindsurfingPage();
        WindsurfingPage windsurfingPage = new WindsurfingPage(driver);
        windsurfingPage.chooseProduct();
        CartPage cartPage = new CartPage(driver);
        cartPage.goToCartPage();
        Boolean isProductInTheCart = cartPage.checkProductVisible();
        Assertions.assertTrue(isProductInTheCart);
    }

    @Test
    public void checkProductWasDeletedFromTheCart() {
        ShopPage shopPage = new ShopPage(driver);
        shopPage.goToShopPage().goToWindsurfingPage();
        WindsurfingPage windsurfingPage = new WindsurfingPage(driver);
        windsurfingPage.chooseProduct();
        CartPage cartPage = new CartPage(driver);
        Boolean isCartEmptyMessageVisible = cartPage.goToCartPage().deleteProductFromCart();
        Assertions.assertTrue(isCartEmptyMessageVisible);

    }

    @Test
    public void checkTotalSumOfTheCart() {
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
        Assertions.assertEquals("9 400,00 zł", totalSum, "The Total Sum of 3 items is wrong.");
    }

    @Test
    public void checkProductsNumberChangedInTheCart() {
        ShopPage shopPage = new ShopPage(driver);
        shopPage.goToShopPage().goToSailingPage();
        SailingPage sailingPage = new SailingPage(driver);
        sailingPage.addTreeItemsToTheCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.goToCartPage().reduceProductsNumberTo1();
        String numberOfProducts = cartPage.getNumberOfProducts();
        Assertions.assertEquals(numberOfProducts, "2 Produkty", "The number of products in the cart is wrong");
    }
}
