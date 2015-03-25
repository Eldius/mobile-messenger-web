package net.eldiosantos.messenger.cucumber.testcases.user;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.eldiosantos.messenger.selenium.helper.IntegrationTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

/**
 * Created by eldio.junior on 25/03/2015.
 */
public class UserSteps {

    private final IntegrationTestHelper helper;

    public UserSteps(IntegrationTestHelper helper) {
        this.helper = helper;
    }

    @When("^click on the sign up button$")
    public void click_on_the_sign_up_button() throws Throwable {
        helper.driver.findElement(By.id("signupButton")).click();
    }

    @When("^create a user with login \"(.*?)\", password \"(.*?)\" and email \"(.*?)\"$")
    public void create_a_user_with_login_password_and_email(final String user, final String pass, final String email) throws Throwable {
        helper.driver.findElement(By.id("user_field_login")).sendKeys(user);
        helper.driver.findElement(By.id("user_field_pass")).sendKeys(pass);
        helper.driver.findElement(By.id("user_field_email")).sendKeys(email);

    }

    @When("^click save user$")
    public void click_save_user() throws Throwable {
        helper.driver.findElement(By.id("user_form_save")).click();
    }

    @Then("^I can't see the admin menu item$")
    public void i_can_t_see_the_admin_menu_item() throws Throwable {
        try {
            helper.driver.findElement(By.id("admin_menu_item"));
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue("I can't find the button", e.getClass().equals(org.openqa.selenium.NoSuchElementException.class));
        }
    }

    @When("^open the logged user menu and click on the profile item$")
    public void open_the_logged_user_menu_and_click_on_the_profile_item() throws Throwable {
        helper.driver.findElement(By.xpath("//*[@id=\"userSession\"]/li/a")).click();
        helper.driver.findElement(By.id("userSession_profile_subitem")).click();
    }

    @When("^change my password to \"(.*?)\"$")
    public void change_my_password_to(String newPass) throws Throwable {
        helper.driver.findElement(By.id("user_field_pass")).sendKeys(newPass);
    }
}
