package restAssuredrRequestBodyAutomation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class API_Test {
    @Test
    public void apiTesting() {
        RestAssured.baseURI = "https://stageapp.tekioncloud.xyz";
        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .body("{\"name\":\"ayush\",\"job\":\"SoftwareEngineer\"}")
                        .when()
                        .get("/api/wms/p/health")
                        .then()
                        .extract()
                        .response();
        System.out.println(response.getBody().asString());

    }

}
