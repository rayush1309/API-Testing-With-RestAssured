package restAssuredApiFramewok;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ExampleTest {
    @Test
    public void exampleTest() {
        // Make a GET request and get the response
        Response response = given()
                .when()
                .get("https://api.example.com/users/1");
        // Use Hamcrest matchers to make assertions
        response.then()
                .statusCode(200)
                .header("Content-Type", Matchers.containsString("application/json"))
                .body("username", Matchers.equalTo("john_doe"))
                .body("age", Matchers.greaterThan(18));
    }

}
