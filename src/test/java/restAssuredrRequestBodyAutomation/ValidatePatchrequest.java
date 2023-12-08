package restAssuredrRequestBodyAutomation;

import core.StatusCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ValidatePatchrequest {
    @Test
    public void validatePATCHRequestUsingString() {
        RestAssured.baseURI = "https://reqres.in";
        Response response = given()
                .header("Content-Type", "application/json")
                .body("{\"job\":\"SoftwareDevelopmentEngineerTest-1\"}")
                .when()
                .patch("/api/users/2");

        Assert.assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);
        System.out.println(response.getBody().asString());
        System.out.println("validatePatchRequestUsingString() executed Suceesfully");

    }

}
