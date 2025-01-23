package TestRunner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"StepDefinitions" },
        monochrome = true,
        tags = "@smoke",
        plugin = { "pretty", "html:target/cucumber-reports", "json:target/cucumber.json" })
public class SerenityRunner {
}
