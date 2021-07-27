package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoverPage {

    private static WebDriver driver;
    private By inputField = By.className("new-todo");
    private static By resultToDo = By.className("todo-list");
    private static By deleteButton = By.xpath("/html/body/section/section/ul/li[1]/div/button");

    public HoverPage(WebDriver driver) {
        this.driver = driver;
    }


    public static FigureCaption hoverOverList(int index){
        WebElement listElements = driver.findElements(resultToDo).get(index - 1);

        Actions actions = new Actions(driver);
        actions.moveToElement(listElements).perform();

        return new FigureCaption(listElements.findElement(deleteButton));
    }

    public void deleteListItem(){
        hoverOverList(1);
        driver.findElement(deleteButton).click();

    }

    public static class FigureCaption{

        private WebElement caption;
        private By header = By.xpath("/html/body/section/section/ul/li[1]/div[1]");
        private By link = By.xpath("/html/body/section/section/ul/li[1]/div/button");



        public FigureCaption(WebElement caption) {
            this.caption = caption;
        }

        public boolean isCaptionDisplayed(){
            return caption.isDisplayed();
        }

        public String getTitle(){
            return caption.findElement(header).getText();
        }

        public String getLink(){
            return caption.findElement(header).getAttribute("button");
        }

        public String getLinkText(){
            return caption.findElement(header).getText();
        }

        public void deleteToDo(){
            driver.findElement(link).click();
        }
    }


}
