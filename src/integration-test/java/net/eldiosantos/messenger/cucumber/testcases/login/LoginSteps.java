package net.eldiosantos.messenger.cucumber.testcases.login;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.eldiosantos.messenger.selenium.factory.WebdriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

/**
 * Created by eldio.junior on 23/03/2015.
 */
public class LoginSteps {

    private final WebDriver driver;

    public LoginSteps(final WebdriverHelper helper) {
        this.driver = helper.driver;
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
        driver.quit();
    }

    @Then("^I shall not pass$")
    public void i_shall_not_pass() throws Throwable {
        final WebElement loginForm = driver.findElement(By.className("form-horizontal"));
        assertTrue("I couldn't log in", loginForm.isDisplayed());
        System.out.println("Closing web browser...");
        driver.quit();
    }
}
