package ChallengeFravega.Backend;

import ChallengeFravega.Utilities.Constants;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    @BeforeMethod
    public void setUp(){
        RestAssured.baseURI = Constants.OPENBREWERY_API_URL;

    }

}
