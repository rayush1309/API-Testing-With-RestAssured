package restAssuredApiFramewok;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FormParamRestAssured {
    @Test
    public void validateFormParam() {
        //   RestAssured.baseURI = "https://reqres.in";
        Response resp = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("name", "John Doe")
                .formParam("job", "Developer")
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(415)
                .extract()
                .response();
        // Assert that response contains the correct name and job values
        resp.then().body("name", equalTo("John Doe"));
        resp.then().body("job", equalTo("Developer"));
    }

}
