package net.eldiosantos.messenger.selenium.factory;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import javax.inject.Singleton;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eldio.junior on 23/03/2015.
 */
public class SeleniumDriverFactory {

    public List<WebDriver>getDriverList() {
        return Arrays.asList(new WebDriver[]{new FirefoxDriver()});
    }

    public WebDriver getDriver() {
        return new FirefoxDriver();
    }
}
