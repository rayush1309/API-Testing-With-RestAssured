package restAssuredApiFramewok;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


public class ValidatefirstListData {
    @Test
    public void responseFirstListDataValidation(){
        // Set Base URI for the API
        RestAssured.baseURI = "https://reqres.in/api";
        // Send a GET request and store the response in a variable
        // Sending GET Request and Extracting Response:
        Response response =
                given()
                        .queryParam("page",2)  // Adding query parameter "page" with a value of 2 to the request
                        .when()
                        .get("/users")  // Making a GET request to the "/users" endpoint
                        .then()
                        .extract()
                        .response();  // Extracting the response for further validation
        // Validating specific data in the response using Hamcrest matchers
        response.then().body("data[1].id", is(8));  // Checking if the value of "id" in the response matches the expected value 8
        response.then().body("data[1].email", is("lindsay.ferguson@reqres.in"));  // Checking if the value of "email" matches the expected value
        response.then().body("data[1].first_name", is("Lindsay"));  // Checking if the value of "first_name" matches the expected value "Lindsay"
        response.then().body("data[1].last_name", is("Ferguson"));  // Checking if the value of "last_name" matches the expected value "Ferguson"
        response.then().body("data[1].avatar", is("https://reqres.in/img/faces/8-image.jpg"));  // Checking if the value of "avatar" matches the expected value
    }

}
