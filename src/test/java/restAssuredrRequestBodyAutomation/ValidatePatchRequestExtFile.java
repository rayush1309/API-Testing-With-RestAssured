package restAssuredrRequestBodyAutomation;

import core.StatusCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ValidatePatchRequestExtFile extends ValidatePostRequestBody3Ways {

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
        System.out.println("validatePATCHRequestUsingString() executed Successfully");

    }

    @Test
    public void validatePATCHRequestUsingJson() {
        RestAssured.baseURI = "https://reqres.in";
        try {
            Response response = given()
                    .header("Content-Type", "application/json")
                    .body(IOUtils.toString(fileInputStreamMethod("patchRequestBody.json")))
                    .when()
                    .patch("/api/users/2");

            Assert.assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);
            System.out.println(response.getBody().asString());
            System.out.println("validatePATCHRequestUsingJson() executed Successfully");
        } catch (FileNotFoundException e) {
            // Handle the exception or print an error message
            e.printStackTrace();
        } catch (IOException e) {
            // Handle other IOException if needed
            e.printStackTrace();
        }
    }



}
