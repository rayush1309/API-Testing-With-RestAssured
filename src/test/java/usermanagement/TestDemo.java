package usermanagement;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;


public class TestDemo {

    @Test
    public void getData() {
        // Given
        RestAssured.given()
                .baseUri("https://preprodfrapp-eu-west.tekion.xyz/api/wms/u/vendor/partDetails/process/bulk/vendorPartDetails")
                // When
                .when()
                .get("/u/vendor/partDetails/process/bulk/vendorPartDetails")

                // Then
                .then()
                .statusCode(401)
                .contentType("application/json");
    }


}
