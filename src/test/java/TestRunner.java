import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = "features/Scenario.feature", publish = true,
        glue = "stepdefs", dryRun = false, monochrome = true, strict = true, plugin = {"pretty", "html:test-output"})
public class TestRunner {
}
