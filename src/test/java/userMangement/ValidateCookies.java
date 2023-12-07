package userMangement;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ValidateCookies {
    @Test
    public void validateCookie(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        given()
                .cookie("cookie1","test1")
                .cookie("cookie1","test2")
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200);
        System.out.println("Cookie Validation executed Successfully");
    }

}
