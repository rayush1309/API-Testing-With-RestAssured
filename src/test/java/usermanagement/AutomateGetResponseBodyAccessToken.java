package usermanagement;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AutomateGetResponseBodyAccessToken {

    // Replace these constants with your actual authentication details
    private static final String CLIENT_ID = "web";
    private static final String CLIENT_SECRET = "your_client_secret";
    private static final String TOKEN_URL = "your_token_url";

    private static String getAccessToken() {
        // Code to obtain the latest access token using OAuth2 client credentials grant flow
        Response tokenResponse = given()
                .param("client_id", CLIENT_ID)
                .param("client_secret", CLIENT_SECRET)
                .param("grant_type", "client_credentials")
                .when()
                .post(TOKEN_URL);

        // Extract the access token from the response
        return tokenResponse.jsonPath().getString("access_token");


    }

    @Test
    public void getResponseBody() {
        // Set base URI for the API
        RestAssured.baseURI = "https://stageapp.tekioncloud.xyz";

        // Get the latest access token
        String accessToken = getAccessToken();

        // Perform GET request with the obtained access token
        Response response = given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/api/wms/parts/u/inventory/utility/extended/report/compute/all-sites");

        // Validate response
        response.then()
                .statusCode(401)
                .assertThat()
                .body("message", equalTo("Token doesn't exist or is invalid"))
                .body("status", equalTo(401));

        // Print response details if needed
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
    }
}
