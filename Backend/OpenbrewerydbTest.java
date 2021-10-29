package ChallengeFravega.Backend;

import ChallengeFravega.Utilities.Constants;
import ChallengeFravega.Utilities.Utilities;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;


public class OpenbrewerydbTest extends BaseTest {

    @Test
    public void openbrewerydbTest() {
        Utilities utils = new Utilities();
        HashMap<String,String> queryParams = new HashMap<String,String>();
        queryParams.put("query","lagunitas");

        Response response = utils.getSimpleResponseSendingParams(Constants.AUTOCOMPLETE, queryParams, "application/json");

        /*
         la respuesta es vacia, no sabria como seguir, continuo con la siguiente api, para que solamente me devuelva una y poder
         hacer asserts le paso otro parametro al hashmap by_name = "lagunitas"
         */
        String responseBody = utils.prettyPrintResponse(response);

        HashMap<String,String> queryParamsTwo = new HashMap<String,String>();
        queryParamsTwo.put("by_name","lagunitas");
        queryParamsTwo.put("by_state","california");

        System.out.println("====== Segundo Ejercicio =======");
        Response responseTwo = utils.getSimpleResponseSendingParams("", queryParamsTwo, "application/json");
        String responseBodyTwo = utils.prettyPrintResponse(responseTwo);

        JSONArray jsa = new JSONArray(responseBodyTwo);

        String name = utils.getStringFromJsonArray(jsa, "name");
        String street = utils.getStringFromJsonArray(jsa, "street");
        String phone = utils.getStringFromJsonArray(jsa, "phone");

        Assert.assertEquals(name, "Lagunitas Brewing Co", "El nombre " + name + " no es el esperado");
        Assert.assertEquals(street, "1280 N McDowell Blvd", "La calle " + street + " no es la esperada");
        Assert.assertEquals(phone, "7077694495", "El telefono " + phone + " no es el esperado");



    }

}
