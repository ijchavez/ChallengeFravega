package ChallengeFravega.Utilities;

import ChallengeFravega.Frontend.Pages.LandingPage;
import ChallengeFravega.Frontend.TestBase;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Utilities extends TestBase {
    public Utilities(WebDriver remoteDriver){
        driver = remoteDriver;
        PageFactory.initElements(driver, this);

    }
    public Utilities(){

    }
    public LandingPage startTest(){
        LandingPage landingPage = new LandingPage(driver);

        return landingPage;

    }
    public void sendKeysToAnElement(WebElement aWebElement, String keysToSend){
        aWebElement.sendKeys(keysToSend);

    }
    public void clickOnAWebElementFromAList(List<WebElement> aListOfWebElements, int pos){
        WebElement anElementToClick = aListOfWebElements.get(pos);
        anElementToClick.click();

    }
    public String getTextFromAnElement(WebElement aWebElement){
        String textFromWebElement = aWebElement.getText();
        return textFromWebElement;

    }
    public String makeSplit(String aString, String aSplitter, int pos){
        String[] stringToSplit = aString.split(aSplitter);

        String aStringSplitted = stringToSplit[pos];
        return aStringSplitted;

    }
    public int parseAString(String aString){
        int number = Integer.parseInt(aString);
        return number;

    }
    public void scrollToADirection(String aDirection) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0," + aDirection + ")");

    }
    public Response getSimpleResponseSendingParams(String aResource, HashMap<String, String> aHashMap, String aContentType){
        Response resp = given().log().all().header("Content-Type", aContentType)
                .queryParams(aHashMap)
                .when().log().all()
                .get(aResource);

        return resp;

    }
    public String prettyPrintResponse(Response aResponse){
        String responseBody = "";
        try{
            responseBody = aResponse.prettyPrint();
        }catch(NullPointerException npe){
            responseBody= "The response is null";
        }

        return responseBody;

    }
    public String getStringFromJsonArray(JSONArray aJsonArray, String aKey){
        String valueToReturn = "";

        for (int i = 0; i < aJsonArray.length(); i++) {
            try {
                JSONObject jsonObject = aJsonArray.getJSONObject(i);
                if (jsonObject.has(aKey)) {
                    valueToReturn = jsonObject.getString(aKey);

                }
            } catch (JSONException e) {
                e.printStackTrace();

            }

        }
        return valueToReturn;

    }
}
