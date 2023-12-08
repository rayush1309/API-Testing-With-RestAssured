package restAssuredApiFramewok;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getResponseBodyAut {
    @Test
    public void getResponseBody() {
        // Set base URI for the API
        RestAssured.baseURI = "https://stageapp.tekioncloud.xyz";
        given().when().get("api/wms/parts/u/inventory/utility/extended/report/compute/all-sites")
                .then()
                .statusCode(401)
                .assertThat()
                .body("message", equalTo("Token doesn't exist or is invalid"))
                .body("status", equalTo(401));
    }

}
