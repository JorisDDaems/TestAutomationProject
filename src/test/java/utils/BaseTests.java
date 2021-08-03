package utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.HomePage;
import pages.VanillaJsPage;

public class BaseTests {

    private static WebDriver driver;
    protected static HomePage homePage;

    @BeforeClass
    public static void setUp(){
        setChromeDriverProperty();
        driver = new ChromeDriver();
        driver.get("https://todomvc.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public static WebDriver getWebDriver(){
        return driver;
    }

    private static void setChromeDriverProperty(){
        if(System.getProperty("os.name").contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        }
        else{
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        }
    }


}
