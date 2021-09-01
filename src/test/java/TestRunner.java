import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/main/resources/features/Scenario.feature", publish = true,
        glue = "stepdefs", dryRun = false)
public class TestRunner {
}
