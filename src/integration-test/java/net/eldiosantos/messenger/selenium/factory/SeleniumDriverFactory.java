package net.eldiosantos.messenger.selenium.factory;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
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
        final WebDriver driver = getScreenshotDriver(new FirefoxDriver());
        return driver;
    }

    private WebDriver getScreenshotDriver(final WebDriver driver) {
        final EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(new CustomWebdriverEventListener());
        return eventFiringWebDriver;
    }

    private static class CustomWebdriverEventListener extends AbstractWebDriverEventListener {
        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            try {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                final File destFile = new File("./target/pictures/" + System.currentTimeMillis() + ".png");
                FileUtils.touch(destFile);
                destFile.delete();
            } catch (Exception e) {
                System.out.println("Ok, I couldn't take the screenshot... I'm sorry...");
            }
            super.onException(throwable, driver);
        }
    }
}
