package userMangement;

import io.restassured.RestAssured;
import org.junit.Test;

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
