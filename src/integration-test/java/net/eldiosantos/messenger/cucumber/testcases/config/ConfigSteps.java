package net.eldiosantos.messenger.cucumber.testcases.config;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.eldiosantos.messenger.selenium.helper.IntegrationTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

/**
 * Created by eldio.junior on 24/03/2015.
 */
public class ConfigSteps {
    private final WebDriver driver;

    public ConfigSteps(final IntegrationTestHelper helper) {
        driver = helper.driver;
    }

    @When("^open the admin console$")
    public void open_the_admin_console() throws Throwable {
        WebElement adminMenuItem = driver.findElement(By.id("admin_menu_item"));
        adminMenuItem.click();
    }

    @When("^select the open user registration option$")
    public void select_the_open_user_registration_option() throws Throwable {
        setOpenRegisteringChecked(true);
    }

    @When("^click on save config button$")
    public void click_on_save_button() throws Throwable {
        driver.findElement(By.id("save")).click();
    }

    @When("^log out from the system$")
    public void log_out_from_the_system() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"userSession\"]/li/a")).click();
        driver.findElement(By.xpath("//*[@id=\"userSession\"]/li/ul/li[2]/a")).click();
    }

    @Then("^I can see the sign up button$")
    public void i_can_see_the_sign_up_button() throws Throwable {
        final WebElement signup = driver.findElement(By.id("signupButton"));
        assertTrue("Sign up button is visible", signup.isDisplayed());
    }

    @When("^unselect the open user registration option$")
    public void unselect_the_open_user_registration_option() throws Throwable {
        setOpenRegisteringChecked(false);
    }

    private void setOpenRegisteringChecked(final Boolean check) {
        final WebElement checkElement = driver.findElement(By.id("openReg"));
        if(!check.equals(checkElement.isSelected())) {
            checkElement.click();
        }
    }

    @Then("^I can't see the sign up button$")
    public void I_can_t_see_the_sign_up_button() throws Throwable {
        try {
            driver.findElement(By.id("signupButton"));
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue("I can't find the button", e.getClass().equals(org.openqa.selenium.NoSuchElementException.class));
        }
    }
}
