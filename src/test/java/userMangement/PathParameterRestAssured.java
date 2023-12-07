package userMangement;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PathParameterRestAssured {
    @Test
    public void validateResponseBodyGetPathParam() {
        // Set the value for the path parameter 'seasonvalue'
        String seasonValue = "2017";
        // Send a GET request with a path parameter and store the response
        Response resp = given()
                .pathParam("seasonvalue", seasonValue)  // Provide parameter name and value
                .when()
                .get("http://ergast.com/api/f1/{seasonvalue}/circuits.json");
        // Extract the status code from the response
        int actualStatusCode = resp.statusCode();
        // Assert that the status code is equal to the expected value (200)
        assertEquals(actualStatusCode, 200);
        // Print the response body to the console
        System.out.println(resp.body().asString());
    }
}
