package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.VanillaJsPage;

public class ScenarioStepDef {

    WebDriver driver;
    HomePage homePage;
    VanillaJsPage vanillaJsPage;

    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("I open the website")
    public void i_open_the_website() {
        driver.get("https://todomvc.com/");
    }


    @Given("I can click on the link {string}")
    public void iCanClickOnTheLink(String arg0) {

        driver.findElement(By.linkText(arg0)).click();

    }


    @When("I type in a todo {string}")
    public void iTypeInATodo(String arg0) {

        driver.findElement(By.className("new-todo")).sendKeys(arg0, Keys.ENTER);
    }

    @Then("I can see a todo added to todo list")
    public void i_can_see_a_todo_added_to_todo_list() {

        Assert.assertEquals("Automation is fun!", driver.findElement(By.className("todo-list")).getText());
    }


}
