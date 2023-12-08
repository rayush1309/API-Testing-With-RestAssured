package restAssuredrRequestBodyAutomation;

import core.StatusCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class ValidatePostRequestbodyAut {

    @Test
    public void validatePostWithString(){
        RestAssured.baseURI="https://reqres.in";
        Response response=
                given()
                        .header("Content-Type","application/json")
                        .body("{\"name\":\"ayush\",\"job\":\"SoftwareEngineer\"}")
                        .when()
                        .post("/api/users");
        Assert.assertEquals(response.getStatusCode(), StatusCode.CREATED.code);
        System.out.println(response.getBody().asString());
        System.out.println("PostWithString Executed sucessfully");


    }

}
