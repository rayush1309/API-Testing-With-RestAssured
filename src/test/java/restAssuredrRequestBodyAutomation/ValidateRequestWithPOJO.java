package restAssuredrRequestBodyAutomation;

import core.StatusCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import poJo.PostRequestBody;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ValidateRequestWithPOJO {

    @Test
    public void validatePostWithPOJO() throws IOException, FileNotFoundException {
        PostRequestBody pr = new PostRequestBody();
        pr.setName("Ayush ");
        pr.setJob("Software Engineer-2");
        RestAssured.baseURI="https://reqres.in";
        Response response=
                given()
                        .header("Content-Type","application/json")
                        .body(pr)
                        .when()
                        .post("/api/users");
        Assert.assertEquals(response.getStatusCode(), StatusCode.CREATED.code);
        System.out.println(response.getBody().asString());
        System.out.println("PostWith JSon file Executed sucessfully");


    }
}
