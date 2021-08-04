package stepdefs;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.VanillaJsPage;

public class BaseClass {

    public WebDriver driver;
    //public HomePage homePage;
    public VanillaJsPage vanillaJsPage;


    @BeforeClass
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        vanillaJsPage = new VanillaJsPage(driver);
        driver.get("https://todomvc.com/");
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }





}
