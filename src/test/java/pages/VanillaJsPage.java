package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class VanillaJsPage {

    public WebDriver vanillaDriver;

    public VanillaJsPage(WebDriver vDriver) {
        vanillaDriver = vDriver;
        PageFactory.initElements(vDriver, this);
    }

    @FindBy(className = "new-todo")
    @CacheLookup
    WebElement inputField;

    @FindBy(className = "todo-list")
    @CacheLookup
    WebElement resultToDo;


    @FindBy(xpath = "/html/body/section/section/ul/li[1]/div/button")
    @CacheLookup
    WebElement deleteButton;



    public void clickLink(String linkText){
        vanillaDriver.findElement(By.linkText(linkText)).click();
    }


    public void enterText(String text){
        inputField.sendKeys(text, Keys.ENTER);
    }

    public String getResult(){
        return resultToDo.getText();
    }


    /**
     *
     *
     */

    public int getToDoListAmount(){

        WebElement button= vanillaDriver.findElement(By.xpath("//*[@class='todo-count']"));
        List<WebElement> buttonCount = button.findElements(By.tagName("strong"));
        return (int) buttonCount.stream().map(WebElement::getText).count();
    }

    public int toDoListAmount(){

        By todoList = By.className("todo-list");

        return (int) vanillaDriver.findElements(todoList).stream().count()-1;
    }



    /**
     *
     * Possible to select which element you delete by changing the number at line 58 at []
     * index starts at 0
     */

    public void deleteToDo(int index){

        JavascriptExecutor js = null;
        if (vanillaDriver instanceof JavascriptExecutor) {
            js = (JavascriptExecutor) vanillaDriver;
        }
        js.executeScript("return document.getElementsByClassName('view')["+ index + "].remove();");
    }



    public void selectCompleteCheckBox(int index){
        By checkBox = By.xpath("/html/body/section/section/ul/li["+ index +"]/div/input");
        vanillaDriver.findElement(checkBox).click();
    }


    @FindBy(className = "completed")
    @CacheLookup
    WebElement todoChecked;

    public String checkIfCheckBoxIsSelected(){

        //By todoChecked = By.className("completed");
        return todoChecked.getText();
    }

    public int amountOfCheckBoxesSelected(){

        List<WebElement> buttonCount = vanillaDriver.findElements(By.className("completed"));
        return (int) buttonCount.stream().map(WebElement::getText).count();
    }




    public String find(String sentence){

        List<WebElement> toDoElements = vanillaDriver.findElements(By.className("view"));
        List<String> toDoList = toDoElements.stream().map(WebElement::getText).collect(Collectors.toList());
        String Element = toDoList.get(1);
        String element = toDoList.stream().filter(e->e.equals(sentence)).toString();

        return Element;
    }


    public void modifyText(String newInput){
        WebElement listElements = vanillaDriver.findElements(By.className("view")).get(1);

        Actions actions = new Actions(vanillaDriver);
        actions.moveToElement(listElements).doubleClick()
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(newInput)
                .perform();

        WebElement outsideElement = vanillaDriver.findElement(By.className("info"));
        outsideElement.click();
    }

    public void changeToCompletedPage(){

        By completedPage = By.xpath("//a[@href='#/completed']");
        vanillaDriver.findElement(completedPage).click();
    }


    public void changeToAllPage(){

        By allPage = By.xpath("//a[@href='#/']");
        vanillaDriver.findElement(allPage).click();
    }



    public String amount() {

        return vanillaDriver.findElement(By.tagName("strong")).getText();

    }


}
