package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public WebDriver hDriver;

    public HomePage(WebDriver driver) {
        this.hDriver = driver;
        PageFactory.initElements(hDriver, this);
    }

    public VanillaJsPage clickVanillaJs(String string){
        clickLink(string);
        return new VanillaJsPage(hDriver);
    }


    private void clickLink(String linkText){
        hDriver.findElement(By.linkText(linkText)).click();
    }
}
