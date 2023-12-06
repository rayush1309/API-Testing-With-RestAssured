package usermanagement;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;


public class TestDemo {

    @Test
    public void getData() {
        // Given
        RestAssured.given()
                .baseUri("https:URIils")
                // When
                .when()
                .get("/u/endPoint")

                // Then
                .then()
                .statusCode(401)
                .contentType("application/json");
    }


}
