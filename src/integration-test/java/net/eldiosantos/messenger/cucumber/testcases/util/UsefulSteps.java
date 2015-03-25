package net.eldiosantos.messenger.cucumber.testcases.util;

import cucumber.api.java.en.When;
import net.eldiosantos.messenger.selenium.helper.WebdriverHelper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

/**
 * Created by Eldius on 24/03/2015.
 */
public class UsefulSteps {

    final WebDriver driver;

    public UsefulSteps(WebdriverHelper helper) {
        this.driver = helper.driver;
    }

    @When("^I take a snapshot and save on the file '(.*)'$")
    public void i_take_a_snapshot_and_save_on_the_file_picture_png(final String fileName) throws Throwable {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            final File destFile = new File("./target/pictures/" + fileName);
            FileUtils.touch(destFile);
            destFile.delete();

            FileUtils.copyFile(scrFile, destFile);
        } catch (Exception e) {
            System.out.println("Ok, I couldn't take the screenshot... I'm sorry...");
        }
    }

    @When("^I close the browser$")
    public void i_close_the_browser() throws Throwable {
        driver.close();
        driver.quit();
    }
}
