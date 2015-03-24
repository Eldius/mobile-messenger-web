package net.eldiosantos.messenger.selenium.factory;

import org.openqa.selenium.WebDriver;

/**
 * Created by eldio.junior on 24/03/2015.
 */
public class WebdriverHelper {
    public WebDriver driver = new SeleniumDriverFactory().getDriver();
}
