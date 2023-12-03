package usermanagement;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class validateResponsehasSize {

    @Test
    public void validateresponseSize() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        //send Get request and store the response in a varriable
        Response response =
                given()
                        .when()
                        .get("/posts")
                        .then()
                        .extract()
                        .response();
        assertThat(response.jsonPath().getList(""),hasSize(100));


    }
}
