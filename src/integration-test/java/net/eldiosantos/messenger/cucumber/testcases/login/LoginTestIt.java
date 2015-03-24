package net.eldiosantos.messenger.cucumber.testcases.login;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by eldio.junior on 23/03/2015.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:net/eldiosantos/messenger/cucumber/testcases/login/login.feature"}
        , format = {"pretty", "json:target/cucumber/login.json"}
        , glue = {"net.eldiosantos.messenger.cucumber.testcases"}
)
public class LoginTestIt {

}
