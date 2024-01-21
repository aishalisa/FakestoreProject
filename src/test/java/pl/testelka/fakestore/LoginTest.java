package pl.testelka.fakestore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        String title = loginPage.enterCredentials();
        Assertions.assertEquals("Moje konto", title, "You failed to login.");
    }
}
