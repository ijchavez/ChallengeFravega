package ChallengeFravega.Frontend;

import ChallengeFravega.Utilities.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;

    public TestBase(WebDriver remoteDriver){
        driver = remoteDriver;

    }
    public TestBase(){

    }
    @BeforeTest
    public void setUp(ITestContext context) throws AWTException, InterruptedException {
        System.setProperty(Constants.WEBDRIVER_CHROME, Constants.CHROMEDRIVER_FILE);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(Constants.FRAVEGA_URL);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);

    }
    @AfterTest
    public void closePage(){
        driver.close();
        if(driver != null) {
          driver.quit();

        }

    }

}
