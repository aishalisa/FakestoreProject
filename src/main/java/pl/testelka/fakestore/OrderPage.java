package pl.testelka.fakestore;

import helpers.CredentialsReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage extends BasePage {
    protected OrderPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    CredentialsReader credentials = new CredentialsReader();
    @FindBy(className = "showlogin")
    WebElement showLoginButton;
    @FindBy(id = "billing_first_name")
    WebElement nameField;
    @FindBy(id = "billing_last_name")
    WebElement surnameField;
    @FindBy(css = "input[id='billing_address_1']")
    WebElement streetField;
    @FindBy(css = "input[id='billing_postcode']")
    WebElement postcodeField;
    @FindBy(id = "billing_phone")
    WebElement phoneField;
    @FindBy(css = "input[id='billing_city']")
    WebElement cityField;
    @FindBy(css = "#stripe-card-element iframe")
    WebElement firstFrame;
    @FindBy(name = "cardnumber")
    WebElement numberField;
    @FindBy(css = "#stripe-exp-element iframe")
    WebElement secondFrame;
    @FindBy(name = "exp-date")
    WebElement expDateField;
    @FindBy(css = "#stripe-cvc-element iframe")
    WebElement thirdFrame;
    @FindBy(name = "cvc")
    WebElement numberCVCField;
    @FindBy(css = "input#terms")
    WebElement termsCheckbox;
    @FindBy(id = "place_order")
    WebElement submitButton;
    @FindBy(css = ".woocommerce-order>p")
    WebElement orderReceivedMessage;
    @FindBy(className = "blockUI")
    WebElement spinningElement;

    public OrderPage login() {
        showLoginButton.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterCredentials();
        return this;
    }

    public OrderPage enterAddressData() {
        credentials = new CredentialsReader();
        String name = credentials.getName();
        nameField.sendKeys(name);
        String surname = credentials.getSurname();
        surnameField.sendKeys(surname);
        String street = credentials.getStreet();
        streetField.sendKeys(street);
        String postCode = credentials.getPostCode();
        postcodeField.sendKeys(postCode);
        String city = credentials.getCity();
        cityField.sendKeys(city);
        String phone = credentials.getPhone();
        phoneField.sendKeys(phone);
        return this;
    }

    public OrderPage enterPaymentData() throws InterruptedException {
        driver.switchTo().frame(firstFrame);
        String cardNumber = credentials.getCardNumber();
        numberField.sendKeys(cardNumber);
        driver.switchTo().defaultContent();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.switchTo().frame(secondFrame);
        String validDate = credentials.getValidDate();
        expDateField.sendKeys(validDate);
        driver.switchTo().defaultContent();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.switchTo().frame(thirdFrame);
        String cvcNumber = credentials.getCvc();
        numberCVCField.sendKeys(cvcNumber);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox)).click();
        return this;
    }

    public String submitPayment() {
        submitButton.click();
        wait.until(ExpectedConditions.invisibilityOfAllElements(spinningElement));
        return wait.until(ExpectedConditions.visibilityOf(orderReceivedMessage)).getText();
    }
}
