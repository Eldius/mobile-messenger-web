package net.eldiosantos.messenger.cucumber.testcases.util;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import net.eldiosantos.messenger.selenium.helper.IntegrationTestHelper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by Eldius on 24/03/2015.
 */
public class UsefulSteps {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final IntegrationTestHelper helper;

    public UsefulSteps(IntegrationTestHelper helper) {
        this.helper = helper;
    }

    @When("^I take a snapshot and save on the file '(.*)'$")
    public void i_take_a_snapshot_and_save_on_the_file_picture_png(final String fileName) throws Throwable {
        try {
            File scrFile = ((TakesScreenshot) helper.driver).getScreenshotAs(OutputType.FILE);
            final File destFile = new File("./target/pictures/" + fileName);
            FileUtils.touch(destFile);
            destFile.delete();

            FileUtils.copyFile(scrFile, destFile);
        } catch (Exception e) {
            logger.warn("Ok, I couldn't take the screenshot... I'm sorry...", e);
        }
    }

    @When("^I close the browser$")
    public void i_close_the_browser() throws Throwable {
        logger.info("Closing web browser...");
        helper.driver.close();
        helper.driver.quit();
    }

    @Before
    public void setUp(final Scenario scenario) {
        helper.scenario = scenario;
    }

    @After
    public void tearDown(final Scenario scenario) {
        final StringBuffer msg = new StringBuffer("\n######################################################\n")
                .append("Finished scenario: ")
                .append(scenario.getName()).append("\n")
                .append("Scenario status: ")
                .append(scenario.getStatus()).append("\n");

        if(scenario.isFailed()) {
            try {
                msg.append("Scenario failed, cleaning the messe...\n");
                helper.driver.close();
                helper.driver.quit();
            } catch (Exception e) {
                logger.warn("Error trying to close the browser\n", e);
            }
        }

        msg.append("\n######################################################\n");

        logger.info(msg.toString());
    }
}
