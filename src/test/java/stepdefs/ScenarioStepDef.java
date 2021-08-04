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
        /*
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        vanillaJsPage = new VanillaJsPage(driver);
         */
    }

    @And("I open the website")
    public void i_open_the_website() {
        driver.get("https://todomvc.com/");
    }


    @Given("I can click on the link {string}")
    public void iCanClickOnTheLink(String arg0) {

        vanillaJsPage.clickLink(arg0);

        //driver.findElement(By.linkText(arg0)).click();

    }


    @When("I type in a todo {string}")
    public void iTypeInATodo(String arg0) {

        vanillaJsPage.enterText(arg0);
        //driver.findElement(By.className("new-todo")).sendKeys(arg0, Keys.ENTER);
    }

    @Then("I can see a todo added to todo list")
    public void i_can_see_a_todo_added_to_todo_list() {
        Assert.assertEquals("Automation is fun!", vanillaJsPage.getResult());
    }


    @And("I can close the site")
    public void iCanCloseTheSite() {
        tearDown();
    }
}
