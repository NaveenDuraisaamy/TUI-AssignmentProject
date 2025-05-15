package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = {"stepdefinitions"},
       // dryRun = true,
        tags = "@TUIHotels",
//        snippets = CucumberOptions.SnippetType.CAMELCASE,
//        monochrome = true,
//        publish = true,
plugin = {
                "pretty",
                "html:target/cucumber/report.html",
                "json:target/cucumber/report.json",
                "junit:target/cucumber/result.xml"
        }
)
public class TestRunner {
}