package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Joris\\Desktop\\INTEC\\BenchAssignmentUIAutomation\\Features\\ToDoScenarios.feature",
        glue = "cucumber/stepdefs")

public class TestRunner {
}
