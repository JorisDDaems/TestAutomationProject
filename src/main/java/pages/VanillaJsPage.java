package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import java.util.stream.Collectors;

public class VanillaJsPage extends HomePage {

    private WebDriver driver;
    private By inputField = By.className("new-todo");
    private By resultToDo = By.className("todo-list");
    //private By deleteButton = By.xpath("/html/body/section/section/ul/li[1]/div/button");

    public VanillaJsPage(WebDriver driver) {
        super(driver);
    }

    public void enterText(String text){
        driver.findElement(inputField).sendKeys(text, Keys.ENTER);
    }

    public String getResult(){
        return driver.findElement(resultToDo).getText();
    }


    /**
     *
     *
     */

    public int getToDoListAmount(){

        WebElement button= driver.findElement(By.xpath("//*[@class='todo-count']"));
        List<WebElement> buttonCount = button.findElements(By.tagName("strong"));
        return (int) buttonCount.stream().map(WebElement::getText).count();
    }

    public int toDoListAmount(){

        By todoList = By.className("todo-list");
        int todoLists = (int) driver.findElements(todoList).stream().count()-1;

        return todoLists;
    }



    /**
     *
     * Possible to select which element you delete by changing the number at line 58 at []
     * index starts at 0
     */

    public void deleteToDo(int index){

        JavascriptExecutor js = null;
        if (driver instanceof JavascriptExecutor) {
            js = (JavascriptExecutor) driver;
        }
        js.executeScript("return document.getElementsByClassName('view')["+ index + "].remove();");
    }

    public void selectCompleteCheckBox(int index){
        By checkBox = By.xpath("/html/body/section/section/ul/li["+ index +"]/div/input");
        driver.findElement(checkBox).click();
    }

    public String checkIfCheckBoxIsSelected(){

        By todoChecked = By.className("completed");
        return driver.findElement(todoChecked).getText();
    }

    public int amountOfCheckBoxesSelected(){

        List<WebElement> buttonCount = driver.findElements(By.className("completed"));
        return (int) buttonCount.stream().map(WebElement::getText).count();
    }



    public String find(String sentence){

        List<WebElement> toDoElements = driver.findElements(By.className("view"));
        List<String> toDoList = toDoElements.stream().map(WebElement::getText).collect(Collectors.toList());
        String Element = toDoList.get(1);
        String element = toDoList.stream().filter(e->e.equals(sentence)).toString();

        return Element;
    }


    public void modifyText(String newInput){
        WebElement listElements = driver.findElements(By.className("view")).get(1);

        Actions actions = new Actions(driver);
        actions.moveToElement(listElements).doubleClick()
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(newInput)
                .perform();

        WebElement outsideElement = driver.findElement(By.className("info"));
        outsideElement.click();
    }

    public void changeToCompletedPage(){

        By completedPage = By.xpath("//a[@href='#/completed']");
        driver.findElement(completedPage).click();
    }


    public void changeToAllPage(){

        By allPage = By.xpath("//a[@href='#/']");
        driver.findElement(allPage).click();
    }



    public String amount() {

        return driver.findElement(By.tagName("strong")).getText();

    }


}
