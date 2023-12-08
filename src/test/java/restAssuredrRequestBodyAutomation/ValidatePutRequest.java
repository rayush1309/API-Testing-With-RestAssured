package restAssuredrRequestBodyAutomation;

import core.StatusCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class ValidatePutRequest {

    @Test
    public void validatePutRequestUsingString() {
        RestAssured.baseURI = "https://reqres.in";
        Response response = given()
                .header("Content-Type", "application/json")
                .body("{\"name\":\"ayushRaj\",\"job\":\"SET\"}")
                .when()
                .put("/api/users/346");

        Assert.assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);
        System.out.println(response.getBody().asString());
        System.out.println("validatePutRequestUsingString() executed Suceesfully");

    }
}