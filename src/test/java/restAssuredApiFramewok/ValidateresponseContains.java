package restAssuredApiFramewok;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;

import static org.hamcrest.MatcherAssert.assertThat;

public class ValidateresponseContains {
    @Test
    public void validateresponseSize() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        //send Get request and store the response in a varriable
        Response response =
                given()
                        .when()
                        .get("/comments?postId=1")
                        .then()
                        .extract()
                        .response();
        List<String> expectedEmails = Arrays.asList("Eliseo@gardner.biz", "Jayne_Kuhic@sydney.com", "Nikita@garfield.biz",
                "Lew@alysha.tv", "Hayden@althea.biz");
        assertThat(response.jsonPath().getList("email"), contains(expectedEmails.toArray(new String[0])));
        //new String[0]:Not null String
    }
    }
