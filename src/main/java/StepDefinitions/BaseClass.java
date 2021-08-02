package StepDefinitions;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import pages.HomePage;
import pages.VanillaJsPage;
import utilities.EventReporter;

public class BaseClass {

    public WebDriver driver;
    protected HomePage homePage;
    public VanillaJsPage vanillaJsPage;


    @BeforeClass
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        //driver.register(new EventReporter());
        driver.get("https://todomvc.com/");
        System.out.println(driver.getTitle());
        homePage = new HomePage(driver);
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }


    private ChromeOptions getChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        //chromeOptions.setHeadless(true);
        return chromeOptions;
    }



}
