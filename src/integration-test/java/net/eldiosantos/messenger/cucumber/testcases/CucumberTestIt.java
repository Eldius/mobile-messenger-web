package net.eldiosantos.messenger.cucumber.testcases;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by eldio.junior on 24/03/2015.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "classpath:net/eldiosantos/messenger/cucumber/testcases/homepage/homepage.feature"
                , "classpath:net/eldiosantos/messenger/cucumber/testcases/login/login.feature"
                , "classpath:net/eldiosantos/messenger/cucumber/testcases/config/config.feature"
        }
        , format = {"pretty", "json:target/cucumber/results.json"}
        , glue = {"net.eldiosantos.messenger.cucumber.testcases"}
)
public class CucumberTestIt {
}
