package net.eldiosantos.messenger.cucumber.testcase.login;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.AssertionFailedError;
import net.eldiosantos.messenger.selenium.factory.SeleniumDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

/**
 * Created by eldio.junior on 23/03/2015.
 */
public class LoginSteps {

    public static final String BASE_URL = "http://localhost:8080/mobile-messenger";
    private final WebDriver driver = new SeleniumDriverFactory().getFirefox();

    public LoginSteps() {
    }

    @Given("^I open the home page$")
    public void i_open_the_home_page() throws Throwable {
        System.out.println("Opening system home page...");
        driver.get(BASE_URL);
    }

    @When("^I try to login as '(.+)' with '(.+)' as my password$")
    public void i_try_to_login_as_admin_with_as_my_password(final String user, final String pass) throws Throwable {
        System.out.println("######################################################");
        System.out.println(String.format("first method:\n * user: %s\n * pass: %s\n", user, pass));
        driver.findElement(By.cssSelector("input[name='login']")).sendKeys(user);
        driver.findElement(By.cssSelector("input[name='pass']")).sendKeys(pass);
        driver.findElement(By.cssSelector("#send")).click();
    }

    @Then("^I can see the logged user menu on the right$")
    public void i_can_see_the_logged_user_menu_on_the_right() throws Throwable {
        System.out.println("######################################################");
        System.out.println("Last method!!!!!!!!!!!!!!!!!");
        System.out.println("######################################################");

        final WebElement userSession = driver.findElement(By.id("userSession"));

        assertTrue("User session details is present?", userSession.isDisplayed());

        System.out.println("Closing web browser...");
        driver.close();
    }
}
