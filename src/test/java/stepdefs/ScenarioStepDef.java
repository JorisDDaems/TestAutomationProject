package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class ScenarioStepDef extends BaseClass {


    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {
        setUp();
    }

    /**
     * Method below: redundant : already happens in setup method above
     *
     */

    @And("I open the website")
    public void i_open_the_website() {
        driver.get("https://todomvc.com/");
    }

    /**
     * Method below: clicks on different input given in scenario outline
     *
     */

    @Given("I can click on the link {string}")
    public void iCanClickOnTheLink(String arg0) {
        vanillaJsPage.clickLink(arg0);
    }

    @When("I type in a todo {string}")
    public void iTypeInATodo(String arg0) {
        vanillaJsPage.enterText(arg0);
    }


    @Then("I can see a todo added to todo list")
    public void i_can_see_a_todo_added_to_todo_list() {
        Assert.assertEquals("Automation is fun!", vanillaJsPage.getResult());
    }

    @Then("I can see all todos added to todo list")
    public void iCanSeeAllTodosAddedToTodoList() {
        Assert.assertEquals(1, vanillaJsPage.getToDoListAmount());
    }


    @And("I can delete a todo")
    public void iCanDeleteATodo() {
        vanillaJsPage.deleteToDo(0);
        Assert.assertEquals(1, vanillaJsPage.getToDoListAmount());
    }

    @And("I can complete a todo")
    public void iCanCompleteATodo() {
        vanillaJsPage.selectCompleteCheckBox(2);
        Assert.assertEquals("owee a second string", vanillaJsPage.checkIfCheckBoxIsSelected());
        Assert.assertEquals(1, vanillaJsPage.amountOfCheckBoxesSelected());

    }


    @And("I can close the site")
    public void iCanCloseTheSite() {
        tearDown();
    }



    @When("I search a todo {string} I can change it to {string}")
    public void iSearchATodoICanChangeItTo(String arg0, String arg1) {
        vanillaJsPage.find(arg0);
        vanillaJsPage.modifyText(arg1);
    }

    @When("I change to completed todo page")
    public void iChangeToCompletedTodoPage() {
        vanillaJsPage.changeToCompletedPage();
    }

    @Then("completed todo page is empty, but there are still {string} todos")
    public void completedTodoPageIsEmptyButThereAreStillTodoS(String arg0) {
        Assert.assertEquals(0, vanillaJsPage.toDoListAmount());
        Assert.assertEquals(arg0, vanillaJsPage.amount());
    }

    @When("I change back to all todos page")
    public void iChangeBackToAllTodosPage() {
        vanillaJsPage.changeToAllPage();
    }

    @Then("completed todo page has {int} todo")
    public void completedTodoPageHasTodo(int arg0) {
        Assert.assertEquals(arg0, vanillaJsPage.amountOfCheckBoxesSelected());
    }
}

