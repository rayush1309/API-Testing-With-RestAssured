package restAssuredApiFramewok;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;

public class TestNGSuiteDesign2 {
    //way-1:
    @Test(groups = "smoke")
    public void validateCookie() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        given()
                .cookie("cookie1", "test1")
                .cookie("cookie1", "test2")
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200);
        System.out.println("Cookie Validation executed Successfully");
    }
    @Test(groups = {"Regression","smoke"})
    public void testCookieUsingCookieBuilder() {
        // Set the base URI for your API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        // Create a Cookie object
        Cookie cookies = new Cookie.Builder("cookieKey1", "cookieValue1")
                .setComment("using Cookie key")
                .build();
        // Perform a GET request using the specified cookies
        given()
                .cookie(cookies)
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200);
        System.out.println("Cookie Validation executed Successfully using Cookie Builder");
    }
    @Test
    public void fetchCookieFromResponse(){
        // Set the base URI for your API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        // Perform a GET request to the endpoint "/posts/1" and store the response
        Response response = given()
                .when()
                .get("/posts/1")
                .then()
                .extract().response();
        // Get all the cookies from the response and store them in a Map
        Map<String,String> map = response.getCookies();
        // Get detailed information about all the cookies from the response
        Cookies cookie = response.getDetailedCookies();
        // Get the value of the "Server" cookie from the detailed cookies
        cookie.getValue("Server");
        // Assert that the Map of cookies has a key named "3638382Ayys73"
        assertThat(map, hasKey("3638382Ayys73"));
        // Assert that the Map of cookies has a value "test72773"
        assertThat(map, hasValue("test72773"));
    }



}
