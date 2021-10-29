package ChallengeFravega.Frontend.Pages;

import ChallengeFravega.Frontend.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeladeraFreezerCavasPage extends TestBase {
    public HeladeraFreezerCavasPage(WebDriver remoteDriver) {
        driver = remoteDriver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(name="brandAggregation")
    List<WebElement> brandAggregationList;
    public List<WebElement> getBrandAggregationList(){
        return brandAggregationList;

    }
    @FindBy(xpath="//*[@rel='bookmark']")
    List<WebElement> bookmarkList;
    public List<WebElement> getBookmarkList(){
        return bookmarkList;

    }
    @FindBy(xpath="//*[contains(text(),'resultados')]")
    WebElement pageResults;
    public WebElement getPageResults(){
        return pageResults;

    }
    @FindBy(xpath="//*[contains(text(),'Siguiente')]")
    WebElement goToNextPage;
    public void goToNextPageLink(){
        goToNextPage.click();

    }
    @FindBy(xpath = "//*[@itemtype='https://schema.org/BreadcrumbList']")
    WebElement breadCrumb;
    public WebElement getBreadCrumbElement(){
        return breadCrumb;

    }


}