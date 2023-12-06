package usermanagement;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class getResponseBodyAut {
    @Test
    public void getResponseBody() {
        // Set base URI for the API
        RestAssured.baseURI = "https://URI";

        given().when().get("api/endPoint")
                .then()
                .statusCode(401)
                .body(not(isEmptyString()))
                .assertThat()
                .body("message", equalTo("Token doesn't exist or is invalid"))
                .body("status", equalTo(401));
    }
}
