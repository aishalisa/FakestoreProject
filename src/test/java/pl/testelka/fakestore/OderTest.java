package pl.testelka.fakestore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OderTest extends BaseTest {
    @Test
    void completeOrder() throws InterruptedException {
        Common common = new Common(driver);
        common.addWindsurfingProductToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.goToCartPage().goToOrdersPage();
        OrderPage orderPage = new OrderPage(driver);
        orderPage
                .login()
                .enterAddressData()
                .enterPaymentData();
        String orderReceivedMessage = orderPage.submitPayment();
        Assertions.assertEquals("Dziękujemy. Otrzymaliśmy Twoje zamówienie.", orderReceivedMessage,
                "The order wasn't finished");
    }


}
