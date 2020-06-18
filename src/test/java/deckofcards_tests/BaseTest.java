package deckofcards_tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import utilities.ListenerWithReport;

@Listeners(ListenerWithReport.class)
public class BaseTest extends ListenerWithReport {

    @BeforeClass
    public void baseURIsetUp(){
        RestAssured.baseURI = "https://deckofcardsapi.com/api/deck/";
    }
}
