package userManagement;

import core.StatusCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsonReader;

import java.io.IOException;
import org.json.simple.parser.ParseException;

import static io.restassured.RestAssured.given;

public class ValidateWithTestDataFromJson {

    @Test
    public void validateBasicAuthenticationWithTestData() throws IOException, ParseException {
        String userName = JsonReader.getTestData("username");
        String passWord = JsonReader.getTestData("password");
        RestAssured.baseURI = "https://postman-echo.com";
        Response response =
                given()
                        .auth()
                        .basic(userName, passWord)
                        .when()
                        .get("/basic-auth");

        int actualStatusCode = response.statusCode();
        Assert.assertEquals(actualStatusCode, StatusCode.SUCCESS.code);
       // System.out.println(response.body().asString());
    }

    @Test
    public void validateDigestAuthenticationInResponseUsingTestData() throws IOException, ParseException {
        String userName = JsonReader.getTestData("username");
        String passWord = JsonReader.getTestData("password");
        System.out.println("username is "+":"+ userName+" Password is: "+ passWord);
        RestAssured.baseURI = "https://postman-echo.com";
        Response response =
                given()
                        .auth()
                        .digest(userName, passWord)
                        .when()
                        .get("/digest-auth");

        int actualStatusCode = response.statusCode();
        Assert.assertEquals(actualStatusCode, StatusCode.SUCCESS.code);
        //System.out.println(response.body().asString());
    }
}
