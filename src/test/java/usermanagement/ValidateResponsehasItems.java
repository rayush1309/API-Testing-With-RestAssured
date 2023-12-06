package usermanagement;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class ValidateResponsehasItems {

    @Test
    public void responseValidation(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        //send Get request and store the response in a varriable
        Response response=
                         given()
                        .when()
                        .get("/posts")
                                 .then()
                                 .extract()
                                 .response();
        assertThat(response.jsonPath().getList("title"),
                hasItems("sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                        "qui est esse"));




    }
}
