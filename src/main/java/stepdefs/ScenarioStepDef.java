package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.VanillaJsPage;

public class ScenarioStepDef {

    HomePage homePage;
    VanillaJsPage vanillaJsPage;


    @Given("I can click on the link")
    public void i_can_click_on() {
        homePage.clickVanillaJs();
    }

    @When("I click on todo field")
    public void i_click_on_todo_field() {

        throw new io.cucumber.java.PendingException();
    }


    @When("I type in a todo {string}")
    public void iTypeInATodo(String arg0) {

        vanillaJsPage.enterText(arg0);

    }

    @Then("I can see a todo added to todo list")
    public void i_can_see_a_todo_added_to_todo_list() {

        Assert.assertEquals(vanillaJsPage.getResult(), "Automation is fun!");

    }

}
