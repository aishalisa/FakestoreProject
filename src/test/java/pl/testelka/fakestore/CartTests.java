package pl.testelka.fakestore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTests extends BaseTest {
    @Test
    public void checkProductWasAddedToTheCart() {
        Common common = new Common(driver);
        common.addWindsurfingProductToCart();
        Boolean isProductInTheCart = new CartPage(driver).goToCartPage().checkProductVisible();
        assertTrue(isProductInTheCart);
    }

    @Test
    public void checkProductWasDeletedFromTheCart() {
        Common common = new Common(driver);
        common.addWindsurfingProductToCart();
        Boolean isCartEmptyMessageVisible = new CartPage(driver).goToCartPage().deleteProductFromCart();
        assertTrue(isCartEmptyMessageVisible);

    }

    @Test
    public void checkTotalSumOfTheCart() {
        Common common = new Common(driver);
        common.addWindsurfingProductToCart();
        ShopPage shopPage = new ShopPage(driver);
        shopPage.goToShopPage().goToYogaPilatesPage();
        YogaPilatesPage yogaPilatesPage = new YogaPilatesPage(driver);
        yogaPilatesPage.chooseProductTwice();
        String totalSum = new CartPage(driver).goToCartPage().checkTotalSum();
        assertEquals("9 400,00 zł", totalSum, "The Total Sum of 3 items is wrong.");
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
        assertEquals(numberOfProducts, "2 Produkty", "The number of products in the cart is wrong");
    }

    @Test
    public void checkCouponWasApplied() {
        Common common = new Common(driver);
        common.addWindsurfingProductToCart();
        Boolean isCouponApplied = new CartPage(driver).goToCartPage().addCoupon();
        assertTrue(isCouponApplied, "Coupon wasn't applied");
    }
}
