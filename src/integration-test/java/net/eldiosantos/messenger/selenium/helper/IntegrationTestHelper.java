package net.eldiosantos.messenger.selenium.helper;

import cucumber.api.Scenario;
import net.eldiosantos.messenger.selenium.factory.SeleniumDriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by eldio.junior on 24/03/2015.
 */
public class IntegrationTestHelper {
    public WebDriver driver = null;
    public Scenario scenario = null;

    public IntegrationTestHelper() {
        driver = new SeleniumDriverFactory().getDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}
