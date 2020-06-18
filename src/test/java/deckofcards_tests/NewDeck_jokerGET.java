package deckofcards_tests;

import configs.DeckOfCardsEndPoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ExcelUtil;
import utilities.ResponseVerifier;

public class NewDeck_jokerGET extends BaseTest {
    private static Response response;

    @BeforeMethod
    public void response_setUp(){
        String filePath = "src/test/resources/test_data/deckofcardsapi_data.xlsx";
        ExcelUtil excelUtil = new ExcelUtil(filePath, "joker");

        boolean jokers_enabled = Boolean.parseBoolean(excelUtil.getCellData(1, 0));
        response = RestAssured.given().when().param("jokers_enabled", jokers_enabled).get(DeckOfCardsEndPoints.NEW_JOCKERS);
    }

    @Test
    public void newDeck_jokerGet(){
        ResponseVerifier.statusCodeValidation(response, 200);
        ResponseVerifier.keyExistsInJSONObjectValidation(response, "deck_id");
        ResponseVerifier.keyValidationFromJsonObject(response, "remaining", "54");
    }
}
