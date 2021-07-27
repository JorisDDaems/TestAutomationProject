package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import utilities.EventReporter;

public class BaseTests {

    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        driver.get("https://todomvc.com/");
        System.out.println(driver.getTitle());
        homePage = new HomePage(driver);
    }

    /*
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

     */

    private ChromeOptions getChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        //chromeOptions.setHeadless(true);
        return chromeOptions;
    }


    public static void main(String[] args) {

        BaseTests test = new BaseTests();
        test.setUp();
        //test.tearDown();
    }

}
