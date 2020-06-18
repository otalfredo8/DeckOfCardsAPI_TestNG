package deckofcards_tests;

import deckofcards_tests.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import configs.DeckOfCardsEndPoints;
import utilities.ResponseVerifier;

public class NewDeck_GET extends BaseTest {

    private static Response response;

    @BeforeMethod
    public void setUP_response(){
        response = RestAssured.given().when().get(DeckOfCardsEndPoints.NEW_DECK);
    }

    @Test
    public void newDeck_happyPath(){
        ResponseVerifier.statusCodeValidation(response, 200);
        ResponseVerifier.timeLessThan2000(response);
        ResponseVerifier.keyExistsInJSONObjectValidation(response, "deck_id");
        ResponseVerifier.keyValidationFromJsonObject(response, "remaining", "52");
    }

    @Test
    public void newDeck_Post(){



    }
}
