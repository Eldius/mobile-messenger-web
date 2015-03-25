package net.eldiosantos.messenger.selenium.factory;


import net.eldiosantos.messenger.selenium.helper.IntegrationTestHelper;
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

    private IntegrationTestHelper helper;

    public IntegrationTestHelper getHelper() {
        return helper;
    }

    public void setHelper(IntegrationTestHelper helper) {
        this.helper = helper;
    }

    public WebDriver getDriver() {
        final WebDriver driver = getScreenshotDriver(new FirefoxDriver());
        return driver;
    }

    private WebDriver getScreenshotDriver(final WebDriver driver) {
        final EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(new AbstractWebDriverEventListener() {

            @Override
            public void onException(Throwable throwable, WebDriver driver) {
                try {
                    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    final String imageFileName = SeleniumDriverFactory.this.getHelper().scenario.getName().replaceAll(" ", "_");
                    final File destFile = new File("./target/pictures/" + imageFileName + ".png");
                    FileUtils.touch(destFile);
                    destFile.delete();
                    FileUtils.copyFile(scrFile, destFile);
                } catch (Exception e) {
                    System.out.println("Ok, I couldn't take the screenshot... I'm sorry...");
                }
                super.onException(throwable, driver);
            }
        });
        return eventFiringWebDriver;
    }
}
