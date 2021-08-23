package stepdefs;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.VanillaJsPage;

public class BaseClass {

    public WebDriver driver;
    public VanillaJsPage vanillaJsPage;


    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        vanillaJsPage = new VanillaJsPage(driver);
        driver.get("https://todomvc.com/");
    }
    

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
