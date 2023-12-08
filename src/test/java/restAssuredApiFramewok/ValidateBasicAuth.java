package restAssuredApiFramewok;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class ValidateBasicAuth {
    @Test
    public void validateBasicAuthentication(){
        // Set the base URI for the RestAssured requests
        RestAssured.baseURI = "https://postman-echo.com";
        // Send a GET request with basic authentication
        Response response =
                given()
                        .auth()
                        .basic("postman", "password")
                        .when()
                        .get("/basic-auth");
        // Retrieve the actual status code from the response
        int actualStatusCode = response.statusCode();
        // Assert that the actual status code is equal to the expected status code (200)
        assertEquals(actualStatusCode, 200);
        // Print the response body as a string
        System.out.println(response.body().asString());
    }
    //DigestAuth :
            @Test
    public void validateDigestAuthenticationInResponse() {
        RestAssured.baseURI = "https://postman-echo.com";
        Response response =
                given()
                        .auth()
                        .digest("postman", "password")
                        .when()
                        .get("/digest-auth");
        int actualStatusCode = response.statusCode();
        assertEquals(actualStatusCode, 200);
        System.out.println(response.body().asString());
    }


}
