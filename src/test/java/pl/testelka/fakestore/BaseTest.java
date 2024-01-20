package pl.testelka.fakestore;

import Helpers.ConfigurationReader;
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
    static ConfigurationReader configuration;

    @BeforeAll
    static public void setupConfiguration() {
        WebDriverManager.chromedriver().setup();
        configuration = new ConfigurationReader();
    }

    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless==new");
        driver = new ChromeDriver(options);
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);
        driver.get(configuration.getBaseURL());

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
