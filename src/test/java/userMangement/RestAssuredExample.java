package userMangement;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredExample {
    public static void main(String[] args) {
        // Given
        RestAssured.given()
                .param("key1", "value1")
                .header("Authorization", "Bearer your_token")
                .contentType(ContentType.JSON)
                .body("{\"name\": \"John\"}")
                // When
                .when()
                .post("https://reqres.in/api/users/2")
                // Then
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("id", equalTo(123))
                .body("name", equalTo("John"));
    }


}
