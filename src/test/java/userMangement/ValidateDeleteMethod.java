package userMangement;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ValidateDeleteMethod {
    @Test
    public void validateDeleteStatusCode(){
        Response resp= given()
                .delete("https://reqres.in/api/users/2");
        assertEquals(resp.getStatusCode(),204);
        System.out.println("Delete Method Executed Sucessfully"+"No Content: "+"204 Status Code");
    }

}
