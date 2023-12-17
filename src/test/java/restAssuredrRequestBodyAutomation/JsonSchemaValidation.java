package restAssuredrRequestBodyAutomation;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class JsonSchemaValidation {

    @Test
    public void jsonSchemaValidation(){
        File schema = new File("resources/ExpectedSchema.json");
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(schema));
        System.out.println(JsonSchemaValidator.matchesJsonSchema(schema));


    }


}
