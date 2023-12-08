package restAssuredApiFramewok;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class ValidateGetuserListWithMultipleHeaders {
    @Test
    public void validateMultipleHeaders(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        given()
                .header("application/json","application/json")
                .header("Authorization","Bearer your_access_token")
                .when()
                .get("posts/1")
                .then()
                .statusCode(200);
        System.out.println("Multiple Headers Automated Successfully");
    }

}
