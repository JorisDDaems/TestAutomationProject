package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.VanillaJsPage;

public class ToDoScenarios extends BaseClass {



    @Given("User clicks on implementation as {string}")
    public void userClicksOnImplementationAs(String impl) {

        clickLink(impl);
        //return new VanillaJsPage(driver);

    }


        private void clickLink(String linkText){
            driver.findElement(By.linkText(linkText)).click();
        }




    @Given("User can see ToDoList")
    public void user_can_see_ToDoList() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User can make TodoList")
    public void user_can_make_TodoList() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User types in inputfield {string}")
    public void user_types_in_inputfield(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User clicks on enter button")
    public void user_clicks_on_enter_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User can see new todo in todolist")
    public void user_can_see_new_todo_in_todolist() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
