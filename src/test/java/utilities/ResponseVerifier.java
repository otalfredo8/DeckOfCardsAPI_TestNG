package utilities;

import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ResponseVerifier extends ListenerWithReport {

    public static void statusCodeValidation(Response response, int statusCode) {
        try {
            assertThat(response.getStatusCode(), equalTo(statusCode));
            extentTest.log(LogStatus.PASS, "StatusCode Validation Successful (" + response.getStatusCode() + ")");
        } catch (AssertionError e) {
            extentTest.log(LogStatus.FAIL, "StatusCode Validation Failed. " +
                    "Expected = " + statusCode + " Actual = " + response.getStatusCode());
            extentTest.log(LogStatus.FAIL, e.fillInStackTrace());
        }
    }

    public static void keyValidationFromJSONArraysFirstObject(Response response, String key, String value) {
        JSONArray jsonArray = new JSONArray(response.getBody().asString());
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject.get(key).toString().equalsIgnoreCase(value))
                    extentTest.log(LogStatus.INFO, "Expected value " + value + " Actual value " + jsonObject.get(key));
            }
        }catch (JSONException e) {
            extentTest.log(LogStatus.FAIL, e.fillInStackTrace());
        }
    }

    public static void keyValidationFromAnywhereInJSONArray(Response response, String key, String value) {
        try {
            JSONArray jsonArray = new JSONArray(response.getBody().asString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String actualValue = jsonObject.get(key).toString();
                if (actualValue.equalsIgnoreCase(value))
                    extentTest.log(LogStatus.INFO, "Expected value " + value + " Actual value " + jsonObject.get(key));
            }
        } catch (JSONException e) {
            extentTest.log(LogStatus.FAIL, e.fillInStackTrace());
        }
    }

    public static void timeLessThan2000(Response response){
        try {
            Assert.assertEquals(JavaUtils.isMoreThanZeroAndLessThan2000(response.getTime()), true);
            extentTest.log(LogStatus.INFO, "Response time " + response.getTime() + " is less than 1000");
        }catch (AssertionError e){
            extentTest.log(LogStatus.FAIL, e.fillInStackTrace());
            extentTest.log(LogStatus.INFO, "Response time is higher than Expected Time: " + response.getTime());

        }
    }

    public static void keyExistsInJSONObjectValidation(Response response, String key){
        try {
            JSONObject jsonObject = new JSONObject(response.getBody().asString());
            if (jsonObject.has(key) && jsonObject.get(key) != null) {
                extentTest.log(LogStatus.PASS, "Key " + key + " is present");
            }else {
                extentTest.log(LogStatus.FAIL, "Key: " + key + " is not present");
            }
        }catch (Exception e){
            extentTest.log(LogStatus.FAIL, "Key: " + key + " is not present EXCEPTION");
        }
    }

    public static void keyValidationFromJsonObject(Response response, String key, String value){
        try {
            JSONObject jsonObject = new JSONObject(response.getBody().asString());
            if (jsonObject.has(key) && jsonObject.get(key) != null && jsonObject.get(key).toString().equalsIgnoreCase(value)){
                extentTest.log(LogStatus.PASS, "Success. The value of " + key + " is " + jsonObject.get(key));
            }else {
                extentTest.log(LogStatus.FAIL, "Key is not available");
            }
        }catch (Exception e){
            extentTest.log(LogStatus.FAIL, "Key is not available");
        }
    }

    public static void keyValuesFromJsonArray (Response response, String key) {
        try {
            JSONArray array = new JSONArray(response.getBody().asString());
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                extentTest.log(LogStatus.INFO, "Key values are " + jsonObject.get(key));
            }
        }catch(Exception e){
            extentTest.log(LogStatus.FAIL, e.fillInStackTrace());
        }
    }
}
