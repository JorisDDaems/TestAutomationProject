import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = "C:\\Users\\Joris\\Desktop\\INTEC\\BenchAssignmentUIAutomation\\features\\Scenario.feature",
        glue = "stepdefs", dryRun = false)
public class TestRunner {
}
