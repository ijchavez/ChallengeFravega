package ChallengeFravega.Frontend.Pages;

import ChallengeFravega.Frontend.TestBase;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class LandingPage extends TestBase {
    public LandingPage(WebDriver remoteDriver) {
        driver = remoteDriver;
        PageFactory.initElements(driver, this);

    }
        @FindBy(xpath="//*[@fill='currentColor']")
    WebElement zipCodePopUp;
    public void clickOnzipCodePopUp(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(zipCodePopUp));

        zipCodePopUp.click();

    }
    @FindBy(name="keyword")
    WebElement searchInputBox;
    public WebElement getSearchInputBox(){
      return searchInputBox;

    }
    @FindBy(xpath="//button[@type='submit']")
    List<WebElement> buttonList;
    public List<WebElement> getButtonList(){
        return buttonList;

    }
    //button[@type='submit']
    @FindBy(xpath="//a[@href='/l/heladeras-freezers-y-cavas/heladeras/?keyword=Heladera']")
    WebElement heladeraFilter;
    public HeladeraFreezerCavasPage clickOnHeladeraFilter(){
        heladeraFilter.click();

        HeladeraFreezerCavasPage heladeraFreezerCavas = new HeladeraFreezerCavasPage(driver);
        return heladeraFreezerCavas;

    }

}