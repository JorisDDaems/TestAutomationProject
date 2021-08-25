import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
git
@RunWith(Cucumber.class)

@CucumberOptions(features = "features/Scenario.feature", publish = true,
        glue = "stepdefs", dryRun = false)
public class TestRunner {
}
