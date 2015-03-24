package net.eldiosantos.messenger.cucumber.testcases.home;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by eldio.junior on 24/03/2015.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:net/eldiosantos/messenger/cucumber/testcases/homepage/homepage.feature"}
        , format = {"pretty", "json:target/cucumber/homepage.json"}
        , glue = {"net.eldiosantos.messenger.cucumber.testcases"}
)
public class HitHomePageTestIt {
}
