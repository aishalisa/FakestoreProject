package pl.testelka.fakestore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginValidPath() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        String title = loginPage.enterCredentials();
        Assertions.assertEquals("Moje konto", title, "You failed to login.");
    }

    @Test
    public void loginWrongCredentials() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        Boolean errorPopupIsVisible = loginPage.enterWrongCredentials();
        Assertions.assertTrue(errorPopupIsVisible, "No error message visible, maybe your credentials are OK?");
    }
    @Test
    public void loginWithoutCredentials(){
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        Boolean errorPopupIsVisible = loginPage.loginWithoutCredentials();
        Assertions.assertTrue(errorPopupIsVisible);
    }
}
