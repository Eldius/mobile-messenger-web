package net.eldiosantos.messenger.selenium.helper;

import net.eldiosantos.messenger.selenium.factory.SeleniumDriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by eldio.junior on 24/03/2015.
 */
public class WebdriverHelper {
    public WebDriver driver = null;
    public WebdriverHelper() {
        driver = new SeleniumDriverFactory().getDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}
