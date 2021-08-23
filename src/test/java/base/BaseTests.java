package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

public class BaseTests {

    private static WebDriver driver;
    protected static HomePage homePage;


    @BeforeClass
    public static void launchApplication(){
        setChromeDriverProperty();
        driver = new ChromeDriver();
        driver.get("https://todomvc.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void closeBrowser(){
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

