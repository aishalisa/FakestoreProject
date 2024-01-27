package pl.testelka.fakestore;

import helpers.CredentialsReader;
import helpers.TestDataReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

abstract public class BaseTest {
    protected WebDriver driver;
    Wait<WebDriver> wait;
    static TestDataReader testData;
    static CredentialsReader credentials;

    @BeforeAll
    static public void setupConfiguration() {
        WebDriverManager.chromedriver().setup();
        testData = new TestDataReader();
        credentials = new CredentialsReader();
    }

    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless==new");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);
        driver.get(testData.getBaseURL());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
