package restAssuredApiFramewok;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class validateResponsehasSize {
    @Test
    public void validateresponseSize() {
        // Set the base URI for the REST API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        // Send a GET request to the "/posts" endpoint and store the response in a variable
        Response response =
                given()
                        .when()
                        .get("/posts")
                        .then()
                        .extract()
                        .response();
        // Use Hamcrest's assertThat to perform assertions on the response
        assertThat(
                response.jsonPath().getList(""),
                hasSize(100)
        );
    }
    @Test
    public void validateresponseSize2() {
        // Set the base URI for the REST API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        // Send a GET request to the "/posts" endpoint and store the response in a variable
        Response response =
                given()
                        .when()
                        .get("/posts")
                        .then()
                        .extract()
                        .response();
        // Use Hamcrest's assertThat to perform assertions on the response
        assertThat(
                response.jsonPath().getList(""),
                hasSize(100)
        );
    }

}
