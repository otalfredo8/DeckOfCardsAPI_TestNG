package deckofcards_tests;

import configs.DeckOfCardsEndPoints;
import configs.Headers;
import deckofcards_tests.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojos.CardPojo;
import utilities.ExcelUtil;
import utilities.ResponseVerifier;

public class NewDeck_jockerPOST extends BaseTest {

    private static Response response;

    @BeforeMethod
    public void responseSetUP(){

        String filePath = "src/test/resources/test_data/deckofcardsapi_data.xlsx";
        ExcelUtil excelUtil = new ExcelUtil(filePath, "joker");
        String jokers_enabled = excelUtil.getCellData(1, 0).toLowerCase();

        response = RestAssured
                .given().headers((new Headers()).jokerPostHeaders()).body(jokers_enabled)
                .when().get(DeckOfCardsEndPoints.NEW_JOCKERS);
    }

    //!!! Skipped test with a 403 status - No server access for POST requests
    @Test
    public void newDeck_jockerPost(){

        System.out.println(response.prettyPrint());

        ResponseVerifier.statusCodeValidation(response, 201);
        ResponseVerifier.timeLessThan2000(response);
        ResponseVerifier.keyExistsInJSONObjectValidation(response, "deck_id");
        ResponseVerifier.keyValidationFromJsonObject(response, "remaining", "54");
    }

}
