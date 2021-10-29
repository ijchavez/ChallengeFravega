package ChallengeFravega.Frontend;

import ChallengeFravega.Frontend.Pages.HeladeraFreezerCavasPage;
import ChallengeFravega.Frontend.Pages.LandingPage;
import ChallengeFravega.Utilities.Utilities;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ChallengeFravega extends TestBase{
    @Test
    public void automationChallengeTest(){
        Utilities utils = new Utilities(driver);
        LandingPage landingPage = utils.startTest();

        landingPage.clickOnzipCodePopUp();

        WebElement searchInput = landingPage.getSearchInputBox();

        String wordToSearch = "Heladera";
        utils.sendKeysToAnElement(searchInput, wordToSearch);

        List<WebElement> buttonList = landingPage.getButtonList();
        utils.clickOnAWebElementFromAList(buttonList, 0);

        HeladeraFreezerCavasPage heladeraFreezerCavasPage = landingPage.clickOnHeladeraFilter();
        List<WebElement> brandList = heladeraFreezerCavasPage.getBrandAggregationList();

        int firstBrand = 0;
        String firstBrandName = utils.getTextFromAnElement(brandList.get(firstBrand));

        utils.clickOnAWebElementFromAList(brandList, firstBrand);

        WebElement pageResults = heladeraFreezerCavasPage.getPageResults();
        String pageResultsText = utils.getTextFromAnElement(pageResults);

        String numberResultsText = utils.makeSplit(pageResultsText, " ", 0);
        int numberResults = utils.parseAString(numberResultsText);

        List<WebElement> bookmarkListFirstPage = heladeraFreezerCavasPage.getBookmarkList();
        List<String> list = new ArrayList<String>();

        for(WebElement el : bookmarkListFirstPage) {
            list.add(el.getText());

        }
        utils.scrollToADirection("2100");
        heladeraFreezerCavasPage.goToNextPageLink();

        List<WebElement> bookmarkListSecondPage = heladeraFreezerCavasPage.getBookmarkList();
        for(WebElement el : bookmarkListSecondPage){
            list.add(el.getText());

        }
        for(String item : list){
            Assert.assertTrue(item.contains(wordToSearch), "El item no contiene la palabra: " + wordToSearch);

        }
        Assert.assertEquals(numberResults, list.size(), "La cantidad de resultados es incorrecta");

        WebElement breadCrumb = heladeraFreezerCavasPage.getBreadCrumbElement();
        String breadCrumbText = utils.getTextFromAnElement(breadCrumb);

        Assert.assertTrue(breadCrumbText.contains(wordToSearch), wordToSearch + " no se encuentra en el breadcrumb");

    }

}
