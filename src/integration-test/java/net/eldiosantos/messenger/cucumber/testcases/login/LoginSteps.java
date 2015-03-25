package net.eldiosantos.messenger.cucumber.testcases.login;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.eldiosantos.messenger.selenium.helper.IntegrationTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

/**
 * Created by eldio.junior on 23/03/2015.
 */
public class LoginSteps {

    private final WebDriver driver;

    public LoginSteps(final IntegrationTestHelper helper) {
        this.driver = helper.driver;
    }

    @When("^I try to login as '(.+)' with '(.+)' as my password$")
    public void i_try_to_login_as_admin_with_as_my_password(final String user, final String pass) throws Throwable {
        Thread.sleep(5000);
        System.out.println("######################################################");
        System.out.println(String.format("first method:\n * user: %s\n * pass: %s\n", user, pass));
        driver.findElement(By.id("menubar_login_field")).sendKeys(user);
        driver.findElement(By.id("menubar_pass_field")).sendKeys(pass);
        driver.findElement(By.id("login_button")).click();
    }

    @Then("^I can see the logged user menu on the right$")
    public void i_can_see_the_logged_user_menu_on_the_right() throws Throwable {
        System.out.println("######################################################");
        System.out.println("Last method!!!!!!!!!!!!!!!!!");
        System.out.println("######################################################");

        final WebElement userSession = driver.findElement(By.id("userSession"));

        assertTrue("User session details is present?", userSession.isDisplayed());
    }

    @Then("^I shall not pass$")
    public void i_shall_not_pass() throws Throwable {
        final WebElement loginForm = driver.findElement(By.id("loginForm"));
        assertTrue("I couldn't log in", loginForm.isDisplayed());
    }

    @When("^I click on the login menu$")
    public void i_click_on_the_login_menu() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/ul/li[2]/a")).click();
    }

    @Then("^I can see the login form$")
    public void i_can_see_the_login_form() throws Throwable {
        final WebElement loginForm = driver.findElement(By.className("form-horizontal"));
        final WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"send\"]"));

        assertTrue("The login form is visible?", loginForm.isDisplayed());
        assertTrue("The login button is visible?", loginButton.isDisplayed());
    }
}
