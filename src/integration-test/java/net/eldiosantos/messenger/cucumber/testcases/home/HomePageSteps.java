package net.eldiosantos.messenger.cucumber.testcases.home;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.eldiosantos.messenger.selenium.helper.IntegrationTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

/**
 * Created by eldio.junior on 24/03/2015.
 */
public class HomePageSteps {

    public static final String BASE_URL = "http://localhost:8080/mobile-messenger";

    private final WebDriver driver;

    public HomePageSteps(final IntegrationTestHelper helper) {
        this.driver = helper.driver;
    }

    @Given("^I open the home page$")
    public void i_open_the_home_page() throws Throwable {
        System.out.println("Opening system home page...");
        driver.get(BASE_URL);
    }

    @Then("^I can see the login fields$")
    public void i_can_see_the_login_fields() throws Throwable {
        final Boolean isVisible = driver.findElement(By.id("loginForm")).isDisplayed();
        assertTrue("Are the login fields visible?", isVisible);
    }
}
